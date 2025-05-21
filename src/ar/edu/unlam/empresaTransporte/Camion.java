package ar.edu.unlam.empresaTransporte;

import java.util.Objects;

public class Camion extends Vehiculo{
	public Camion(Integer codigo) {
		super(codigo);
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

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigoDeVehiculo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		return Objects.equals(codigoDeVehiculo, other.codigoDeVehiculo);
	}


	
}
