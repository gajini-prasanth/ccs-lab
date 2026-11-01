CCS RECORD TERMINAL PROGRAMS
============================
Based on the uploaded CCS Record.pdf. Java programs are terminal-based.

Install JDK 17+ and check:
  java -version
  javac -version

Compile and run each:
  javac CaesarCipher.java && java CaesarCipher
  javac PlayfairCipher.java && java PlayfairCipher
  javac HillCipher.java && java HillCipher
  javac RailFenceCipher.java && java RailFenceCipher
  javac TransCipher.java && java TransCipher
  javac DES.java && java DES
  javac AES.java && java AES
  javac RSA.java && java RSA
  javac DiffieHellman.java && java DiffieHellman
  javac SHA1Digest.java && java SHA1Digest
  javac MD5.java && java MD5
  javac CreatingDigitalSignature.java && java CreatingDigitalSignature

RSA record test values:
  p = 53
  q = 59
  message = 89
Expected n=3127, e=3, d=2011, ciphertext=1394, decrypted=89.

Other record samples:
  Caesar: Anna University, shift 3
  Playfair: key CSE, plaintext Security Lab
  Hill: SecurityLaboratory
  Rail Fence: Anna University, Chennai, depth 2
  AES URL: www.annauniv.edu, key annaUniversity
  Diffie-Hellman: p=23, g=5, Alice secret=4, Bob secret=3
  SHA-1: Cryptography and Network Security
  MD5: cryptography

Experiment 10: Snort IDS (Windows CMD as Administrator)
  snort -V
  snort -W
Use the actual interface index shown by Snort, not an assumed index:
  snort -dev -i <INTERFACE_NUMBER>
For a configured Snort 2 installation:
  snort -c C:\Snort\etc\snort.conf -l C:\Snort\log -i <INTERFACE_NUMBER> -A console
The record also lists:
  snort -A console -i <INTERFACE_NUMBER> -c C:\Snort\etc\snort.conf -l C:\Snort\log -K ascii
Only monitor systems and networks you own or are authorized to test.

Notes:
- RSA needs two distinct prime numbers. 4 and 1 are invalid. Use 53 and 59.
- The signature program signs the entered message and verifies it. The printed record code appears to sign the literal "msg", likely a typo.
- Rail Fence uses standard zigzag transposition. The printed record's sample implementation is a simplified matrix arrangement.
- DES, AES-ECB, SHA-1 and MD5 are included for syllabus practice only. Do not use these legacy configurations for real security.
