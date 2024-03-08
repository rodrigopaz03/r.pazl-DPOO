package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	protected int COSTO_POR_KM = 1000;
	
	
	@Override
	public int calcularCostoBase​(Vuelo vuelo, Cliente cliente){
		int d = super.calcularDistanciaVuelo​(vuelo.getRuta());
		return d * COSTO_POR_KM;
		}
		
	@Override
	public double calcularPorcentajeDescuento​(Cliente cliente){
			return 0.0;
		}
		
	
}
