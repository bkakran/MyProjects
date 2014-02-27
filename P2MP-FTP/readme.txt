1)Make sure you are in the source folder of the java code.

cd C:\Users\pejakalabhargava\P2mp\src

2) Compile all the java files in com.p2mp.application package.
The classes are,
InternetChecksum.java
Receiver.java
UDPReceiver.java
UDPSender.java

javac com/p2mp/application/*.java

3)The receiver to be run is UDPReceiver.java. Make sure this is run first before sender is invoked.

java com.p2mp.application.UDPReceiver 62000 C:\Users\pejakalabhargava\rec.txt  0.5

4) Sender to run is UDPSender.java.

java com.p2mp.application.UDPSender 10.139.58.64 62000 C:\Users\pejakalabhargava\donlo.txt  2000

5)Time out is set at 60ms.