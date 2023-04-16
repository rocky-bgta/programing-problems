package encryption_private_public_key;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class UtilPlainTextKeyGenerator {

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
