package Presentacion;

import java.util.Comparator;

import Entidades.Television;

class CompararImporte implements Comparator<Television>{

	public int compare(Television t1, Television t2) {
		
		if (t1.getPrecio()<t2.getPrecio()){
			return 1;
		} else {
			return -1;
		}
	}

}
