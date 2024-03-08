package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class CalculadoraTarifas {
	public double IMPUESTO = 0.28;


	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int base = 	CalculadoraTarifas.this.calcularCostoBase​(vuelo, cliente);
		int impuesto = CalculadoraTarifas.this.calcularValorImpuestos​(base);
		double descuento = CalculadoraTarifas.this.calcularPorcentajeDescuento​(cliente);
		return (int) (base+impuesto-descuento);
	}
	protected abstract int calcularCostoBase​(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);

	protected int calcularDistanciaVuelo​(Ruta ruta) {
		int d = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		return d;
	}

	protected int calcularValorImpuestos​(int costoBase) {
		return (int) (costoBase * IMPUESTO);
		
	}
	
	
	
	
}
