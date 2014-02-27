1)Make sure you are in the source folder of the java code.

cd C:\Users\pejakalabhargava\workspace\IPProj3\src

2) 
a)Compile all the java files in distantvector package.
The classes are,
DistantVectorAlgorithm.java
SimulateDistantVectorAlgorithm.java

javac distantvector/*.java

b)Compile all the java files in distantvectorUDP package.
The classes are,
DistantVectorAlgorithmUDP.java
Neighbour.java

javac distantvectorUDP/*.java

c)Compile all the java files in linkstate package.
The classes are,
Edge.java
Graph.java
LinkStateAlgorithm.java
SimulateLinkStateAlgorithm.java
Vertex.java

javac linkstate/*.java

3)
For Linkstate run,
java linkstate.SimulateLinkStateAlgorithm C:\Users\pejakalabhargava\large-net-a.txt 4 24
java linkstate.SimulateLinkStateAlgorithm C:\Users\pejakalabhargava\large-net-b.txt 4 24
java linkstate.SimulateLinkStateAlgorithm C:\Users\pejakalabhargava\small-net.txt 1 2

For distantvector run,
java distantvector.SimulateDistantVectorAlgorithm 30 C:\Users\pejakalabhargava\large-net-a.txt 4 24
java distantvector.SimulateDistantVectorAlgorithm 30 C:\Users\pejakalabhargava\large-net-b.txt 4 24
java distantvector.SimulateDistantVectorAlgorithm 3 C:\Users\pejakalabhargava\small-net.txt 1 2

4)For Extra Credit,

a)the topology input is taken from the file.Accordingly for the topology described in topology.pdf we have give 
Node1.txt, Node2.txt, Node3.txt, Node4.txt
First line describes the number of nodes in the network followed by each line describing about neighbours with its cost, Ip address and UDP port where server is running to receive updates from neihbour.

b)To start each node run,
For Node1,
java distantvectorUDP.DistantVectorAlgorithmUDP 1 62001 C:\Users\pejakalabhargava\Node1.txt true

First argument is id of the node, second argument is server port, third argument gives location of topology file and fourth argument mentions whether this node is initial node or not.

For Node2,
java distantvectorUDP.DistantVectorAlgorithmUDP 2 62002 C:\Users\pejakalabhargava\Node2.txt

For Node3,
java distantvectorUDP.DistantVectorAlgorithmUDP 3 62003 C:\Users\pejakalabhargava\Node3.txt

For Node4,
java distantvectorUDP.DistantVectorAlgorithmUDP 4 62004 C:\Users\pejakalabhargava\Node4.txt









