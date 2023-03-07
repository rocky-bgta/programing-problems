import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecretKeyGenerator {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    private static final int SALT_SIZE = 16;

    public static SecretKey generateKey(String password) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);

        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom saltRandom = new SecureRandom(salt);
        keyGen.init(KEY_SIZE, saltRandom);

        return keyGen.generateKey();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "myPassword";
        SecretKey key = generateKey(password);
        System.out.println("Generated key: " + key);
    }
}