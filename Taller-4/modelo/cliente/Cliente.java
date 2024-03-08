package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<>();
		this.tiquetesUsados = new ArrayList<>();
		
	}
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	public int calcularValorTiquetes() {
		int c = 0;
		for(Tiquete v: tiquetesSinUsar) {
			c += v.getTarifa();
		}
		return c;
	}
	
	public void usarTiquetes(Vuelo vuelo){
		for(Tiquete v: tiquetesSinUsar) {
			if(v.getVuelo().equals(vuelo) {
				v.marcarComoUsado();
				tiquetesUsados.add(v);
				tiquetesSinUsar.remove(v);
			}
		}
	}
	
	

}
