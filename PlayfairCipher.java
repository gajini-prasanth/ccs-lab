import java.util.*;
public class PlayfairCipher {
    static char[][] table = new char[5][5];
    static int[] row = new int[26], col = new int[26];

    static String clean(String s) {
        return s.toUpperCase().replaceAll("[^A-Z]", "").replace('J','I');
    }
    static void build(String key) {
        boolean[] used = new boolean[26];
        String chars = clean(key) + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        int k = 0;
        for (char ch : chars.toCharArray()) {
            if (ch == 'J') ch = 'I';
            if (!used[ch-'A']) {
                used[ch-'A'] = true;
                table[k/5][k%5] = ch;
                row[ch-'A'] = k/5;
                col[ch-'A'] = k%5;
                k++;
            }
        }
    }
    static String prepare(String text) {
        String s = clean(text);
        StringBuilder out = new StringBuilder();
        for (int i=0; i<s.length();) {
            char a=s.charAt(i++);
            char b = i<s.length() ? s.charAt(i) : 'X';
            if (a==b) b='X'; else i++;
            out.append(a).append(b);
        }
        return out.toString();
    }
    static String process(String text, int dir) {
        StringBuilder out = new StringBuilder();
        for (int i=0; i<text.length(); i+=2) {
            char a=text.charAt(i), b=text.charAt(i+1);
            int r1=row[a-'A'], c1=col[a-'A'], r2=row[b-'A'], c2=col[b-'A'];
            if (r1==r2) {
                c1=(c1+dir+5)%5; c2=(c2+dir+5)%5;
            } else if (c1==c2) {
                r1=(r1+dir+5)%5; r2=(r2+dir+5)%5;
            } else {
                int t=c1; c1=c2; c2=t;
            }
            out.append(table[r1][c1]).append(table[r2][c2]);
        }
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter key: "); String key=sc.nextLine();
        System.out.print("Enter plaintext: "); String msg=sc.nextLine();
        build(key);
        String prepared=prepare(msg);
        String enc=process(prepared,1);
        System.out.println("Prepared text: "+prepared);
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted (padded): "+process(enc,-1));
        System.out.println("Remove filler X characters manually when interpreting the plaintext.");
    }
}
