package basketArcade.clases;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import basketArcade.acciones.Movible;

public class Canasta extends Objeto implements Movible {
	private JLabel lCanasta;
	private Rectangle canasta;

	public Canasta(int ancho, int alto, int x, int y) {
		super(ancho, alto, true, x, y);
		Image canasta;
		ImageIcon imageIcon= new ImageIcon("src/basketArcade/image/basketball-net-hi.png");
		canasta = imageIcon.getImage();
		canasta=canasta.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		this.lCanasta = new JLabel( new ImageIcon( canasta) );
		this.canasta=new Rectangle(x, y, ancho, alto);
		lCanasta.setBounds(x, y, ancho, alto);
	}


	public Rectangle getCanasta() {
		return canasta;
	}


	public void setCanasta(Rectangle canasta) {
		this.canasta = canasta;
	}


	public JLabel getlCanasta() {
		return lCanasta;
	}

	public void setlCanasta(JLabel lCanasta) {
		this.lCanasta = lCanasta;
	}


	private double velx = 0;
	private double xCanasta=450;
	private double limDerecha=800;
	private double limIzquierda= 0;
	private int msgespera = 10;
	public boolean moverIzq=false;
	public boolean moverDer=false;
	public void Mover(JPanel lCancha) {	
		
		if(moverDer&&xCanasta!=limDerecha){
			velx=500;
		}else if(moverIzq&&xCanasta!=limIzquierda){
			velx=-500;
		}else if(!moverIzq||!moverDer){
			velx=0;
		}
		
		xCanasta += (velx * msgespera / 1000.0);

		if(xCanasta==limIzquierda||xCanasta==limDerecha){
			moverDer=false;
			moverIzq=false;
			velx=0;
		}


		super.x=(int)xCanasta;
		lCanasta.setLocation((int)xCanasta, 605);
		canasta.setLocation((int)xCanasta, 605);



	}

}
