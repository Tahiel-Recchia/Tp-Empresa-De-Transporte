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

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


	
}
