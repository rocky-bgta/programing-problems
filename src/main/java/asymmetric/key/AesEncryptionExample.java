package asymmetric.key;

import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesEncryptionExample {

    public static void main(String[] args) throws Exception {
        String message = "This is a secret message";
        String password = "MySecretPassword";

        // Generate a random IV
        byte[] ivBytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Generate a secret key from the password
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = keyGenerator.generateKey();

        // Generate a public-private key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String publicKeyPEM = getPEM(publicKey);
        System.out.println("Public key:\n" + publicKeyPEM);

        // Encrypt the secret key with the public key using RSA encryption
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedSecretKeyBytes = rsaCipher.doFinal(secretKey.getEncoded());
        String encryptedSecretKeyString = Base64.getEncoder().encodeToString(encryptedSecretKeyBytes);

        // Encrypt the message with the secret key and IV using AES-128-CBC encryption
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encryptedMessageBytes = aesCipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        String encryptedMessageString = Base64.getEncoder().encodeToString(encryptedMessageBytes);

        System.out.println("Encrypted message: " + encryptedMessageString);

        // To decrypt the message, first decrypt the secret key with the private key using RSA decryption,
        // and then use the decrypted secret key to decrypt the message with AES-128-CBC decryption.

        // Decrypt the secret key with the private key using RSA decryption
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedSecretKeyBytes = rsaCipher.doFinal(Base64.getDecoder().decode(encryptedSecretKeyString));
        SecretKey decryptedSecretKey = new SecretKeySpec(decryptedSecretKeyBytes, 0, decryptedSecretKeyBytes.length, "AES");

        // Decrypt the message with the decrypted secret key and IV using AES-128-CBC decryption
        aesCipher.init(Cipher.DECRYPT_MODE, decryptedSecretKey, iv);
        byte[] decryptedMessageBytes = aesCipher.doFinal(Base64.getDecoder().decode(encryptedMessageString));
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

        System.out.println("Decrypted message: " + decryptedMessage);
    }

    private static String getPEM(Key key) throws Exception {
        byte[] keyBytes = key.getEncoded();
        String type;
        if (key instanceof PublicKey) {
            type = "PUBLIC";
        } else if (key instanceof PrivateKey) {
            type = "PRIVATE";
        } else {
            throw new IllegalArgumentException("Unsupported key type: " + key.getClass().getName());
        }
        return "-----BEGIN " + type + " KEY-----\n"
                + Base64.getEncoder().encodeToString(keyBytes)
                + "\n-----END " + type + " KEY-----";
    }
}
