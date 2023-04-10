import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;

public class POJOEncryptionDecryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String SECRET_KEY = "secret-key-12345";

    public static <T> String encrypt(T object)
            throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(object);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedData = cipher.doFinal(json.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static <T> T decrypt(String encryptedData, Class<T> type)
            throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new String(decryptedData, StandardCharsets.UTF_8), type);
    }

    public static void main(String[] args) throws Exception {
        // POJO class to encrypt and decrypt
        Person person = new Person("John", "Doe", 30);
        
        // Encrypt POJO class using AES
        String encryptedData = POJOEncryptionDecryption.encrypt(person);
        System.out.println("Encrypted data: " + encryptedData);
        
        // Decrypt POJO class using AES
        Person decryptedPerson = POJOEncryptionDecryption.decrypt(encryptedData, Person.class);
        System.out.println("Decrypted data: " + decryptedPerson);

        // ====================== timestamp issue==============================

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json = objectMapper.writeValueAsString(timestamp.toString());
        System.out.println(json);


        Date startUserDate = new Date("02/20/2002");
        DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Previous date: "+df2.format(startUserDate));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String timeString = df.format(new Date()).substring(10); // 10 is the beginIndex of time here


        String startUserDateString = df2.format(startUserDate);

        startUserDateString = startUserDateString+" "+timeString;
// you will get this format "MM/dd/yyyy HH:mm:ss"

//then reparse the new date here
        startUserDate = df.parse(startUserDateString);
        System.out.println("Formatted date is: "+df.format(startUserDate));
// ====================== timestamp issue==============================
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

   /* // Includes crypto module
   // https://www.npmjs.com/package/crypto-js

    const crypto = require('crypto');
    const encryptedData = 'c/BEUqSbn2o48D+zBYFOANNB2f9repST7z93klGFdY0xhnrq0GRtFaGS3gSe4EWn';
    const secretKey = 'secret-key-12345';

    // Step 1: Decode Base64-encoded data to binary format
    const binaryData = Uint8Array.from(atob(encryptedData), c => c.charCodeAt(0));

    // Step 2: Decrypt binary data using AES
    const algorithm = 'AES-128-ECB';
    const key = Uint8Array.from(secretKey, c => c.charCodeAt(0));
    const decipher = crypto.createDecipheriv(algorithm, key, '');
    const decryptedData = Buffer.concat([decipher.update(binaryData), decipher.final()]);

    // Step 3: Decode decrypted binary data to string format
    const decryptedString = decryptedData.toString('utf-8');

    // Step 4: Parse decrypted string as JSON to get the original POJO object
    const originalPOJO = JSON.parse(decryptedString);
    console.log(originalPOJO);

    //===============================================

    Data encryption

    const crypto = require('crypto');
        // Step 1: Convert the original POJO object to a string
        const originalPOJO = {name: 'John Doe', age: 30};
        const originalString = JSON.stringify(originalPOJO);

        // Step 2: Convert the secret key to a binary format
        const secretKey = 'secret-key-12345';
        const key = Uint8Array.from(secretKey, c => c.charCodeAt(0));

        // Step 3: Encrypt the string using AES-128-ECB algorithm
        const algorithm = 'aes-128-ecb';
        const cipher = crypto.createCipheriv(algorithm, key, '');
        let encryptedData = cipher.update(originalString, 'utf-8', 'base64');
        encryptedData += cipher.final('base64');

        // Step 4: Print the encrypted data
        console.log(encryptedData);


       Encrypted Data:  uRFZYvWWQTlqDFAtvYLuBwtWbewtz+3AcLJBauIjAps=

    */
}
