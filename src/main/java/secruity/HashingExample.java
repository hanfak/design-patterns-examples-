package secruity;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingExample {
  public static void main(String... args) throws Exception {

    // get a message digest
    System.out.println("one way only!");
    hashText("The quick brown fox jumped over the lazy dog.");

    //hash it again, deterministic
    System.out.println("deterministic");
    hashText("The quick brown fox jumped over the lazy dog.");

    // psuedorandom, new digest looks nothing like old digest
    System.out.println("psuedorandom");
    hashText("The quick brown fox jumped ower the lazy dog.");

    // hash is always fixed length.
    System.out.println("fixedlength");
    hashText("The quick brown fox jumped ower the lazy dog and a lot more stuff happened after that.");
  }

  private static void hashText(String data) throws NoSuchAlgorithmException {
    System.out.println("Input: " + data);
    // MD-5 and SHA-1 have been compromised, only use SHA-256
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html
    byte[] digest = messageDigest.digest(data.getBytes());
    printByteArray("Digest", digest);
  }

  public static void printByteArray(String name, byte[] bytes) {
    System.out.println(name + ": "+ Hex.encodeHexString(bytes));
    System.out.println(name + " length: " + bytes.length + " bytes, " + bytes.length * 8 + " bits.");
    System.out.println("\r\n");
  }
}
