1) Compile all the java files.The classes are,
peer2peer.bean->Peer.java
peer2peer.bean->RFCIndex.java

peer2peer.constants->P2PConstants.java

peer2peer.peer->PeerMessage.java
peer2peer.peer->PeerNode.java

peer2peer.registration->RegistrationMessage.java
peer2peer.registration->RSServer.java


2)The each peer is identified by a cookie value which is stored in the default user folder as a text file..(For example /Users/greeshmagopinath/cookie.txt). 
This is automatically created by the client program.

3) The registration server is RSServer.java. Run this class. When this is run this creates a Registration server running on port 65423.

3) Before running the client(PeerNode.java)please be noted that the RFC files of the local client are assumed to be stored in a 
folder name "RFC" under user directory(For example /Users/greeshmagopinath/RFC).These RFC files have file name as
 rfc<rfcindex>.* (RFC1.txt, RFC2.html,rfc3.txt etc)
When the client runs it adds the index of these RFC files to its local list.

3) To run each of the peer we need to invoke the class PeerNode.java. This class has to be given two arguments as input.
    i)First argument has to be the IP Address of the Registration Server
    ii)Second argument has to be the port number on which the server at the peer side has to run.

4)RFC's are downloaded to RFC folder under user directory.(For example /Users/greeshmagopinath/RFC).