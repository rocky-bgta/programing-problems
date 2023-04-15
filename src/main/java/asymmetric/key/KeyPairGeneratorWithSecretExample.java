package asymmetric.key;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class KeyPairGeneratorWithSecretExample {
    public static void main(String[] args) throws Exception {
        String secretKeyString = "MySecretKey123";
        byte[] salt = new byte[16]; // Generate a random salt
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        // Generate a secret key from the string
        SecretKey secretKey = generateSecretKey(secretKeyString, salt);

        // Generate a public-private key pair with the secret key
        KeyPair keyPair = generateKeyPair(secretKey);

        // Export the public key
        PublicKey publicKey = keyPair.getPublic();
        byte[] publicKeyBytes = publicKey.getEncoded();
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyBytes);

        // Export the private key
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] privateKeyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

        String publicKeyPEM = getPEM(publicKey);

        // Convert private key to OpenSSL format
        String privateKeyPEM = getPEM(privateKey);

        // Print keys
        System.out.println("Public key:\n" + publicKeyPEM);
        System.out.println("\nPrivate key:\n" + privateKeyPEM);


        // Print out the public and private keys
//        System.out.println("Public key:");
//        System.out.println(bytesToHex(publicKeyBytes));
//        System.out.println("Private key:");
//        System.out.println(bytesToHex(privateKeyBytes));
    }

    private static SecretKey generateSecretKey(String secretKeyString, byte[] salt) throws Exception {
        // Generate a secret key from the string using PBKDF2
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec keySpec = new PBEKeySpec(secretKeyString.toCharArray(), salt, 65536, 256);
        return keyFactory.generateSecret(keySpec);
    }

    private static KeyPair generateKeyPair(SecretKey secretKey) throws Exception {
        // Generate a public-private key pair with the secret key
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048, new SecureRandom(secretKey.getEncoded()));
        return keyPairGen.generateKeyPair();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
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
