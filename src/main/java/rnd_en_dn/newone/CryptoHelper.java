package rnd_en_dn.newone;

import javax.crypto.Cipher;
import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
* Cryptography helper
*/
public class CryptoHelper {
    // https://mkyong.com/java/java-asymmetric-cryptography-example/
    // https://stackoverflow.com/questions/44681737/get-a-privatekey-from-a-rsa-pem-file
  
    public static void main(String[] args){
  
        try {
            // Key file names
           // String pubkeyfile = "../pbkey.pem";
            //String privateKeyfile = "../pvkey.pem";
            // https://acte.ltd/utils/openssl


            String pubkeyfile = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1IkMkTduzACmgj6b8cvR" +
                    "VXQ0Mun1/e1jxEmWy4Th7s/Hul5JXr9r4JCS6COWWsLnAd2QyPYu06YuSz6jgg2c" +
                    "yM+aor8BnMMQJfGVx1A8uqkAOin0BmHu7jagmS4Lp+z+NozyQRaD5rI9BcQbIrZt" +
                    "jkKADen+OWNYhuYatevoqPHeuLklNr7vcf87pZMCnc5LIsUh4gb8jP+S2kirEV8x" +
                    "HVsQpLQ8D4vbGJIThOP/elIzI5W3lMMSwcrOJa7KQjAGE2yqCy9dIHdK4y0R41mF" +
                    "hjoP3dJ1yW1LkVYtsuUpP825glQguG46xC6bQvRkuJ3h1Kr/wyUpvvpEGdE9qVqt" +
                    "hwIDAQAB";



            String privateKeyfile = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDUiQyRN27MAKaC" +
                    "Ppvxy9FVdDQy6fX97WPESZbLhOHuz8e6Xklev2vgkJLoI5ZawucB3ZDI9i7Tpi5L" +
                    "PqOCDZzIz5qivwGcwxAl8ZXHUDy6qQA6KfQGYe7uNqCZLgun7P42jPJBFoPmsj0F" +
                    "xBsitm2OQoAN6f45Y1iG5hq16+io8d64uSU2vu9x/zulkwKdzksixSHiBvyM/5La" +
                    "SKsRXzEdWxCktDwPi9sYkhOE4/96UjMjlbeUwxLBys4lrspCMAYTbKoLL10gd0rj" +
                    "LRHjWYWGOg/d0nXJbUuRVi2y5Sk/zbmCVCC4bjrELptC9GS4neHUqv/DJSm++kQZ" +
                    "0T2pWq2HAgMBAAECggEBAKxiTJMsRu2oSWWyqoHAMxYAnqX9JczD0vvORETmjupI" +
                    "FVOQTipPUIxgNweadcU/+GaG83xMUUbRrxLQx4YgzF4EJQSDsCcZ/+sGu9lhtyAf" +
                    "G1QR2x+iJ02HeVNFCac2jipov8UTIgDn6J7YpLnPBaUxQvQGKnEZpyAjWt7bbWY4" +
                    "7WvuyiubBkCzPPwZ6ySEpeqy35rMRoc4a6RLmeMiN7RwQLU3qBefdv3fqXYASJtK" +
                    "oxiwkkt0aB2oEZhFOJ5CuS0+go2HrBanXZIr8rMDIdkxqs2FM9kdDxJ+PEzkOr+X" +
                    "gXe1jOC0fxtzKVZHPP1dRtmnIGL/acWheHK9s9VbqeECgYEA6qgGT/GscTXUG+NU" +
                    "COTqGTc//e3QlXJzTdLREt0x8Rf30qy8XMP/083RJb4996uq/+b8UU9DUD7gIT5a" +
                    "SOaIH1eOjkNT6186LL3JXwbCzbUUgJ+WnsY8o0diBdqU63lAcLxq64KC2x5cAujQ" +
                    "oVxfhvnlBUHbTMjJ0QWt479z8H0CgYEA593v0B1h7dovLj+fKh7964hEk1SmILwL" +
                    "Je78d6xEszUQ/5C2D1fW7w0nVvgNbWhsJPIvDCxijr0rmU96LnehZIwr2/Vs3GOx" +
                    "9AIXI56C2kdfXvim5yUDbKs2LerXyPCiC7qlbyBz4S3zZeSCuBtymRUnNrHpdkxr" +
                    "NtHXEot9mVMCgYEAki2d0QtiOxwnSEAzR18jHhY2/P66435qqd5cc/3rcJ9XuJv2" +
                    "s2s94Tnjwjli7Pi6C7RfFl/kNQcWJF9tauCBh9TJb4ItswCdguWvnkzd6buWTBIe" +
                    "iEZB3A1J2Q+zmYTtSc12ZcPltI6TDxTtcrfSoojlzIKcFJc4ccex7aCEnxkCgYAR" +
                    "HPNHM/P3XyQeULnJnRH2oU8WZKgCQH6+JP5jQsarR15izmZxiXUmnZzqsVIkYhGh" +
                    "RHKuflQj3thp71DAPzodNq9CA8IuHfmTXdghW+CihaQHWWjQJI41JgnQp8WXYhND" +
                    "tFnjcsy6sO6G9a+kMPprTAFh6w2lGozLNf+escbqWwKBgBT/ZrBpNpIKW8Mtib7A" +
                    "MZPgJZIqEbF6NS3m/fNMLi7Jd5Qb8CPPxtwkw4ttWo8b8y2cmvCy8VocSbZNkpZt" +
                    "ikxyg/8lUnt+A6rWrKQAWHsSYtFuzIlZE6ywv/osBM249AdRvI0xaDah21T9jK2s" +
                    "93clqBTtnZUo3W8k246xTGby";







  
            // encrypt
        String s = "The quick brown fox jumps over the lazy dog"; 
            String enc = CryptoHelper.encryptStringWithPublicKey(s, pubkeyfile);
            System.out.println( String.format("%s -> %s", s, enc));
  
            // decrypt
            String dec = CryptoHelper.decryptStringWithPrivateKey(enc, privateKeyfile);
            System.out.println( String.format("%s -> %s", enc, dec));
        }
        catch(Exception ex){
            System.out.println(ex);
        }
  
    }
 
