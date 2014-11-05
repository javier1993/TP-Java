package Entidades;

public class Electrodomestico {
	
	private int id;
	private String descripcion;
	private float precio;
	private String color;
	private String consumo;
	private int peso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getConsumo() {
		return consumo;
	}
	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}


    public Electrodomestico () {

    	this.setPrecio(100);
        this.setColor("Blanco");
        this.setConsumo("F");
        this.setPeso(5);

    } 

    public Electrodomestico (float pre, int pes) {
    	
    	this.setPrecio(pre);
    	this.setPeso(pes);
    	this.setColor("Blanco");
    	this.setConsumo("F");
    
    }

    public Electrodomestico (float pre, int pes, String col, String con) {
    	
    	this.setPrecio(pre);
    	this.setPeso(pes);
    	this.setColor(col);
    	this.setConsumo(con);
    }
    
    public float comprobarConsumo (String l) {
    	
    	float precio1=0;
    	
    	switch (l) {
    	case "A": precio1 = 100;
    			  break;
    	case "B": precio1 = 80;
		  	 	  break;
    	case "C": precio1 = 60;
		  		  break;
    	case "D": precio1 = 50;
    	          break;
    	case "E": precio1 = 30;
		          break;
    	case "F": precio1 = 10;
		          break;
		default: this.consumo = "F";
				 precio1 = 10;
				 break;
    	}
    	
    	return precio1;
    
    }

    public String comprobarColor (String color) {
    	
    	if (color != "Blanco" & color != "Negro" & color != "Rojo" & color != "Azul" & color != "Gris") {
    	this.color = "Blanco";	
    	}
    
    	return this.color;
    }

    public float comprobarPeso (int p) {
    	
    	float precio2=0;
    	
    	if (0<=p & p<=19) precio2 = 10; else if (20<=p & p<=49) precio2 = 50; else if (50<=p & p<=79) precio2 = 80; else if (p>=80) precio2 = 100;
    			
    	return precio2;
    }
    	
    public void precioFinal () {
    	
    	float precioTotal=0;
    	
    	precioTotal = (this.comprobarConsumo(this.consumo) + this.comprobarPeso(this.peso) + this.getPrecio()); 
    	
		this.precio = precioTotal;
    
    	
    }
	 

}
