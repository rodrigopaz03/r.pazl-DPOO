package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete; 
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList; 
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
public class Vuelo {
	private String fecha;
	private Map<String, Tiquete> tiquetes;
	private Ruta ruta; 
	private Avion avion;
	

public Vuelo(Ruta ruta, String fecha, Avion avion) {
	this.ruta = ruta;
	this.fecha = fecha;
	this.avion = avion;
	this.tiquetes = new HashMap<>();
	
}

public String getFecha() {
	return fecha;
}

public Collection<Tiquete> getTiquetes() {
	List<Tiquete> rta = new ArrayList<>(tiquetes.values());
	return rta;
}


public Ruta getRuta() {
	return ruta;
}


public Avion getAvion() {
	return avion;
}

public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
	int precio = calculadora.calcularTarifa(this, cliente);
	int total = precio * cantidad;
	return total;
}


public boolean equals(Object obj) {
	if (obj instanceof Vuelo) 
	{
	Vuelo cast = (Vuelo) obj;
	if (cast.getRuta().equals(this.ruta) && cast.getFecha().equals(this.fecha)) {return true;}
	} 
	return false;
}




}
