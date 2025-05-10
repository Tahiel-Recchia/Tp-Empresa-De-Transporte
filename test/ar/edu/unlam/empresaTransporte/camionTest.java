package ar.edu.unlam.empresaTransporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class camionTest {

	@Test
	public void QueNoSePaseDelLimiteDePeso() {
		Camion camion = new Camion();
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Moron", "Curupaity 628");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 15900.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 101.0, destino2);
		assertTrue(camion.agregarPaquete(paquete1));
		assertFalse(camion.agregarPaquete(paquete2));
	}
	
	@Test
	public void QueNoSePaseDelLimiteDeVolumen() {
		Camion camion = new Camion();
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Moron", "Curupaity 628");
		Paquete paquete1 = new Paquete(1.0, 1.0, 1.0, 15900.0, destino1);
		Paquete paquete2 = new Paquete(20.0, 20.0, 0.1, 99.0, destino2);
		assertTrue(camion.agregarPaquete(paquete1));
		assertFalse(camion.agregarPaquete(paquete2));
	}

}
