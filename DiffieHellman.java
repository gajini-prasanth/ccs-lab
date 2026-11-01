import java.math.BigInteger;
public class DiffieHellman {
    public static void main(String[] args) {
        BigInteger p=BigInteger.valueOf(23), g=BigInteger.valueOf(5);
        BigInteger alicePrivate=BigInteger.valueOf(4), bobPrivate=BigInteger.valueOf(3);
        BigInteger A=g.modPow(alicePrivate,p), B=g.modPow(bobPrivate,p);
        BigInteger aliceSecret=B.modPow(alicePrivate,p);
        BigInteger bobSecret=A.modPow(bobPrivate,p);
        System.out.println("Public prime p: "+p);
        System.out.println("Public base g: "+g);
        System.out.println("Alice sends A: "+A);
        System.out.println("Bob sends B: "+B);
        System.out.println("Alice shared secret: "+aliceSecret);
        System.out.println("Bob shared secret: "+bobSecret);
        System.out.println("Match: "+aliceSecret.equals(bobSecret));
    }
}
