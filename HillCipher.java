import java.util.*;
public class HillCipher{
 static int[][] K={{1,2,1},{2,3,2},{2,2,1}},I={{-1,0,1},{2,-1,0},{-2,2,-1}};
 static String f(String s,int[][]m){StringBuilder b=new StringBuilder();for(int i=0;i<s.length();i+=3){int[]v={s.charAt(i)-65,s.charAt(i+1)-65,s.charAt(i+2)-65};for(int j=0;j<3;j++){int z=0;for(int q=0;q<3;q++)z+=v[q]*m[q][j];b.append((char)(65+Math.floorMod(z,26)));}}return b.toString();}
 public static void main(String[]x){Scanner s=new Scanner(System.in);System.out.print("Enter plaintext: ");String m=s.nextLine().toUpperCase().replaceAll("[^A-Z]","");while(m.length()%3!=0)m+="X";String e=f(m,K);System.out.println("Padded: "+m);System.out.println("Encrypted: "+e);System.out.println("Decrypted: "+f(e,I));}
}
