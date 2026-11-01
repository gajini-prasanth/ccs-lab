import java.util.*;
public class RailFenceCipher {
    static String encrypt(String s,int rails) {
        if(rails<2) throw new IllegalArgumentException("Rails must be at least 2.");
        StringBuilder[] r=new StringBuilder[rails];
        for(int i=0;i<rails;i++) r[i]=new StringBuilder();
        int row=0,dir=1;
        for(char c:s.toCharArray()) {
            r[row].append(c);
            if(row==0) dir=1; else if(row==rails-1) dir=-1;
            row+=dir;
        }
        StringBuilder out=new StringBuilder();
        for(StringBuilder x:r) out.append(x);
        return out.toString();
    }
    static String decrypt(String cipher,int rails) {
        int n=cipher.length(), row=0,dir=1;
        int[] pattern=new int[n], counts=new int[rails];
        for(int i=0;i<n;i++) {
            pattern[i]=row; counts[row]++;
            if(row==0) dir=1; else if(row==rails-1) dir=-1;
            row+=dir;
        }
        String[] rail=new String[rails]; int pos=0;
        for(int i=0;i<rails;i++) { rail[i]=cipher.substring(pos,pos+counts[i]); pos+=counts[i]; }
        int[] idx=new int[rails]; StringBuilder out=new StringBuilder();
        for(int x:pattern) out.append(rail[x].charAt(idx[x]++));
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message: "); String msg=sc.nextLine();
        System.out.print("Enter number of rails: "); int n=Integer.parseInt(sc.nextLine());
        String enc=encrypt(msg,n);
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted: "+decrypt(enc,n));
    }
}
