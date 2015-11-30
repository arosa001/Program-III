package basketArcade.teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import basketArcade.clases.Canasta;

public class MiKeyListener implements KeyListener {
	Canasta c;
	public MiKeyListener( Canasta c ) {
		this.c=c;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_A){
			
			c.moverDer=false;
			c.moverIzq=true;
			
		}
		if(e.getKeyCode()== KeyEvent.VK_D){
			
			c.moverIzq=false;
			c.moverDer=true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_A){
			
			c.moverDer=false;
			c.moverIzq=false;
			
		}
		if(e.getKeyCode()== KeyEvent.VK_D){
			
			c.moverIzq=false;
			c.moverDer=false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
