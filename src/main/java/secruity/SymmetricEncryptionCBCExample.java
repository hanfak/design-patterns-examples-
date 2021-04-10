package secruity;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

public class SymmetricEncryptionCBCExample {
  public static void main(String... args) throws Exception {
//make key
    KeyGenerator generator = KeyGenerator.getInstance("AES");
    // specify we want a key length of 192 bits, allowed for AES
    generator.init(192);
    Key key = generator.generateKey();
    printByteArray("key", key.getEncoded());

    //get IV
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    byte[] random = new byte[16];
    secureRandom.nextBytes(random);
    IvParameterSpec ivSpec = new IvParameterSpec(random);
    printByteArray("ivSpec", random);

    //input
    byte[] input = "JavaLand".repeat(16).getBytes();
    printText("input", input);

    //encryption - Notice absence of pattern in CBC
    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
    byte[] encryptedOutput = cipher.doFinal(input);
    printByteArray("ciphertext", encryptedOutput);

    //decryption
    cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
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
