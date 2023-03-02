package util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;

public class OperationsLog {

    /**
     * Method to keep a record of the users who access the app, which will be saved in a log file.
     * One line is generated for each access.
     *
     * @param opUser    User name
     * @param resource  Requested resource
     * @param operation Operation
     * @param isError   True if it's an error, False if it's not
     * @author Isa & Sara
     */
    public static void generateLogFile(String opUser, String resource, String operation, boolean isError) {
        try {
            // Query the file exists, otherwise create one with the name access.log
            if (!new File("resources/access.log").exists()) {
                FileWriter file = new FileWriter("access.log", true);
                Calendar actualDate = Calendar.getInstance(); // To be able to use the Calendar package

                // Start writing to the file
                file.write("USER: " + opUser
                        + " - DATE: " + actualDate.get(Calendar.DAY_OF_MONTH)
                        + "/" + (actualDate.get(Calendar.MONTH) + 1)
                        + "/" + actualDate.get(Calendar.YEAR)
                        + " - TIME: " + actualDate.get(Calendar.HOUR_OF_DAY)
                        + ":" + actualDate.get(Calendar.MINUTE)
                        + ":" + actualDate.get(Calendar.SECOND)
                        + " - REQUESTED RESOURCE: " + resource
                        + " - OPERATION: " + operation
                        + "\r\n");

                // Close de file
                file.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        generateSecretKey();
        encryptSymmetricFile();
        decryptSymmetricFile();
        generatePairKeysAndSignFile();
    }

    /**
     * Method to create the private/secret key
     */
    public static void generateSecretKey() {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);

            // Generate secret key
            SecretKey key = kg.generateKey();

            writeFile("key.secret", key);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void encryptSymmetricFile() {
        try {
            Key secretKey = (Key) readFile("key.secret");

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] logFile = (byte[]) readFile("access.log");

            byte[] encryptedFile = c.doFinal(logFile);
            System.out.println("Encrypted: " + new String(encryptedFile));

            writeFile("access_symmetricCipher.log", encryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptSymmetricFile() {
        try {
            Key secretKey = (Key) readFile("key.secret");

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] logFile = (byte[]) readFile("access_symmetricCipher.log");

            byte[] decryptedFile = c.doFinal(logFile);
            System.out.println("Decrypted: " + new String(decryptedFile));

            writeFile("access_symmetricDecipher.log", decryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generatePairKeysAndSignFile() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");

            // Start the key generator
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(2048, number);

            // Create private and public keys
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            // Read the target file
            byte[] logFile = (byte[]) readFile("access.log");

            // Sign the file with the private key
            // Give the data to the Signature object
            Signature dsa = Signature.getInstance("SHA256withDSA");
            dsa.initSign(privateKey);
            dsa.update(logFile);

            // The signed file contents
            byte[] sign = dsa.sign();

            // Write the signed file in a binary file
//            FileOutputStream outSign = new FileOutputStream("access.signature");
//            outSign.write(sign);
//            outSign.close();
            writeFile("access.signature", sign);

            // The message receiver verifies with the public key the signed contents
            // The Signature object is provided the data to verify
            Signature checkDSA = Signature.getInstance("SHA256withDSA");
            checkDSA.initVerify(publicKey);
            checkDSA.update(logFile);
            boolean check = checkDSA.verify(sign);

            if (check) {
                //OK
                System.out.println("Verified signature with the public key");
            } else {
                System.out.println("ERROR: Signature not verified");
            }

            PKCS8EncodedKeySpec pkcs8Spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());

            // Write the private key in a binary file
//            FileOutputStream outpriv = new FileOutputStream("key.private");
//            outpriv.write(pkcs8Spec.getEncoded());
//            outpriv.close();
            writeFile("key.private", pkcs8Spec.getEncoded());

            X509EncodedKeySpec pkX509 = new X509EncodedKeySpec(publicKey.getEncoded());

            // Write public key in a binary file
//            FileOutputStream outpub = new FileOutputStream("key.public");
//            outpub.write(pkX509.getEncoded());
//            outpub.close();
            writeFile("key.public", pkX509.getEncoded());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object readFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Object fileContents = in.readObject();
        in.close();
        return fileContents;
    }

    private static void writeFile(String fileName, Object content) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(content);
        out.close();
    }
}
