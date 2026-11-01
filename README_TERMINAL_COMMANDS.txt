23CS702 CCS LAB - TERMINAL EXECUTION GUIDE
===========================================

REQUIREMENT
-----------
Install JDK 17 or later. Check:
    java -version
    javac -version

WINDOWS CMD / POWERSHELL
------------------------
Open terminal in this folder. Compile and run one program at a time:

    javac CaesarCipher.java
    java CaesarCipher

    javac PlayfairCipher.java
    java PlayfairCipher

    javac HillCipher.java
    java HillCipher

    javac VigenereCipher.java
    java VigenereCipher

    javac RailFenceCipher.java
    java RailFenceCipher

    javac RowColumnTransposition.java
    java RowColumnTransposition

    javac DES.java
    java DES

    javac AES.java
    java AES

    javac RSA.java
    java RSA

    javac DiffieHellman.java
    java DiffieHellman

    javac DigitalSignature.java
    java DigitalSignature

    javac MD5.java
    java MD5

UBUNTU
------
Install Java if needed:
    sudo apt update
    sudo apt install default-jdk
Then use the same javac and java commands shown above.

EXPERIMENT 8 - SNORT IDS (AUTHORIZED NETWORKS ONLY)
---------------------------------------------------
The manual uses Snort. Run CMD/PowerShell as Administrator and check:
    snort -V
    snort -W

List available interfaces, then use the correct interface number:
    snort -dev -i <INTERFACE_NUMBER>

For a configured Snort 2 installation matching the manual:
    snort -c C:\Snort\etc\snort.conf -l C:\Snort\log -i <INTERFACE_NUMBER> -A console

Use only your own computer or a network you are authorized to monitor. Snort command-line options and configuration paths vary by version. The manual's sample interface number 3 is not universal.

EXPERIMENT 9 - N-STALKER
------------------------
The supplied manual describes N-Stalker as a GUI workflow and does not provide a command-line command or script. Do not assume it has a CLI.
For a terminal-based alternative, OWASP ZAP provides a baseline scan for a web application you own or have permission to test. If Docker is installed:
    docker run --rm -t -v zapdata:/zap/wrk/:rw ghcr.io/zaproxy/zaproxy:stable zap-baseline.py -t http://host.docker.internal:8080
Replace the target with your own local test application. The baseline scan is passive and reports findings; it is not equivalent to N-Stalker or a full penetration test.

EXPERIMENT 10(a) - TROJAN DEMONSTRATION
---------------------------------------
The original manual's batch script opens applications repeatedly and can make a computer unusable. Do not run that loop.
Run the safe demonstration instead:
    Trojan_Safe_Demo.bat

EXPERIMENT 10(b) - ROOTKIT HUNTER
---------------------------------
On Ubuntu/Debian:
    sudo apt update
    sudo apt install rkhunter
    sudo rkhunter --versioncheck
    sudo rkhunter --update
    sudo rkhunter --check
    sudo less /var/log/rkhunter.log

Review warnings before taking action. A warning is not proof of infection. Do not delete system files based only on a scan result.

NOTES
-----
1. Run each Java program from this folder, with the filename matching the public class name.
2. Caesar, Playfair, Hill, Vigenere, Rail Fence and Row/Column are classical educational ciphers.
3. DES and MD5 are included only because they appear in the lab syllabus. They are obsolete for modern security.
4. AES uses authenticated AES-GCM rather than the manual's outdated ECB mode.
5. RSA uses small values for a classroom demonstration. It is not production-grade RSA.
6. Diffie-Hellman uses the same small sample values as the manual (p=23, g=5, Alice secret=4, Bob secret=3).
7. The Digital Signature program signs the entered message and verifies the signature. The manual's sample accidentally signs the literal text "msg" instead of the entered variable.
8. For experiments 8 and 9, exact tool installation and command options depend on the installed version.
