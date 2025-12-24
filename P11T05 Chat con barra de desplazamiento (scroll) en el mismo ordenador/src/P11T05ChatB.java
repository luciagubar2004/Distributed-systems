import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class P11T05ChatB {
	public static void main(String[] args){
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
		

		
		try {
			
			DatagramSocket socketB = new DatagramSocket(3000);  // Asigna el puerto 3000
	         DatagramPacket paqueteAEnviar = new DatagramPacket(new byte[0], 0, InetAddress.getByName("192.168.110.78"), 2000);  // Destino puerto 2000
	         P11T05Ventana ventana = new P11T05Ventana(socketB, paqueteAEnviar, nombre); 
	         ventana.setTitle(nombre);
	         ventana.configuracionVentanaChat();
	         
			 while(true) {
				
				 byte[] almacen = new byte[200];// Tamaño del buffer de recepción de 200 bytes
				 DatagramPacket paqueteRecibido=new DatagramPacket(almacen, almacen.length);
				 socketB.receive(paqueteRecibido);
					
				 String mensajeRecibido =new String(almacen).trim();
				 ventana.escribirEnAreaDeTextoSuperior(mensajeRecibido);
				}
		 }
				 // end try
				catch (Exception ex){
					ex.printStackTrace();
				}//end catch

	}
}