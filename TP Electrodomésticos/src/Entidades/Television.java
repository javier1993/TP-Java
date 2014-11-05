package Entidades;

public class Television extends Electrodomestico {

	int pulgadas;
	boolean sintonizador;
	String descripcion = "Television";
	
	public int getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	public boolean isSintonizador() {
		return sintonizador;
	}
	public void setSintonizador(boolean sintonizador) {
		this.sintonizador = sintonizador;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

// constructor por defecto (?)
	public Television() {
		super();
		this.setPulgadas(20);
		this.setSintonizador(false);
		
	}
	
	public Television(float pre, int pes){
		super(pre,pes);
		this.setPulgadas(20);
		this.setSintonizador(false);
		
	}

	public Television(float pre, int pes, String col, String con, int pul, boolean sin){
		super(pre,pes,col,con);
		this.setPulgadas(pul);
		this.setSintonizador(sin);
		
		
	}

	public void precioFinal() {
		int p; boolean r; float pre;
		p = this.getPulgadas();
		r = this.isSintonizador();
		//System.out.println(r);
		super.precioFinal();
		//System.out.println("Precio de electrodomestico "+pre);
		if (r) {
			//System.out.println("Precio antes Sintonizador "+pre);
			pre = super.getPrecio();
			super.setPrecio(pre+50);
			//System.out.println("Precio despues Sintonizador "+pre);
			}
		if (p>40) {
			pre = super.getPrecio();
			super.setPrecio(pre + (pre*30/100));
			//System.out.println("Precio +40% "+pre);
			}
		
		
	}








}
