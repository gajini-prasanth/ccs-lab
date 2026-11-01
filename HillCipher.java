import java.util.*;
public class HillCipher {
    // Invertible 2x2 key matrix modulo 26: [3 3; 2 5]
    static int[][] K={{3,3},{2,5}}, INV={{15,17},{20,9}};
    static String transform(String s, int[][] m) {
        s=s.toUpperCase().replaceAll("[^A-Z]","");
        if(s.length()%2==1) s+="X";
        StringBuilder out=new StringBuilder();
        for(int i=0;i<s.length();i+=2) {
            int a=s.charAt(i)-'A', b=s.charAt(i+1)-'A';
            out.append((char)('A'+Math.floorMod(m[0][0]*a+m[0][1]*b,26)));
            out.append((char)('A'+Math.floorMod(m[1][0]*a+m[1][1]*b,26)));
        }
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String msg=sc.nextLine();
        String enc=transform(msg,K);
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted (padded): "+transform(enc,INV));
    }
}
