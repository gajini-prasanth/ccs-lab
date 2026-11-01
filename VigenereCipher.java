import java.util.*;
public class VigenereCipher {
    static String process(String text,String key,boolean decrypt) {
        text=text.toUpperCase(); key=key.toUpperCase().replaceAll("[^A-Z]","");
        if(key.isEmpty()) throw new IllegalArgumentException("Key must contain letters.");
        StringBuilder out=new StringBuilder(); int j=0;
        for(char c:text.toCharArray()) {
            if(c>='A'&&c<='Z') {
                int shift=key.charAt(j++%key.length())-'A';
                out.append((char)('A'+Math.floorMod(c-'A'+(decrypt?-shift:shift),26)));
            } else out.append(c);
        }
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter plaintext: "); String msg=sc.nextLine();
        System.out.print("Enter keyword: "); String key=sc.nextLine();
        String enc=process(msg,key,false);
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted: "+process(enc,key,true));
    }
}
