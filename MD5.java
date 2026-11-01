import java.security.MessageDigest;
import java.util.HexFormat;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class MD5 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: "); String input=sc.nextLine();
        byte[] digest=MessageDigest.getInstance("MD5").digest(input.getBytes(StandardCharsets.UTF_8));
        System.out.println("MD5: "+HexFormat.of().formatHex(digest));
        System.out.println("Warning: MD5 is obsolete and must not be used for passwords or security-sensitive integrity.");
    }
}
