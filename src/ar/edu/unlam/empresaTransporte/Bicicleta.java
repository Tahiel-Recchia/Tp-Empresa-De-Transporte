package ar.edu.unlam.empresaTransporte;

public class Bicicleta extends Vehiculo{
	public Bicicleta() {
		this.limiteVolumen = 0.125;
		this.cantidadDestinos = 1;
		this.limiteCapacidadKg = 15.0;
		this.cantidadDePaquetes = new Paquete[2];
	}

	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		Boolean entraEnLosLimites = true;
		Boolean ciudadesIguales = true;
		Boolean hayEspacioParaPaquetes = false;
		
		if(cantidadDePaquetes[0] != null && cantidadDePaquetes[1] == null && paquete.getDestino() == null) {
			paquete.setDestino(cantidadDePaquetes[0].getDestino());
		}
		
		if ((paquete.calcularVolumen() + volumenAcumulado)  > limiteVolumen || (paquete.getPeso() + pesoAcumulado) > limiteCapacidadKg) {
			entraEnLosLimites = false;
		}

		if (cantidadDePaquetes[0] != null) {
			if (!cantidadDePaquetes[0].getCiudad().toLowerCase().equals(paquete.getCiudad().toLowerCase())) {
				ciudadesIguales = false;
			}
		}

		for (Paquete p : cantidadDePaquetes) {
			if (p == null) {
				hayEspacioParaPaquetes = true;
			}
		}

		return entraEnLosLimites && ciudadesIguales && hayEspacioParaPaquetes;
	}


	
	@Override
	public String toString() {
		return "Bicicleta";  
	}

	
}
