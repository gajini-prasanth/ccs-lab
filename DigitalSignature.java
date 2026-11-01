import java.security.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message: "); String message=sc.nextLine();
        KeyPairGenerator generator=KeyPairGenerator.getInstance("DSA");
        generator.initialize(2048);
        KeyPair pair=generator.generateKeyPair();
        Signature signer=Signature.getInstance("SHA256withDSA");
        signer.initSign(pair.getPrivate());
        signer.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signature=signer.sign();
        System.out.println("Signature (Base64): "+Base64.getEncoder().encodeToString(signature));
        Signature verifier=Signature.getInstance("SHA256withDSA");
        verifier.initVerify(pair.getPublic());
        verifier.update(message.getBytes(StandardCharsets.UTF_8));
        System.out.println("Signature valid: "+verifier.verify(signature));
    }
}
