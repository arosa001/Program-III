package basketArcade.clases;

import java.util.ArrayList;

import javax.swing.JFrame;



public class Objeto extends JFrame {
	protected int ancho;
	protected int alto;
	protected int x;
	protected int y;
	boolean visible;
	private ArrayList<Objeto> aCaibles= new ArrayList<Objeto>();


	public Objeto(int ancho, int alto, boolean visible, int x, int y) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.visible=visible;
		this.x=x;
		this.y=y;
		setBounds(x, y, ancho, alto);
		setVisible(visible);
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getAlto() {
		return alto;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
	public ArrayList<Objeto> getaCaibles() {
		return aCaibles;
	}



}
