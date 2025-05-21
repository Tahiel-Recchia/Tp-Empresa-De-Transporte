package ar.edu.unlam.empresaTransporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class EmpresaTest {
	Empresa empresa;
	
	@BeforeEach
	public void InicializarLaEmpresa() {
		empresa = new Empresa();
	}
	
	@Test
	public void QueSePuedanAgregarVehiculos() {
		Automovil auto = new Automovil(1);
		assertTrue(empresa.agregarVehiculo(auto));
	}
	
	@Test 
	void queNoSePedanRepetirLosVehiculos() {
		Automovil auto = new Automovil(1);
		Camion camion = new Camion(1);
		Camion mismoCamion = new Camion(1);
		assertTrue(empresa.agregarVehiculo(camion));
		assertTrue(empresa.agregarVehiculo(auto));
		assertFalse(empresa.agregarVehiculo(mismoCamion));
	}

	@Test
	void queSePuedanEliminarVehiculos() {
		Automovil auto = new Automovil(1);
		Camion camion = new Camion(1);
		empresa.agregarVehiculo(camion);
		empresa.agregarVehiculo(auto);
		assertTrue(empresa.getVehiculos().size() == 2);
		empresa.eliminarVehiculo(camion);
		assertTrue(empresa.getVehiculos().size() == 1);
		assertFalse(empresa.eliminarVehiculo(camion));
		
	}
	
	@Test
	void queSePuedanAgregarPaquetes() {
		Automovil auto = new Automovil(1);
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 498.0, destino1);
		empresa.agregarVehiculo(auto);
		assertTrue(empresa.agregarPaquete(auto, paquete1));
	}
	
	@Test
	void queSePuedanEliminarPaquetes() {
		Destino destino1 = new Destino("Springfield", "Calle falsa 123");
		Destino destino2 = new Destino("Ituzaingó", "Calle falsa 321");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino2);
		Automovil auto = new Automovil(1);
		assertTrue(empresa.agregarPaquete(auto, paquete2));
		assertTrue(empresa.agregarPaquete(auto, paquete1));
		assertTrue(empresa.eliminarPaquete(auto, paquete2));
		assertTrue(empresa.obtenerListadoDePaquetes(auto).size() == 1);
	}
}
