package secruity;

import org.junit.Test;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringEcryptorUsingAsymmetricKeyPairTest {

  @Test
  public void shouldEncryptUsingPublicKeyFromSettingsThenBase64Encode() throws Exception {
    KeySpec publicKeySpec = new X509EncodedKeySpec(
        Base64.getDecoder().decode(PUBLICKEY
            .replaceAll("\\n", "")
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")));
    PublicKey napPublicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
    when(settings.getEncryptionKey()).thenReturn(napPublicKey);

    String encryptedResult = underTest.encrypt("someSecretPassword");

    assertThat(encryptedResult).isNotNull();
    String result = new String(Base64.getDecoder().decode(encryptedResult.getBytes()));
    assertThat(result).isNotNull();
  }

  @Test
  public void shouldBeAbleToDecryptTheEncryptedValueAsCorrectCipherFormat() throws Exception {
    // Create our own key pair, cause the app will not have the private key, so we cannot use the public key
    // associated with the app in the test, to check if the string has been encoded
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();
    RSAPublicKey rsaPublicKey = (RSAPublicKey) kp.getPublic();
    RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
    Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    when(settings.getEncryptionKey()).thenReturn(rsaPublicKey);

    String base64EncodedEncryptedResult = underTest.encrypt("someSecretPassword");
    assertThat(base64EncodedEncryptedResult).isNotNull();

    // To check that the string has been encoded, we will use the associated private key to decode the encoded
    // result. It is decoded correctly then then encryption worked
    byte[] encryptedResult = Base64.getDecoder().decode(base64EncodedEncryptedResult.getBytes());
    cipher.init(DECRYPT_MODE, rsaPrivateKey);
    assertThat(new String(cipher.doFinal(encryptedResult))).isEqualTo("someSecretPassword");
  }

  private final Settings settings = mock(Settings.class);
  private final StringEcryptorUsingAsymmetricKeyPair underTest = new StringEcryptorUsingAsymmetricKeyPair(settings);
  private static final String PUBLICKEY = "-----BEGIN PUBLIC KEY-----\n" +
      "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtDgtJgUG8v98CcOyKp9x\n" +
      "1E4epQ0t3vs8+c7KHIe9P2SsZDcwFPYax5RW4ji/cwwvLs/RLK5ENIOu+0NsnbRk\n" +
      "XT0Vi4McOloeYVGdqa5GFpRNfrN/ni2XsMJTF6S4AfuJhvTikPdKYVg5dyxgyCC7\n" +
      "GvYNM7+ddbdmbPZVBxbqkHdQoV3DVj0i+pJKb9WpwFi1XpJtPi0mDZ6uZzWvWqKw\n" +
      "mMuCcGpCukEmSbzdO4gL4QxIqYwA/9voescY+XF7TCXtNnZBr8Fz4QOduABgeO8H\n" +
      "7opf+NVjgE+l8n3rSnfHOh3bHDgnbFz3whxw79cWXeqeIPENxiT1KZTqU84fI+1z\n" +
      "iQIDAQAB\n" +
      "-----END PUBLIC KEY-----";
}