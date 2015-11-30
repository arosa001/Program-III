package basketArcade.clases;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import basketArcade.acciones.Caible;

public class Tricolor extends Objeto implements Caible {
			//atributos de la clase caja
			private JLabel lTricolor;
			private Rectangle tricolor;
			
			//constructor que tiene por parameros alto, ancho coordenadas x e y
			public Tricolor(int ancho, int alto, int x, int y) {
				super(ancho, alto, true, x, y);
				this.lTricolor = new JLabel( new ImageIcon( "src/basketArcade/image/balon tricolor.JPG") );
				this.tricolor= new Rectangle(x, y, ancho, alto);
				lTricolor.setBounds(x, y, ancho, alto);
			}

			public Rectangle getTricolor() {
				return tricolor;
			}

			public void setBalon(Rectangle tricolor) {
				this.tricolor = tricolor;
			}

			public JLabel getlTricolor() {
				return lTricolor;
			}

			public void setlTricolor(JLabel lTricolor) {
				this.lTricolor = lTricolor;
			}
			
			//atributos pa la caida de las cajas
			double vely=300;
			double yCaja=40;
			int msgespera=10;

			public void Caer(){

				yCaja += (vely * msgespera/1000.0);

				super.y=(int) yCaja;
				lTricolor.setLocation(super.x, (int) yCaja);
				tricolor.setLocation(super.x, (int)yCaja);



			}


}
