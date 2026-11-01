import java.util.Scanner;
public class CaesarCipher {
    static String shift(String s, int key) {
        StringBuilder out = new StringBuilder();
        key = Math.floorMod(key, 26);
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') out.append((char)('A' + (c-'A'+key)%26));
            else if (c >= 'a' && c <= 'z') out.append((char)('a' + (c-'a'+key)%26));
            else out.append(c);
        }
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String msg = sc.nextLine();
        System.out.print("Enter shift value: ");
        int key = sc.nextInt();
        String enc = shift(msg, key);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + shift(enc, -key));
    }
}
