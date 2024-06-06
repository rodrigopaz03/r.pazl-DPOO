package taller6;


import org.junit.jupiter.api.Test;
import src.Hamburguesa;
import src.Ingrediente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;


public class AumentarPrecioTest {

	
	@Test
	public void precioCorrecto() throws Exception{
		
		//Crear Hamburguesa
		Ingrediente lechuga = new Ingrediente("Lechuga", true);
		Ingrediente pan = new Ingrediente("Pan", false);
		Ingrediente tomate = new Ingrediente("Tomate", true);
		Ingrediente queso = new Ingrediente("Queso", false);
		Ingrediente carne = new Ingrediente("Carne", false);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(carne);
		ingredientes.add(lechuga);
		ingredientes.add(tomate);
		ingredientes.add(pan);
		ingredientes.add(queso);
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		hamburguesa.setIngredientes(ingredientes);
		
		//Test
		hamburguesa.aumentar_precio(32000);
		int precio = hamburguesa.getPrecio();
		assertEquals(32000, precio);
		
	}
	
	@Test
	public void precioIncorrecto() throws Exception{
		
		//Crear Hamburguesa
		Ingrediente lechuga = new Ingrediente("Lechuga", true);
		Ingrediente pan = new Ingrediente("Pan", false);
		Ingrediente tomate = new Ingrediente("Tomate", true);
		Ingrediente queso = new Ingrediente("Queso", false);
		Ingrediente carne = new Ingrediente("Carne", false);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(carne);
		ingredientes.add(lechuga);
		ingredientes.add(tomate);
		ingredientes.add(pan);
		ingredientes.add(queso);
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		hamburguesa.setIngredientes(ingredientes);
		
		//Test de excepcion 
		Exception exception = assertThrows(Exception.class, () -> {hamburguesa.aumentar_precio(60000);});
		
	}
	
	
	
}
