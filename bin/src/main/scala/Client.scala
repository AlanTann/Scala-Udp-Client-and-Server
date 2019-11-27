import java.net._;
import java.io._;
object UDPClient extends App {
var aSocket: DatagramSocket = null;
  try {
    aSocket = new DatagramSocket(); 
    val m: Array[Byte] = "how are you".getBytes // string have a function byte
    val aHost: InetAddress = InetAddress.getByName("localhost")
    val serverPort: Int = 6789
    
    //m.length is the length of byte,aHost is Inet object, server port is 6789
    val request: DatagramPacket = new DatagramPacket(m, m.length, aHost, serverPort); 
    aSocket.send(request); // use the socket and send the datagram
    val buffer: Array[Byte] = Array.ofDim(1000); // create a new 
    val reply: DatagramPacket = new DatagramPacket(buffer, buffer.length); //
    aSocket.receive(reply); //wait until something come in, if not come in thn it wait forever
    println("Reply: " + new String(reply.getData())); // construct a string from the byte
  } catch {
    case e: SocketException => println("Socket: " + e.getMessage());
    case e: IOException     => println("IO: " + e.getMessage());
  } finally {
    if (aSocket != null) aSocket.close();
  }
}
