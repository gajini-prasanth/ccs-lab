import java.util.*;
public class RailFenceCipher{
 static String enc(String s,int n){if(n<2)throw new IllegalArgumentException("Depth must be >= 2");StringBuilder[]a=new StringBuilder[n];for(int i=0;i<n;i++)a[i]=new StringBuilder();int r=0,d=1;for(char c:s.toCharArray()){a[r].append(c);if(r==0)d=1;else if(r==n-1)d=-1;r+=d;}StringBuilder b=new StringBuilder();for(StringBuilder q:a)b.append(q);return b.toString();}
 static String dec(String s,int n){int[]p=new int[s.length()],cnt=new int[n];int r=0,d=1;for(int i=0;i<s.length();i++){p[i]=r;cnt[r]++;if(r==0)d=1;else if(r==n-1)d=-1;r+=d;}String[]a=new String[n];int k=0;for(int i=0;i<n;i++){a[i]=s.substring(k,k+cnt[i]);k+=cnt[i];}int[]ix=new int[n];StringBuilder b=new StringBuilder();for(int q:p)b.append(a[q].charAt(ix[q]++));return b.toString();}
 public static void main(String[]x){Scanner s=new Scanner(System.in);System.out.print("Enter message: ");String m=s.nextLine();System.out.print("Enter depth: ");int n=s.nextInt();String e=enc(m,n);System.out.println("Encrypted: "+e);System.out.println("Decrypted: "+dec(e,n));}
}
