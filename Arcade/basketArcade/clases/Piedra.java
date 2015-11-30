package basketArcade.clases;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import basketArcade.acciones.Caible;

public class Piedra extends Objeto implements Caible {
	//atributos de la clase caja
		private JLabel lPiedra;
		private Rectangle piedra;
		
		//constructor que tiene por parameros alto, ancho coordenadas x e y
		public Piedra(int ancho, int alto, int x, int y) {
			super(ancho, alto, true, x, y);
			Image piedra;
			ImageIcon imageIcon= new ImageIcon("src/basketArcade/image/cartoon-stone-hi.png");
			piedra= imageIcon.getImage();
			piedra=piedra.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
			this.lPiedra = new JLabel( new ImageIcon(piedra) );
			this.piedra= new Rectangle(x, y, ancho, alto);
			lPiedra.setBounds(x, y, ancho, alto);
		}

		public Rectangle getPiedra() {
			return piedra;
		}

		public void setPiedra(Rectangle piedra) {
			this.piedra = piedra;
		}

		public JLabel getlPiedra() {
			return lPiedra;
		}

		public void setlPiedra(JLabel lPiedra) {
			this.lPiedra = lPiedra;
		}
		
		//atributos pa la caida de las cajas
		double vely=300;
		double yCaja=40;
		int msgespera=10;

		public void Caer(){

			yCaja += (vely * msgespera/1000.0);

			super.y=(int) yCaja;
			lPiedra.setLocation(super.x, (int) yCaja);
			piedra.setLocation(super.x, (int)yCaja);



		}


}
