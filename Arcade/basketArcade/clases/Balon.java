package basketArcade.clases;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import basketArcade.acciones.Caible;

public class Balon extends Objeto implements Caible {
	//atributos de la clase caja
		private JLabel lBalon;
		private Rectangle balon;
		
		//constructor que tiene por parameros alto, ancho coordenadas x e y
		public Balon(int ancho, int alto, int x, int y) {
			super(ancho, alto, true, x, y);
			Image balon;
			ImageIcon imageIcon= new ImageIcon("src/basketArcade/image/11971185311926706097Gioppino_Basketball.svg.hi.png");
			balon = imageIcon.getImage();
			balon=balon.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
			this.lBalon = new JLabel( new ImageIcon( balon) );
			this.balon= new Rectangle(x, y, ancho, alto);
			lBalon.setBounds(x, y, ancho, alto);
		}

		public Rectangle getCaja() {
			return balon;
		}

		public void setBalon(Rectangle balon) {
			this.balon = balon;
		}

		public JLabel getlBalon() {
			return lBalon;
		}

		public void setlBalon(JLabel lBalon) {
			this.lBalon = lBalon;
		}
		
		//atributos pa la caida de las cajas
		double vely=300;
		double yCaja=40;
		int msgespera=10;

		public void Caer(){

			yCaja += (vely * msgespera/1000.0);

			super.y=(int) yCaja;
			lBalon.setLocation(super.x, (int) yCaja);
			balon.setLocation(super.x, (int)yCaja);



		}


}
