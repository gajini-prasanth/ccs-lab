import java.util.*;
public class TransCipher{
 public static void main(String[]x){Scanner s=new Scanner(System.in);System.out.print("Enter plain text: ");String p=s.nextLine().replaceAll("\\s+","");int col=4,row=(p.length()+col-1)/col,k=0;char[][]a=new char[row][col];for(int i=0;i<row;i++)for(int j=0;j<col;j++)a[i][j]=k<p.length()?p.charAt(k++):'#';StringBuilder b=new StringBuilder();for(int j=0;j<col;j++)for(int i=0;i<row;i++)b.append(a[i][j]);System.out.println("Plain text: "+p);System.out.println("Encrypted: "+b);}
}
