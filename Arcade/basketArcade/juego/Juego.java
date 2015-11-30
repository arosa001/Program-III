package basketArcade.juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import basketArcade.clases.Balon;
import basketArcade.clases.Canasta;
import basketArcade.clases.Cancha;
import basketArcade.clases.Objeto;
import basketArcade.clases.Piedra;
import basketArcade.teclado.MiKeyListener;
import basketArcade.ventana.VentanaJuego;


public class Juego {
	private static boolean finjuego;
	private static int puntuacion;
	private static boolean start;


	//metodo estatico que simula el choque del coche de policia con las cajas y el dinero
	//cuendo choca con las cajas el juego termina sin embargo cuando choca con el diner suma 1000 puntos a los puntos que ya tenia
	/*public static void colision(Balon b, Canasta c){
		ArrayList<Objeto> aCaibles=l.getaCaibles();
		for (int i = 0; i < aCaibles.size(); i++) {
			Objeto o=aCaibles.get(i);
			if(o instanceof Piedra){
				puntuacion=puntuacion-2;
				Piedra p=(Piedra) o;
				if(c.getCaja().intersects(p.getCoche())){
					finjuego=true;
				}
			}else if(o instanceof Balon){
				Balon b=(Balon)o;
				if(d.getDinero().intersects(p.getCoche())){
					puntuacion=puntuacion+2;
					aCaibles.remove(d);
					d.getlDinero().setVisible(false);


				}
			}
		}
	}*/
	//metodo principal del juego que a su vez contiene el bucle principal
	public static void main(String[] args) {
		finjuego=false;
		start=true;
		int contador =0;

		boolean pausa=false;
		long miTienpo=System.currentTimeMillis();
		do{
			puntuacion=0;
			//inicializacion de policia, ladron, y las dos carreteras necesarias para el movimiento
			Canasta c= new Canasta(150, 100, 450, 605);
			Cancha ca= new Cancha();
			VentanaJuego v= new VentanaJuego(c);
			//botones pausa y restart
			v.getPausa().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					v.setPause(!v.isPause());

				}
			});

			v.getPausa().requestFocus();
			//movimiento policia
			KeyListener kl = new MiKeyListener(c);
			v.getlCancha().addKeyListener(kl);
			v.getlCancha().requestFocus();
			v.getlCancha().addFocusListener( new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					System.out.println( "Se pierde");
					v.getlCancha().requestFocus();
				}
				@Override
				public void focusGained(FocusEvent e) {
					System.out.println( "se gana");
				}
			} );
			
			//bucle principal del juego
			while(!finjuego){
				//suma de puntos cada vez que pasa por el bucle si este no esta en pausa
				if(!v.isPause()){
					puntuacion++;
					contador++;
				}
				v.setlPuntos(puntuacion);
				try {
					Thread.sleep(15);
				} catch (Exception e) {}
				//pone el juego en pausa
				if (v.isPause()){
					miTienpo=System.currentTimeMillis();
				}else{
					if(contador==100){
					ca.crearCaible();
					contador=0;
					}
					//movimiento de cajas y dinero
					ArrayList<Objeto> aCaibles=ca.getaCaibles();
					for (int i = 0; i < aCaibles.size(); i++) {
						Objeto o=aCaibles.get(i);
						if(o instanceof Balon){
							Balon b=(Balon)o;
							v.getlCancha().add(b.getlBalon());
							b.Caer();
							if(b.getY()>800){
								aCaibles.remove(b);
							}
						}else if(o instanceof Piedra){
							Piedra p=(Piedra) o;
							v.getlCancha().add(p.getlPiedra());
							p.Caer();
							if(p.getY()>800){
								aCaibles.remove(p);

							}

						}

					}
					//movimiento del policia
					c.Mover(v.getlCancha());
					//comprobacion de colisiones
					//colision(l, p);
				}

			}
			//una vez terminado el bucle que es al ocurrir una colision con una caja se intruce un nuevo label con las letras de gameover y se cambia la imagen del coche
			/*p.getlCoche().setIcon(new ImageIcon("src/project/CopsRunner/img/Policia4roto.png"));
			ImageIcon gameo=new ImageIcon("src/project/CopsRunner/img/gameover.png");
			JLabel gameOver= new JLabel(gameo);
			v.getlCarretera().add(gameOver, 1);
			gameOver.setBounds(240, 250, 549, 245);
			//se guarda la puntuacion un jlist
			v.finJuego(puntuacion);
			start=false;
			v.setStart(false);
			//se ejecuta un cule que no termina asta que no se presiona el boton restart que vuelve  A INICIAR EL JUEGO
			do{
				v.getPausa().setEnabled(false);
				v.getEmpezar().setEnabled(true);
				v.getEmpezar().requestFocus();
				if(v.isStart()){
					start=true;
					finjuego=false;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}while(!start);*/
			v.setVisible(false);
		}while (start);
		
	}


}
