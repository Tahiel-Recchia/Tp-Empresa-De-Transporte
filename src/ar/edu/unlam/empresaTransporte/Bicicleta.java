package ar.edu.unlam.empresaTransporte;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bicicleta extends Vehiculo{
	
	protected Set<String> ciudades = new HashSet<>();
	
	public Bicicleta(Integer codigo) {
		super(codigo);
		this.limiteVolumen = 0.125;
		this.cantidadDestinos = 1;
		this.limiteCapacidadKg = 15.0;
		
	
	}

	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		if(!entraEnLosLimites(paquete)) return false;
		if(!queLasCiudadesSeanIguales(paquete)) return false;
		if(!hayEspacioParaPaquetes()) return false;
		verificarDestinoDelSegundoPaqueteYAsignarlo(paquete);

		if(ciudades.size() > 0) {
			return !ciudades.add(paquete.getCiudad());
		} else {
			return ciudades.add(paquete.getCiudad());
		}
	}
	
	private boolean hayEspacioParaPaquetes() {
		return paquetes.size() < 2;
	}

	private void verificarDestinoDelSegundoPaqueteYAsignarlo(Paquete paquete) {
		if(paquetes.size() > 0 && paquete.getDestino() == null) {
			paquete.setDestino(paquetes.get(0).getDestino());
		}
	}
	
	private boolean queLasCiudadesSeanIguales(Paquete paquete) {
		if(ciudades.size() == 0) return true;
		if(paquete.getDestino() == null) return true;
		if(paquete.getCiudad() != null && ciudades.contains(paquete.getCiudad())) return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigoDeVehiculo, ciudades);
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
		Automovil other = (Automovil) obj;
		return Objects.equals(codigoDeVehiculo, other.codigoDeVehiculo);
	}



	
}
