package ar.edu.unlam.empresaTransporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class bicicletaTest {

	@Test
	public void QueNoSePaseDelLimiteDePeso() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 10.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 6.0, destino1);
		assertTrue(bici.agregarPaquete(paquete1));
		assertFalse(bici.agregarPaquete(paquete2));
	}

	@Test
	public void queNoSePaseDelLimiteDeVolumen() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(1.1, 1.1, 0.1, 10.0, destino1);
		Paquete paquete2 = new Paquete(0.2, 0.2, 0.2, 4.0, destino1);
		assertTrue(bici.agregarPaquete(paquete1));
		assertFalse(bici.agregarPaquete(paquete2));
	}

	@Test
	public void queNoPuedaLlevarMasDeDosPaquetes() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete3 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		assertTrue(bici.agregarPaquete(paquete1));
		assertTrue(bici.agregarPaquete(paquete2));
		assertFalse(bici.agregarPaquete(paquete3));

	}

	@Test
	public void queNoSeMuevaPorFueraDeLaCiudad() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Destino destino2 = new Destino("Ciudadela", "Rivadavia 18092");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino2);
		assertTrue(bici.agregarPaquete(paquete1));
		assertFalse(bici.agregarPaquete(paquete2));
	}

	@Test
	public void queSiElSegundoPaqueteNoTieneDestinoElPrimerPaqueteDefinaElDestino() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(bici.agregarPaquete(paquete1));
		assertTrue(bici.agregarPaquete(paquete2));
		assertEquals(destino1, paquete2.getDestino());
	}
}
