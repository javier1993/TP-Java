package Entidades;

public class Lavarropa extends Electrodomestico {

	static int carga;
	String descripcion = "Lavarropa"; 
	
	public int getCarga() {
		return carga;
	}

	public static void setCarga(int carga) {
		Lavarropa.carga = carga;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
// constructor por defecto (?)	
	public Lavarropa() {
		super();
		Lavarropa.setCarga(5);
	}

	public Lavarropa(float pre, int pes){
		super(pre,pes);
		Lavarropa.setCarga(5);
	}

	public Lavarropa(float pre, int pes, String col, String con, int car){
		super(pre,pes,col,con);
		Lavarropa.setCarga(car);
	}

	public void precioFinal(){
		
		int c; float p;
		
		c = this.getCarga();
		
		super.precioFinal();
		
		if (c>30) {
			p= super.getPrecio();
			super.setPrecio(p+50);
		}
		
		
		
	}



}
