package ar.edu.unlam.empresaTransporte;

public class Camion extends Vehiculo{
	public Camion() {
		this.limiteVolumen = 20.0;
		this.cantidadDestinos = 3;
		this.limiteCapacidadKg = 16000.0;
	}
	
	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		if(!entraEnLosLimites(paquete)) return false;
		if(paquete.getDestino() == null) return false;
		return true;
	}


	
}
