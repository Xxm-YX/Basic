package rs256;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Base64;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.text.ParseException;
import java.util.Base64;

public class JWTDecoder {

    public static void main(String[] args) {
        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJiYXRjaCI6IjAwMSIsImN1c3RvbWVyIjoiemhvbmdrZXR1bGluZyIsInNuIjoiWlQzNTg4QTIwMFgyMjMwMzAwMTAwMSIsInRpbWVzdGFtcCI6MTY4MTc4OTY2MSwidXVpZCI6IjAyNzVlZWRjLTlkNTQtMzM1Yy04NjRlLWI5ODE4NWM2ZjE3MCJ9.roeGOQaTBVPBJnHby0v6eb2SpKj-Pbr3WwFyfh0u8OashiWVDK6rMoKwGJNmUxsbQRTCz843IEkLwkYhqv227_hPF-rZUK1IOrSa4IFtEeCtbPwSWd02mjFctv36M-jhJoQczhJ82kpFvOpj3ox0dVQ9RQw7T_8FONqu5659Vfs";

        try {
            String[] jwtParts = jwtString.split("\\.");
            String jwtHeader = new String(Base64.getDecoder().decode(jwtParts[0]));
            String jwtPayload = new String(Base64.getDecoder().decode(jwtParts[1]));
            byte[] jwtSignature = Base64.getMimeDecoder().decode(jwtParts[2]);

            System.out.println("Header: " + jwtHeader);
            System.out.println("Payload: " + jwtPayload);

            JWSObject jwsObject = JWSObject.parse(jwtString);
            JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey)getPublicKey());
            boolean verified = jwsObject.verify(verifier);

            if (verified) {
                System.out.println("Signature verified");
            } else {
                System.out.println("Signature verification failed");
            }

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException | JOSEException | ParseException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }


    private static PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTUJVd/gftAYOlYxUlc2NXuMWI\n" +
                "0Txr1gt2XhMT0lGRJkmnNq1xxAvVLHruCgXfId1w+El3ToQ+k66CKMCBvMfGqlXw\n" +
                "IgI5x5TXkfmaN1BUNBjcegUVPQnW42mwqPxvqcoT/H/MHqfhWYfElUNQBVytFF21\n" +
                "oxULmWBPMv4wDnCNzQIDAQAB\n";

        publicKeyStr = publicKeyStr.replaceAll("\\n", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePublic(keySpec);
    }

}

