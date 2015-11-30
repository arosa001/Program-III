package basketArcade.ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import basketArcade.clases.Balon;
import basketArcade.clases.Canasta;
import basketArcade.clases.Piedra;

public class VentanaJuego extends JFrame {
	//atriutos de la clase
		private JPanel lCancha;
		private JPanel puntuacion;
		private JPanel panelPoints;
		private JButton pausa;
		private boolean pause;
		private boolean start;
		private JLabel lPuntos;
		private JLabel lFondo;
		

		public VentanaJuego(Canasta c) {
			//tamaño e inicializacion de contenedores
			setSize(1000, 800);
			Image canasta;
			ImageIcon imageIcon= new ImageIcon("src/basketArcade/image/basket_ball_court.jpg");
			canasta = imageIcon.getImage();
			canasta=canasta.getScaledInstance(1000, 800, java.awt.Image.SCALE_SMOOTH);
			this.lCancha = new JPanel();
			this.puntuacion= new JPanel();
			panelPoints= new JPanel();
			
			lPuntos=new JLabel("0");
			panelPoints.add(lPuntos);
			lCancha.setLayout(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//botones
			pausa=new JButton("Pausa");
			//lista de puntos
			puntuacion.setLayout(new BorderLayout());
			JPanel pane= new JPanel();
			pane.add(pausa);
			puntuacion.add(pane, BorderLayout.NORTH);
			//introduccion de los paneles en en contenedor de la ventana
			getContentPane().add(panelPoints, BorderLayout.WEST);
			getContentPane().add(lCancha, BorderLayout.CENTER);
			getContentPane().add(puntuacion, BorderLayout.EAST);
			pause=false;
			lCancha.add(c.getlCanasta());
			//no se permite redimensionar la ventana
			setResizable(false);
			setVisible(true);
			
		}
		
		public JLabel getlPuntos() {
			return lPuntos;
		}

		public void setlPuntos(int puntos) {
			lPuntos.setText(""+puntos);
		}

		public boolean isPause() {
			return pause;
		}


		public void setPause(boolean pause) {
			this.pause = pause;
		}

		
		public JPanel getlCancha() {
			return lCancha;
		}


		public void setlCancha(JPanel lCancha) {
			this.lCancha = lCancha;
		}


		public JPanel getPuntuacion() {
			return puntuacion;
		}


		public void setPuntuacion(JPanel puntuacion) {
			this.puntuacion = puntuacion;
		}


		public JButton getPausa() {
			return pausa;
		}


		public void setPausa(JButton pausa) {
			this.pausa = pausa;
		}
		

		public boolean isStart() {
			return start;
		}

		public void setStart(boolean start) {
			this.start = start;
		}
		
		
		public JLabel getlFondo() {
			return lFondo;
		}

		public void setlFondo(JLabel lFondo) {
			this.lFondo = lFondo;
		}


		


		

}
