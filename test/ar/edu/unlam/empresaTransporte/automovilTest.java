package ar.edu.unlam.empresaTransporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class automovilTest {

	@Test
	public void QueNoSePaseDelLimiteDePeso() {
		Automovil auto = new Automovil(1);
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Moron", "Curupaity 628");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 498.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 100.0, destino2);
		assertTrue(auto.agregarPaquete(paquete1));
		assertFalse(auto.agregarPaquete(paquete2));
	}
	
	@Test
	public void queNoSePuedanRepetirLosDestinos() {
		Automovil auto = new Automovil(1);
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 498.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		assertTrue(auto.agregarPaquete(paquete1));
		assertFalse(auto.agregarPaquete(paquete2));
	}
	
	@Test
	public void queNoAbarqueMasDeTresCiudades() {
		Automovil auto = new Automovil(1);
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Ciudadela", "Rivadavia 19022");
		Destino destino3 = new Destino("Springfield", "Calle falsa 123");
		Destino destino4 = new Destino("Ituzaingó", "Calle falsa 321");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino2);
		Paquete paquete3 = new Paquete(0.1, 0.1, 0.1, 1.0, destino3);
		Paquete paquete4 = new Paquete(0.1, 0.1, 0.1, 1.0, destino4);
		assertTrue(auto.agregarPaquete(paquete1));
		assertTrue(auto.agregarPaquete(paquete2));
		assertTrue(auto.agregarPaquete(paquete3));
		assertFalse(auto.agregarPaquete(paquete4));
	}
	
	@Test
	public void queNoSePaseDelLimiteDeVolumen() {
		Automovil auto = new Automovil(1);
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Moron", "Curupaity 628");
		Paquete paquete1 = new Paquete(1.5, 1.5, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(10.0, 10.1, 10.1, 10.0, destino2);
		assertTrue(auto.agregarPaquete(paquete1));
		assertFalse(auto.agregarPaquete(paquete2));
	}
}
