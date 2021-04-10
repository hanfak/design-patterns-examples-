package secruity;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;

import static java.lang.String.format;

public class Settings {
  public PublicKey getEncryptionKey() {
     Properties properties = new Properties();
     // openssl s_client -connect www.google.com:443 | openssl x509 -pubkey -noout
     properties.put("public.key", "-----BEGIN PUBLIC KEY-----\n" +
         "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtDgtJgUG8v98CcOyKp9x\n" +
         "1E4epQ0t3vs8+c7KHIe9P2SsZDcwFPYax5RW4ji/cwwvLs/RLK5ENIOu+0NsnbRk\n" +
         "XT0Vi4McOloeYVGdqa5GFpRNfrN/ni2XsMJTF6S4AfuJhvTikPdKYVg5dyxgyCC7\n" +
         "GvYNM7+ddbdmbPZVBxbqkHdQoV3DVj0i+pJKb9WpwFi1XpJtPi0mDZ6uZzWvWqKw\n" +
         "mMuCcGpCukEmSbzdO4gL4QxIqYwA/9voescY+XF7TCXtNnZBr8Fz4QOduABgeO8H\n" +
         "7opf+NVjgE+l8n3rSnfHOh3bHDgnbFz3whxw79cWXeqeIPENxiT1KZTqU84fI+1z\n" +
         "iQIDAQAB\n" +
         "-----END PUBLIC KEY-----");
     String publicKey = (String) properties.get("public.key");
     System.out.println("publicKey = " + publicKey);

    final var publicKeySpec = new X509EncodedKeySpec(
        Base64.getDecoder().decode(publicKey
            .replaceAll("\\n", "")
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")));
    try {
      // Algorithms to use https://doc.bccnsoft.com/docs/jdk11-docs/specs/security/standard-names.html#keyfactory-algorithms
      return KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
      throw new IllegalStateException(format("invalid PEM format  public key, unable to generate key due to '%s'", e.getMessage()), e);
    }
  }

   public static void main(String... args) {
      new Settings().getEncryptionKey();
   }
}
