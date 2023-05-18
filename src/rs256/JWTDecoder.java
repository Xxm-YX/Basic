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
        String jwtString = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJoYXJkd2FyZV9hcmNoIjoieDg2IiwiYXV0aF90eXBlIjoiU2luZ2xlIiwiZW52aXJvbm1lbnQiOnsiZGV2aWNlX2lkIjoic3RyaW5nIiwiZGV2aWNlX3NuIjoic3RyaW5nIiwiZGV2aWNlX3NlcmllcyI6InN0cmluZyJ9LCJwcm9kdWN0Ijp7InByb2R1Y3RfY29kZSI6InN0cmluZyIsInByb2R1Y3RfaWQiOiJzdHJpbmciLCJwcm9kdWN0X3ZlcnNpb24iOiJzdHJpbmcifSwiZmluZ2VycHJpbnQiOiIiLCJleHBpcmVfYXQiOjEwMDAsImN1c3RvbWVyX25hbWUiOiLkuK3np5Hlm77ngbUiLCJzbiI6IkUxVTk3SVJET0dYR1JaVVpJVTExRjJLSFBVSVlZSTNGIiwibWF4X2NsaWVudF9jb3VudCI6MCwicHJvZHVjdF9jb2RlIjoiZmFsbC1kZXRlY3Rpb24iLCJ2ZXJzaW9uIjoiMiIsInBsYXRmb3JtIjoiTGludXgifQ.lKINoIb3YMtfVMmSDQT691q0HsQIw0ltWPFQwDt3UorjMusPcO7p0zqqhZfizvtyCK_1X1aaJR7Aet2T58CdOA_HrFrKDnTX72d4Eh9ejQxI5opCQPSuUiOE0aPh5Xi3rjjOG21fryVhV-aq9cgIpFKPmd76v2vP0b_OqZ-iEdE";


        try {
            String[] jwtParts = jwtString.split("\\.");
            String jwtHeader = new String(Base64.getDecoder().decode(jwtParts[0]));
            String jwtPayload = new String(Base64.getDecoder().decode(jwtParts[1]));
//            byte[] jwtSignature = Base64.getMimeDecoder().decode(jwtParts[2]);

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

