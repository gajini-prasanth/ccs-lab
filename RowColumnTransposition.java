import java.util.*;
public class RowColumnTransposition {
    static String encrypt(String s,int cols) {
        s=s.replaceAll("\\s+","");
        int rows=(s.length()+cols-1)/cols;
        char[][] a=new char[rows][cols];
        int k=0;
        for(int r=0;r<rows;r++) for(int c=0;c<cols;c++)
            a[r][c]=k<s.length()?s.charAt(k++):'X';
        StringBuilder out=new StringBuilder();
        for(int c=0;c<cols;c++) for(int r=0;r<rows;r++) out.append(a[r][c]);
        return out.toString();
    }
    static String decrypt(String s,int cols,int originalLength) {
        int rows=s.length()/cols, k=0;
        char[][] a=new char[rows][cols];
        for(int c=0;c<cols;c++) for(int r=0;r<rows;r++) a[r][c]=s.charAt(k++);
        StringBuilder out=new StringBuilder();
        for(int r=0;r<rows;r++) for(int c=0;c<cols;c++) out.append(a[r][c]);
        return out.substring(0,Math.min(originalLength,out.length()));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message: "); String msg=sc.nextLine();
        System.out.print("Enter number of columns: "); int cols=Integer.parseInt(sc.nextLine());
        if(cols<1) throw new IllegalArgumentException("Columns must be positive.");
        String enc=encrypt(msg,cols);
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted: "+decrypt(enc,cols,msg.replaceAll("\\s+","").length()));
    }
}
