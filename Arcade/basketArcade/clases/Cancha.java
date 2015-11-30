package basketArcade.clases;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Cancha{
	private ArrayList<Objeto> aCaibles= new ArrayList<Objeto>();
	private double randomPiedra;
	private double randomBalon;
	private int contbalones=0;

	public Cancha() {
		super();
	}
	
	public void crearCaible(){
		randomBalon=Math.random();
		randomPiedra=Math.random();
		System.out.println(randomPiedra);
		if(randomPiedra<=0.2){
			System.out.println("piedra");
			if(randomBalon<=0.2){
				Piedra p= new Piedra(100, 100, 10,-100 );
				aCaibles.add(p);
			}else if(randomBalon>0.2&&randomBalon<=0.4){
				Piedra p= new Piedra(100, 100, 150, -100);
				aCaibles.add(p);
			}else if(randomBalon>0.4&&randomBalon<=0.6){
				Piedra p= new Piedra(100, 100, 270,-100 );
				aCaibles.add(p);
			}else if(randomBalon>0.6&&randomBalon<=0.8){
				Piedra p= new Piedra(100, 100, 390,-100 );
				aCaibles.add(p);
			}else if(randomBalon>0.8){
				Piedra p= new Piedra(100, 100, 510,-100 );
				aCaibles.add(p);
			}
		}else if(randomPiedra>0.2){
			System.out.println("Balon");
			if(randomBalon<=0.2){
				if(contbalones!=10){
					Balon b= new Balon(100, 100, 10, -100);
					aCaibles.add(b);
					contbalones++;
				}else{
					Tricolor t= new Tricolor(100, 100, 10,-100 );
					aCaibles.add(t);
					contbalones=0;
				}
			}else if(randomBalon>0.2&&randomBalon<=0.4){
				if(contbalones!=10){
					Balon b= new Balon(100, 100, 150,-100 );
					aCaibles.add(b);
					contbalones++;
				}else{
					Tricolor t= new Tricolor(100, 100, 150,-100 );
					aCaibles.add(t);
					contbalones=0;
				}
			}else if(randomBalon>0.4&&randomBalon<=0.6){
				if(contbalones!=10){
					Balon b= new Balon(100, 100, 270,-100 );
					aCaibles.add(b);
					contbalones++;
				}else{
					Tricolor t= new Tricolor(100, 100, 270,-100 );
					aCaibles.add(t);
					contbalones=0;
				}
			}else if(randomBalon>0.6&&randomBalon<=0.8){
				if(contbalones!=10){
					Balon b= new Balon(100, 100, 390,-100 );
					aCaibles.add(b);
					contbalones++;
				}else{
					Tricolor t= new Tricolor(100, 100, 390,-100 );
					aCaibles.add(t);
					contbalones=0;
				}
			}else if(randomBalon>0.8){
				if(contbalones!=10){
					Balon b= new Balon(100, 100, 510,-100 );
					aCaibles.add(b);
					contbalones++;
				}else{
					Tricolor t= new Tricolor(100, 100, 510, -100);
					aCaibles.add(t);
					contbalones=0;
				}
			}
		}
	}
	public ArrayList<Objeto> getaCaibles() {
		return aCaibles;
	}

	

}
