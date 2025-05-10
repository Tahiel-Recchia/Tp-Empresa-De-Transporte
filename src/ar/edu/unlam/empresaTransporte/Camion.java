package ar.edu.unlam.empresaTransporte;

public class Camion extends Vehiculo{
	public Camion() {
		this.limiteVolumen = 20.0;
		this.cantidadDestinos = 3;
		this.limiteCapacidadKg = 16000.0;
		this.cantidadDePaquetes = new Paquete[50];
	}
	
	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		Boolean entraEnLosLimites = true;
		Boolean hayEspacioParaPaquetes = false;
		
		if(paquete.getDestino() == null) {
			return false;
		}
		if ((paquete.calcularVolumen() + volumenAcumulado) > limiteVolumen
		|| (paquete.getPeso() + pesoAcumulado) > limiteCapacidadKg) {
			entraEnLosLimites = false;
		}

		for (Paquete p : cantidadDePaquetes) {
			if (p == null) {
				hayEspacioParaPaquetes = true;
				break;
			}
		}

		return entraEnLosLimites && hayEspacioParaPaquetes;
	}


	
	@Override
	public String toString() {
		return "Camión";  
	}
}
