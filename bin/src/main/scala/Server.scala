import java.net._;
import java.io._;
object UDPServer extends App {
  var aSocket: Option[DatagramSocket] = None;
  try {
    aSocket = Some(new DatagramSocket(6789))
    val buffer: Array[Byte] = Array.ofDim[Byte](1000); // array of byte, array of dimension
    while (true) {
      
      // create a datagram packet from array of byte with all 0
      val request: DatagramPacket = new DatagramPacket(buffer, buffer.length); 
      
      // open container, receive argument request  , when server receive the packet
      aSocket.get.receive(request);  
      
      // create another new datagram, use the data that you have receive
      val reply: DatagramPacket = new DatagramPacket(request.getData(), 
          
          // the port is the port that user send to you 
        request.getLength(), request.getAddress(), request.getPort());
      aSocket.get.send(reply); // send it back 
    }
  } catch {
    case e: SocketException => println("Socket: " + e.getMessage());
    case e: IOException     => println("IO: " + e.getMessage());
    
    // if sockect is not null, then close it
  } finally { for (aSocket <- aSocket) aSocket.close()} 

}
