package ar.edu.unlam.empresaTransporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class bicicletaTest {

	@Test
	public void queLaBicicletaNoPuedaLlevarMasDeDosPaquetes() {
		Bicicleta bici = new Bicicleta();
		Destino destino1 = new Destino("Moron", "acha 675");
		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete2 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		Paquete paquete3 = new Paquete(0.1, 0.1, 0.1, 1.0, destino1);
		assertTrue(bici.agregarPaquete(paquete1));
		assertTrue(bici.agregarPaquete(paquete2));
		assertFalse(bici.agregarPaquete(paquete3));
		
	}
}

