package asymmetric.key;

import java.security.*;
import java.util.Base64;

public class GenerateKeyPair {

    public static void main(String[] args) throws Exception {

        // Create a Key Pair Generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        // Generate the key pair
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get the public and private keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Encode the public and private keys using Base64 encoder
        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        // Print the encoded public and private keys
        System.out.println("Public Key: " + encodedPublicKey);
        System.out.println("Private Key: " + encodedPrivateKey);
    }
}
