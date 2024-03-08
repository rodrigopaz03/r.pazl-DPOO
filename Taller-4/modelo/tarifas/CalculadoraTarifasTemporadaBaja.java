package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;


public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
		protected int COSTO_POR_KM_NATURAL = 600;
		protected int COSTO_POR_KM_CORPORATIVO = 900;
		protected double DESCUENTO_PEQ = 0.02;
		protected double DESCUENTO_MEDIANAS = 0.1;
		protected double DESCUENTO_GRANDES = 0.2;
		
		@Override
		public double calcularPorcentajeDescuento​(Cliente cliente){
			if (cliente.getTipoCliente().equals("Corporativo")) {
				ClienteCorporativo cast = (ClienteCorporativo) cliente;
				if (cast.getTamanoEmpresa() == 1) {return DESCUENTO_GRANDES;}
				else if (cast.getTamanoEmpresa() == 2) {return DESCUENTO_MEDIANAS;}
				else {return DESCUENTO_PEQ;}
			}
			else {
				return 0.0;}
			}
		
		@Override
		public int calcularCostoBase​(Vuelo vuelo, Cliente cliente){
				int d = super.calcularDistanciaVuelo​(vuelo.getRuta());
				if(cliente.getTipoCliente() == "Natural") {
					int costoBase = (d * COSTO_POR_KM_NATURAL);
					return costoBase;}
				else {
					int costoBase = d * COSTO_POR_KM_CORPORATIVO;
					return costoBase;
				}
			}
			
	
	}


