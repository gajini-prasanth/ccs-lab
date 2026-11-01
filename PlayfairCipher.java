import java.util.*;
public class PlayfairCipher{
 static char[][] t=new char[5][5];static int[] r=new int[26],c=new int[26];
 static String clean(String s){return s.toUpperCase().replaceAll("[^A-Z]","").replace('J','I');}
 static void build(String key){boolean[] u=new boolean[26];String z=clean(key)+"ABCDEFGHIKLMNOPQRSTUVWXYZ";int n=0;for(char a:z.toCharArray())if(!u[a-'A']){u[a-'A']=true;t[n/5][n%5]=a;r[a-'A']=n/5;c[a-'A']=n%5;n++;}}
 static String prep(String s){s=clean(s);StringBuilder b=new StringBuilder();for(int i=0;i<s.length();){char a=s.charAt(i++),v;if(i==s.length())v='X';else if(a==s.charAt(i))v='X';else v=s.charAt(i++);b.append(a).append(v);}return b.toString();}
 static String run(String s,int d){StringBuilder b=new StringBuilder();for(int i=0;i<s.length();i+=2){char a=s.charAt(i),v=s.charAt(i+1);int r1=r[a-'A'],c1=c[a-'A'],r2=r[v-'A'],c2=c[v-'A'];if(r1==r2){c1=(c1+d+5)%5;c2=(c2+d+5)%5;}else if(c1==c2){r1=(r1+d+5)%5;r2=(r2+d+5)%5;}else{int q=c1;c1=c2;c2=q;}b.append(t[r1][c1]).append(t[r2][c2]);}return b.toString();}
 public static void main(String[]x){Scanner s=new Scanner(System.in);System.out.print("Enter key: ");String k=s.nextLine();System.out.print("Enter plaintext: ");String m=s.nextLine();build(k);String p=prep(m),e=run(p,1);System.out.println("Prepared: "+p);System.out.println("Encrypted: "+e);System.out.println("Decrypted (padded): "+run(e,-1));}
}
