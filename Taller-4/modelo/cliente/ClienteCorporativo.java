package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    // TODO completar
    
	public String CORPORATIVO = "Corporativo";
	public int GRANDE = 1;
	public int MEDIANA = 2;
	public int PEQUEÑA = 3;
	private String nombreEmpresa;
	private int tamanoEmpresa;


	public ClienteCorporativo(String nombreEmpresa, int tamano) {
		this.nombreEmpresa = nombreEmpresa;
		if(tamano == 3) {this.tamanoEmpresa = PEQUEÑA;}
		else if(tamano == 2) {this.tamanoEmpresa = MEDIANA;}
		else {this.tamanoEmpresa = GRANDE;}
		
	}

    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
	
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

 
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public int getTamanoEmpresa() {
		return tamanoEmpresa;
	}

	public String getTipoCliente() {
		return CORPORATIVO;
	}
	public String getIdentificador() {
		return nombreEmpresa;
	};
	
	/**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
