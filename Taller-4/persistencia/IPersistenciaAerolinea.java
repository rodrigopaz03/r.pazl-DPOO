package uniandes.dpoo.aerolinea.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {

	public void cargarAerolineas(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException;
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws FileNotFoundException;
}
