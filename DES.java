import javax.crypto.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
public class DES {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter message: ");
        String msg=new java.util.Scanner(System.in).nextLine();
        KeyGenerator kg=KeyGenerator.getInstance("DES");
        SecretKey key=kg.generateKey();
        Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encrypted=cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));
        String encoded=Base64.getEncoder().encodeToString(encrypted);
        cipher.init(Cipher.DECRYPT_MODE,key);
        String decrypted=new String(cipher.doFinal(Base64.getDecoder().decode(encoded)),StandardCharsets.UTF_8);
        System.out.println("Encrypted (Base64): "+encoded);
        System.out.println("Decrypted: "+decrypted);
        System.out.println("Lab note: DES and ECB are obsolete and unsafe for real applications.");
    }
}
