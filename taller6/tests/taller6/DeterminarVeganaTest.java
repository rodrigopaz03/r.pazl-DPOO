package taller6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import src.Hamburguesa;
import src.Ingrediente;

public class DeterminarVeganaTest {
	
	@Test
	public void todoVegano() throws Exception{
		//Crear Hamburguesa
		Ingrediente lechuga = new Ingrediente("Lechuga", true);
		Ingrediente cebolla = new Ingrediente("Cebolla", true);
		Ingrediente tomate = new Ingrediente("Tomate", true);
		Ingrediente carneVegana = new Ingrediente("CarneVegana", true);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(carneVegana);
		ingredientes.add(lechuga);
		ingredientes.add(tomate);
		ingredientes.add(cebolla);
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		hamburguesa.setIngredientes(ingredientes);
		
		//Test true
		assertTrue(hamburguesa.determinar_vegana());
	}
	
	@Test
	public void NoVegano() throws Exception{
		//Crear Hamburguesa
		Ingrediente queso = new Ingrediente("Queso", false);
		Ingrediente pan = new Ingrediente("Pan", false);
		Ingrediente tocino = new Ingrediente("Tocino", false);
		Ingrediente carne = new Ingrediente("Carne", false);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(carne);
		ingredientes.add(queso);
		ingredientes.add(tocino);
		ingredientes.add(pan);
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		hamburguesa.setIngredientes(ingredientes);
		
		//Test false 
		assertFalse(hamburguesa.determinar_vegana());
	}
	
	@Test
	public void NoVeganoyVegano() throws Exception{
		//Crear Hamburguesa
		Ingrediente queso = new Ingrediente("Queso", false);
		Ingrediente pan = new Ingrediente("Pan", false);
		Ingrediente tocino = new Ingrediente("Tocino", false);
		Ingrediente carne = new Ingrediente("Carne", false);
		Ingrediente lechuga = new Ingrediente("Lechuga", true);
		Ingrediente tomate = new Ingrediente("Tomate", true);
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(carne);
		ingredientes.add(queso);
		ingredientes.add(tocino);
		ingredientes.add(pan);
		ingredientes.add(lechuga);
		ingredientes.add(tomate);
		Hamburguesa hamburguesa = new Hamburguesa("Hamburguesa Taller 6", 30000);
		hamburguesa.setIngredientes(ingredientes);
		
		//Test false 
		assertFalse(hamburguesa.determinar_vegana());
	}

}
