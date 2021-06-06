package mains;

import javax.swing.JFrame;

public class HelloWorld {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");				// Crea una ventana con título "Mini Tennis"
		frame.setSize(300, 300);								// Establece el tamaño de la ventana a 300x300
		frame.setVisible(true);									// Hace que la ventana sea visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Si no se incluye, el programa no terminará aunque cerremos la ventana.
		return;
	}

}
