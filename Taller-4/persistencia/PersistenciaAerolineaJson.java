package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{

	
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws FileNotFoundException {
		JSONObject jobject = new JSONObject( );
		JSONArray jRutas = new JSONArray( );
		JSONArray jAviones = new JSONArray( );
		
		for( Ruta ruta : aerolinea.getRutas( ) ) {
			JSONObject jRuta = new JSONObject( );
            jRuta.put("horaSalida", ruta.getHoraSalida());
            jRuta.put("horaLlegada", ruta.getHoraLlegada());
            jRuta.put("codigoRuta", ruta.getCodigoRuta() );
            jRuta.put("origen", ruta.getOrigen() );
            jRuta.put("destino", ruta.getDestino() );
            jRutas.put(jRuta);
		}
		jobject.put("rutas", jRutas);
		
		for( Avion avion : aerolinea.getAviones( ) ) {
			JSONObject jAvion = new JSONObject( );
			jAvion.put("nombre", avion.getNombre());
			jAvion.put("capacidad", avion.getCapacidad() );
			jAviones.put(jAvion);}
			jobject.put("aviones", jAviones);
		
		

		PrintWriter pw = new PrintWriter( archivo );
        jobject.write( pw, 2, 0 );
        pw.close( );
	}

	@Override
	public void cargarAerolineas(java.lang.String archivo,Aerolinea aerolinea) throws IOException,InformacionInconsistenteException {
	
		String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
		JSONObject raiz = new JSONObject( jsonCompleto );
		JSONArray rutas = raiz.getJSONArray( "rutas");
		JSONArray aviones = raiz.getJSONArray( "aviones");
		
		
		int numAviones = aviones.length( );
	     for( int i = 0; i < numAviones; i++ ) {
	    	 JSONObject avion = aviones.getJSONObject( i );
	    	 String nombre = avion.getString("nombre");
	    	 int capacidad = avion.getInt("capacidad");
	    	 Avion avionFinal = new Avion(nombre, capacidad);
	    	 aerolinea.agregarAvion(avionFinal);
	     }
		
		 int numRutas = rutas.length( );
	     for( int i = 0; i < numRutas; i++ ) {
	    	 JSONObject ruta = rutas.getJSONObject( i );
	    	 String horasalida = ruta.getString( "horasalida" );
	    	 String horallegada = ruta.getString( "horallegada" );
	    	 String codigoruta = ruta.getString( "codigoruta" );
	    	 JSONObject aeropuerto = ruta.getJSONObject("destino");
	    	 String nombreAeropuerto1 = aeropuerto.getString("nombre");
	    	 String codigoAeropuerto1 = aeropuerto.getString("codigo");
	    	 String ciudadAeropuerto1 = aeropuerto.getString("ciudad");
	    	 double longitudAeropuerto1 = aeropuerto.getDouble("longitud");
	    	 double latitudAeropuerto1 = aeropuerto.getDouble("latitud");
	    	 Aeropuerto destino = new Aeropuerto(nombreAeropuerto1, codigoAeropuerto1,
	    			 ciudadAeropuerto1,latitudAeropuerto1, longitudAeropuerto1);
	    	 
	    	 
	    	 JSONObject aeropuerto1 = ruta.getJSONObject("origen");
	    	 String nombreAeropuerto2 = aeropuerto1.getString("nombre");
	    	 String codigoAeropuerto2 = aeropuerto1.getString("codigo");
	    	 String ciudadAeropuerto2 = aeropuerto1.getString("ciudad");
	    	 double longitudAeropuerto2 = aeropuerto1.getDouble("longitud");
	    	 double latitudAeropuerto2 = aeropuerto1.getDouble("latitud");
	    	 Aeropuerto origen = new Aeropuerto(nombreAeropuerto2, codigoAeropuerto2,
	    			 ciudadAeropuerto2,latitudAeropuerto2, longitudAeropuerto2);
	    	 
	    	 Ruta rutaFinal = new Ruta(origen, destino, horasalida, horallegada, codigoruta);
	    	 aerolinea.agregarRuta(rutaFinal);
	     }
	
	}

}


