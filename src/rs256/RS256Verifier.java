package rs256;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

public class RS256Verifier {

    public static void main(String[] args) throws Exception {
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        String publicKeyString = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsAfiRGMGnInCEgOZGeyn\nFvl9H+m+UCb43eLl8iAeHdKjzeF+AXZQjKs1sVlx4H4iP7V83eMebfzGZ14HvP9\naGjKlNc3i7eSv1YnV1lsnLPS/4/h7z4Jum4uR5i5e5FYhzr2rIn0cMKY0iXCXTxO\nqMk9Z/Lz0PTbU6gF1pjkMCU6IAdO6lJ2aDN+NxRWwdzISZ8+eufLxxfJ6U69p6Uy\n6Pd+bdQJefzgUBhx6MFZ8mI+H+/1R5iJG5ej+2Inr65r/CHn/f/bN3xqJZ/jX+1N\np7k+Prbq/e3tVfSvYJY7V4UCxrguwo7a4ZvJmtZ2sJfb+ObCBsBap8sHdkgwtcyJ\nFwIDAQAB\n-----END PUBLIC KEY-----";

        // Decode the public key
        publicKeyString = publicKeyString.replace("-----BEGIN PUBLIC KEY-----\n", "");
        publicKeyString = publicKeyString.replace("-----END PUBLIC KEY-----", "");
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Parse the JWT
        SignedJWT signedJwt = SignedJWT.parse(jwt);

        // Verify the signature
        RSASSAVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);
        boolean signatureVerified = signedJwt.verify(verifier);

        if (signatureVerified) {
            System.out.println("The signature is verified.");
        } else {
            System.out.println("The signature is not verified.");
        }
    }
}
