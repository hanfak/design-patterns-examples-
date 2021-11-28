package secruity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

import static javax.crypto.Cipher.ENCRYPT_MODE;

public class StringEcryptorUsingAsymmetricKeyPair {

  private final Settings settings;

  public StringEcryptorUsingAsymmetricKeyPair(Settings settings) {
    this.settings = settings;
  }

  public String encrypt(String rawInput) {
    try {
      PublicKey napEncryptionKey = settings.getEncryptionKey();
      // List of cipher algorithms to use https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      cipher.init(ENCRYPT_MODE, napEncryptionKey);
      return Base64.getEncoder().encodeToString(cipher.doFinal(rawInput.getBytes()));
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
      throw new IllegalStateException(e);
    }
  }
}
