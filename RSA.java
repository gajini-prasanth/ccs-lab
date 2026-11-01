import java.math.BigInteger;
import java.util.Scanner;
public class RSA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first prime number p (small demo): "); BigInteger p=sc.nextBigInteger();
        System.out.print("Enter second prime number q: "); BigInteger q=sc.nextBigInteger();
        if(!p.isProbablePrime(20)||!q.isProbablePrime(20)||p.equals(q))
            throw new IllegalArgumentException("Enter two different prime numbers.");
        BigInteger n=p.multiply(q), phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e=BigInteger.valueOf(65537);
        if(!e.gcd(phi).equals(BigInteger.ONE)) {
            e=BigInteger.valueOf(3);
            while(!e.gcd(phi).equals(BigInteger.ONE)) e=e.add(BigInteger.TWO);
        }
        BigInteger d=e.modInverse(phi);
        System.out.print("Enter numeric message (0 <= m < "+n+"): "); BigInteger m=sc.nextBigInteger();
        if(m.signum()<0||m.compareTo(n)>=0) throw new IllegalArgumentException("Message must be between 0 and n-1.");
        BigInteger c=m.modPow(e,n), plain=c.modPow(d,n);
        System.out.println("Public key (e,n): ("+e+","+n+")");
        System.out.println("Private key (d,n): ("+d+","+n+")");
        System.out.println("Ciphertext: "+c);
        System.out.println("Decrypted message: "+plain);
        System.out.println("Lab demo only. Small-number RSA is not secure.");
    }
}
