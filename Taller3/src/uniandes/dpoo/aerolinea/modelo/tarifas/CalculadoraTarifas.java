package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class CalculadoraTarifas {
	public double IMPUESTO = 0.28;
	private Cliente cliente;
	private Vuelo vuelo;

	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		return 1;
	}
	protected abstract int calcularCostoBase​(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);

	protected int calcularDistanciaVuelo​(Ruta ruta) {
		int d = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		return d;
	}

	protected int calcularValorImpuestos​(int costoBase) {
		return 1;
		
	}
	
	
	
	
}
