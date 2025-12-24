import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
	public class P11T05Ventana extends JFrame implements KeyListener {
		private JTextArea areaDeTextoSuperior;
		private JTextArea areaDeTextoInferior;
		JScrollPane areaDeTextoSuperiorConScroll;
		DatagramSocket socket;
	    DatagramPacket paqueteAEnviar;
	    String nombre;

	    public P11T05Ventana(DatagramSocket socket, DatagramPacket paqueteAEnviar, String nombre) {
	        this.socket = socket;
	        this.paqueteAEnviar = paqueteAEnviar;
	        this.nombre = nombre;
	       //configuracionVentanaChat();
	    }

		
		public void configuracionVentanaChat(){
			
			this.setSize(700,700);
			this.setLayout(new FlowLayout());
			areaDeTextoSuperior = new JTextArea();
			//areaDeTextoSuperior.setPreferredSize(new Dimension(650,600));
			
			this.areaDeTextoSuperiorConScroll = new JScrollPane(areaDeTextoSuperior); // linea añadida
			this.areaDeTextoSuperiorConScroll.setPreferredSize(new Dimension(650,600)); //linea añadida
			DefaultCaret caret = (DefaultCaret)areaDeTextoSuperior.getCaret(); //linea añadida
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); // linea añadida
			
			areaDeTextoSuperior.setLineWrap(true);
			areaDeTextoSuperior.setEditable(false);
			areaDeTextoSuperior.setBackground(Color.LIGHT_GRAY);
			
			areaDeTextoInferior = new JTextArea();
			areaDeTextoInferior.setPreferredSize(new Dimension(650,20));
			areaDeTextoInferior.setBackground(Color.PINK);
			areaDeTextoInferior.setLineWrap(true);
			
			areaDeTextoInferior.addKeyListener(this); 
			
			this.add(areaDeTextoSuperiorConScroll);
			this.add(areaDeTextoInferior); 
			//this.add(areaDeTextoSuperior);
			this.setVisible(true);
		} // fin método
		
		public void escribirEnAreaDeTextoSuperior(String mensaje){
			areaDeTextoSuperior.append(mensaje + "\n");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent pulsacion) {
			// TODO Auto-generated method stub
			 if (pulsacion.getKeyCode() == KeyEvent.VK_ENTER) {
	
				 try {
					 String mensaje = areaDeTextoInferior.getText();
					 String mensaje2 = nombre + ": " + mensaje;
					 byte[] datos = mensaje2.getBytes();
					 paqueteAEnviar.setData(datos);
					 paqueteAEnviar.setLength(datos.length);
					 
					 escribirEnAreaDeTextoSuperior(mensaje2);
					socket.send(paqueteAEnviar);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 areaDeTextoInferior.setText(null);
				 pulsacion.consume();
			 } // fin if
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
} // fin clase
