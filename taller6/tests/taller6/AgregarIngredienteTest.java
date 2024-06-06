package taller6;

import org.junit.jupiter.api.Test;
import src.Hamburguesa;
import src.Ingrediente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;


public class AgregarIngredienteTest {

	
	@Test
	public void agregarIngrediente() throws Exception{
		
		
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		Ingrediente lechuga = new Ingrediente("Lechuga", true);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(lechuga);
		hamburguesa.setIngredientes(ingredientes);
				
		//Test
		assertEquals(ingredientes, hamburguesa.getIngredientes());
		
	}
	

	@Test
	public void aumentartamano() throws Exception{
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
				
		//Test 1 -> array de tamaño 5
		assertEquals(5, hamburguesa.getIngredientes().size());
		
		//Test 2 -> agregar nuevo ingrediente -> array de tamaño 6
		Ingrediente salsa = new Ingrediente("Salsa", false);
		hamburguesa.agregar_ingrediente(salsa);
		assertEquals(6, hamburguesa.getIngredientes().size());
		
	}
	
	@Test
	public void fallaSeptimoIng() throws Exception{
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
		Ingrediente salsa = new Ingrediente("Salsa", false);
		hamburguesa.agregar_ingrediente(salsa);
		Ingrediente tocino = new Ingrediente("Tocino", false);
		
		//Test de excepcion 
		Exception exception = assertThrows(Exception.class, () -> {hamburguesa.agregar_ingrediente(tocino);});
		
	}
	


}