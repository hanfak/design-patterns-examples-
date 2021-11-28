package secruity;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;

public class SymmetricEncryptionECBDemo {
  public static void main(String... args) throws Exception {
    KeyGenerator generator = KeyGenerator.getInstance("AES");
    // specify we want a key length of 192 bits, allowed for AES
    generator.init(192);
    Key key = generator.generateKey();
    printByteArray("key", key.getEncoded());

    byte[] input = "JavaLand".repeat(16).getBytes();
    printText("input", input);

    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedOutput = cipher.doFinal(input);
    printByteArray("ciphertext", encryptedOutput); // Notice pattern in ECB

    //decryption on the other end
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
    printText("decoded input", decryptedOutput);
  }

  public static void printByteArray(String name, byte[] bytes) {
    System.out.println(name + ": "+ Hex.encodeHexString(bytes));
    System.out.println(name + " length: " + bytes.length + " bytes, " + bytes.length * 8 + " bits.");
    System.out.println("\r\n");
  }

  public static void printText(String name, byte[] bytes) {
    System.out.println(name + ": "+ new String(bytes));
    System.out.println(name + "length: " + bytes.length + " bytes, " + bytes.length * 8 + " bits.");
    System.out.println("\r\n");
  }
}
