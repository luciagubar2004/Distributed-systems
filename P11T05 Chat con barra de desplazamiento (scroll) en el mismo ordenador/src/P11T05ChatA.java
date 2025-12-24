import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class P11T05ChatA {
	public static void main(String[] args){
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
		
		 try {
			 
			 DatagramSocket socketA = new DatagramSocket(2000);  // Asigna el puerto 3000
	         DatagramPacket paqueteAEnviar = new DatagramPacket(new byte[0], 0, InetAddress.getByName("192.168.111.164"), 3000);  // inicializado a 0, Destino puerto 2000
	         P11T05Ventana ventana = new P11T05Ventana(socketA, paqueteAEnviar, nombre); 
	         ventana.setTitle(nombre);
	         ventana.configuracionVentanaChat();
	         
			 while (true){
				
				
				//byte[] datos=mensajeEnviar.getBytes();
				//socketA.send(paqueteAEnviar);
				byte[] almacen = new byte[200];// Tamaño del buffer de recepción de 200 bytes
				DatagramPacket paqueteRecibido=new DatagramPacket(almacen, almacen.length);
				socketA.receive(paqueteRecibido);
				
				 String mensajeRecibido =new String(almacen).trim();
				 ventana.escribirEnAreaDeTextoSuperior(mensajeRecibido);
				  

				

				//socketB.close();
			 }}
				 // end try
				catch (Exception ex){
					ex.printStackTrace();
				}//end catch
			 
			 
			 

		 }
	
}