    public static String encryptStringWithPublicKey(String s, String keyFilename) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey pubkey = readPublicKeyFromPem(keyFilename);
        cipher.init(Cipher.ENCRYPT_MODE, pubkey);
        String enc = Base64.getEncoder().encodeToString(cipher.doFinal(s.getBytes("UTF-8")));
        return enc;
    }
  
    public static String decryptStringWithPrivateKey(String s, String keyFilename)  throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        PrivateKey pkey = readPrivateKeyFromPem(keyFilename);
        cipher.init(Cipher.DECRYPT_MODE, pkey);
        String dec = new String(cipher.doFinal(Base64.getDecoder().decode(s)), "UTF-8");
 
        return dec;
    }
  
    public static PrivateKey readPrivateKeyFromPem(String keyFilename) throws Exception {
        //byte[] keyBytes = Base64.getDecoder().decode(keyFilename);
        //String keyString = new String(keyBytes);
  
        //if (keyString.contains("BEGIN PRIVATE KEY")) {
            // PCKS8 format key
       //     return readPrivateKeyFromPem_PKCS8(keyFilename);
       // }
       // else if(keyString.contains("BEGIN RSA PRIVATE KEY")){
            // PCKS1 format key
            return readPrivateKeyFromPem_PKCS8(keyFilename);
       // }
        // unknown format
       // throw new Exception("Unknown private key format in "+keyFilename);
    }
  
    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/PKCS8EncodedKeySpec.html
    public static PrivateKey readPrivateKeyFromPem_PKCS8(String keyFilename) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyFilename);
       // String keyString = new String(keyBytes);
        //String privKeyPEM = keyString.replace("-----BEGIN PRIVATE KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("-----END PRIVATE KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("\r", "");
        //privKeyPEM = privKeyPEM.replace("\n", "");
        //keyBytes = Base64.getDecoder().decode(privKeyPEM);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
  
    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/X509EncodedKeySpec.html
    public static PublicKey readPublicKeyFromPem(String keyFilename) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyFilename); //Files.readAllBytes(new File(keyFilename).toPath());
        //String keyString = new String(keyBytes);
        //String privKeyPEM = keyString.replace("-----BEGIN PUBLIC KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("-----END PUBLIC KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("\r", "");
        //privKeyPEM = privKeyPEM.replace("\n", "");
        //keyBytes = Base64.getDecoder().decode(privKeyPEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
  
    // https://stackoverflow.com/questions/7216969/getting-rsa-private-key-from-pem-base64-encoded-private-key-file/55339208#55339208
    // https://github.com/Mastercard/client-encryption-java/blob/master/src/main/java/com/mastercard/developer/utils/EncryptionUtils.java
    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/PKCS8EncodedKeySpec.html
    public static PrivateKey readPrivateKeyFromPem_PKCS1(String keyFilename) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyFilename); //Files.readAllBytes(new File(keyFilename).toPath());
        //String keyString = new String(keyBytes);
        //String privKeyPEM = keyString.replace("-----BEGIN RSA PRIVATE KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("-----END RSA PRIVATE KEY-----", "");
        //privKeyPEM = privKeyPEM.replace("\r", "");
        //privKeyPEM = privKeyPEM.replace("\n", "");
  
        //keyBytes = Base64.getDecoder().decode(privKeyPEM);
  
        // We can't use Java internal APIs to parse ASN.1 structures, so we build a PKCS#8 key Java can understand
        int pkcs1Length = keyBytes.length;
        int totalLength = pkcs1Length + 22;
        byte[] pkcs8Header = new byte[] {
                0x30, (byte) 0x82, (byte) ((totalLength >> 8) & 0xff), (byte) (totalLength & 0xff), // Sequence + total length
                0x2, 0x1, 0x0, // Integer (0)
                0x30, 0xD, 0x6, 0x9, 0x2A, (byte) 0x86, 0x48, (byte) 0x86, (byte) 0xF7, 0xD, 0x1, 0x1, 0x1, 0x5, 0x0, // Sequence: 1.2.840.113549.1.1.1, NULL
                0x4, (byte) 0x82, (byte) ((pkcs1Length >> 8) & 0xff), (byte) (pkcs1Length & 0xff) // Octet string + length
        };
        keyBytes = join(pkcs8Header, keyBytes);
  
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
  
    private static byte[] join(byte[] byteArray1, byte[] byteArray2){
        byte[] bytes = new byte[byteArray1.length + byteArray2.length];
        System.arraycopy(byteArray1, 0, bytes, 0, byteArray1.length);
        System.arraycopy(byteArray2, 0, bytes, byteArray1.length, byteArray2.length);
        return bytes;
   }
}