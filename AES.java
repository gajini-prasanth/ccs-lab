import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class AES {
    public static void main(String[] args) throws Exception {
        var sc=new java.util.Scanner(System.in);
        System.out.print("Enter message: "); String msg=sc.nextLine();
        byte[] key=new byte[16], iv=new byte[12]; SecureRandom random=new SecureRandom();
        random.nextBytes(key); random.nextBytes(iv);
        SecretKeySpec secret=new SecretKeySpec(key,"AES");
        Cipher cipher=Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,secret,new GCMParameterSpec(128,iv));
        byte[] encrypted=cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE,secret,new GCMParameterSpec(128,iv));
        String decrypted=new String(cipher.doFinal(encrypted),StandardCharsets.UTF_8);
        System.out.println("Key (Base64, demo only): "+Base64.getEncoder().encodeToString(key));
        System.out.println("IV (Base64): "+Base64.getEncoder().encodeToString(iv));
        System.out.println("Encrypted (Base64): "+Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted: "+decrypted);
    }
}
