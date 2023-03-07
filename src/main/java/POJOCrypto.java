import org.apache.commons.lang3.SerializationUtils;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.Serializable;
import java.security.*;

public class POJOCrypto {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        return keyGen.generateKey();
    }

    public static byte[] encrypt(SecretKey key, Serializable obj) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] serialized = SerializationUtils.serialize(obj);
        return cipher.doFinal(serialized);
    }

    public static Object decrypt(SecretKey key, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] serialized = cipher.doFinal(encrypted);
        return SerializationUtils.deserialize(serialized);
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();

        Person alice = new Person("Alice", 30);

        byte[] encrypted = encrypt(key, alice);
        Person decrypted = (Person) decrypt(key, encrypted);

        System.out.println("Original POJO: " + alice);
        System.out.println("Encrypted POJO: " + new String(encrypted));
        System.out.println("Decrypted POJO: " + decrypted);
    }

    private static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}