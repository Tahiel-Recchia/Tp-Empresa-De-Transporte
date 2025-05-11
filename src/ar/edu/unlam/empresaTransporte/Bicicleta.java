package ar.edu.unlam.empresaTransporte;

import java.util.HashSet;
import java.util.Set;

public class Bicicleta extends Vehiculo{
	
	protected Set<String> ciudades = new HashSet<>();
	
	public Bicicleta() {
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



	
}
