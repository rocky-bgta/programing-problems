package encryption_private_public_key;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptDecryptRSAUtil {

    private static Logger log = LoggerFactory.getLogger(EncryptDecryptRSAUtil.class);


    public static void main(String[] args) throws Exception {

        /*You can generate a private key and public key pair with secret using openssl1. Here’s an example of how you can generate your private key using the RSA algorithm:

        $ openssl genrsa -aes256 -passout pass:secret -out private.key 2048
        This command generates a private key encrypted with password “secret” and saves it in a file named “private.key”.

        To extract your public key, use the following command:

        $ openssl rsa -in private.key -passin pass:secret -pubout -out public.key
        This command extracts your public key from the private key file and saves it in a file named “public.key”.

        You can replace “secret” with any password you want to use*/

        EncryptDecryptRSAUtil cryptoRSAUtil = new EncryptDecryptRSAUtil();

        Person person = new Person("John", "Doe", 30);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

       // String textToEncrypt = "I will back";
        log.debug("Encrypting text {} ", json);
        String encoded = cryptoRSAUtil.encode(json);
        log.debug("Encrypted result:");
        log.debug(encoded);
        log.debug("Decrypting result:");
        String decode = cryptoRSAUtil.decode(encoded);
        log.debug(decode);
    }


    public String encode(String toEncode) throws Exception {

        PublicKey publicKey = loadPublicKey();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(toEncode.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(bytes));
    }

    public String decode(String toDecode) throws Exception {

        PrivateKey privateKey = loadPrivateKey();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(toDecode));
        return new String(bytes);

    }

    private PublicKey loadPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        // reading from resource folder
        //byte[] publicKeyBytes = getClass().getResourceAsStream("/key.pub").readAllBytes();


        byte[] publicKeyBytes = new byte[0];
        try (DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream("/key.pub"))) {
            publicKeyBytes = new byte[dataInputStream.available()];
            dataInputStream.readFully(publicKeyBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = publicKeyFactory.generatePublic(publicKeySpec);
        return publicKey;
    }

    private PrivateKey loadPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        // reading from resource folder
       // byte[] privateKeyBytes = getClass().getResourceAsStream("/key.priv").readAllBytes();


        byte[] privateKeyBytes = new byte[0];
        try (DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream("/key.priv"))) {
            privateKeyBytes = new byte[dataInputStream.available()];
            dataInputStream.readFully(privateKeyBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey = privateKeyFactory.generatePrivate(privateKeySpec);
        return privateKey;
    }


    private static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
