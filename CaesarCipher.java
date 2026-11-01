import java.util.*;
public class CaesarCipher{
 static String f(String s,int k){StringBuilder b=new StringBuilder(); for(char c:s.toCharArray()){if(c>='A'&&c<='Z')b.append((char)('A'+Math.floorMod(c-'A'+k,26)));else if(c>='a'&&c<='z')b.append((char)('a'+Math.floorMod(c-'a'+k,26)));else b.append(c);}return b.toString();}
 public static void main(String[]x){Scanner s=new Scanner(System.in);System.out.print("Enter message: ");String m=s.nextLine();System.out.print("Enter shift: ");int k=s.nextInt();String e=f(m,k);System.out.println("Encrypted: "+e);System.out.println("Decrypted: "+f(e,-k));}
}
