package ar.edu.unlam.empresaTransporte;

import java.util.*;

public class Automovil extends Vehiculo {

	protected Set<Destino> destinos = new HashSet<>();
	protected Set<String> ciudades = new HashSet<>();

	public Automovil() {
		this.limiteVolumen = 2.0;
		this.cantidadDestinos = 3;
		this.limiteCapacidadKg = 500.0;
	}



	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		if (paquete.getDestino() == null) return false;
		if (!entraEnLosLimites(paquete)) return false;
		if (!verificarPaquetes(paquete)) return false; 
		aniadirCiudadYDestino(paquete);
		return true;
	}


	private void aniadirCiudadYDestino(Paquete paquete) {
		    destinos.add(paquete.getDestino());
		    ciudades.add(paquete.getCiudad());
	}


	private boolean verificarPaquetes(Paquete paquete) {
		if (!ciudades.contains(paquete.getCiudad()) && ciudades.size() >= cantidadDestinos) return false;

		if(destinos.contains(paquete.getDestino())) return false;
	return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ciudades, destinos);
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
		return Objects.equals(ciudades, other.ciudades) && Objects.equals(destinos, other.destinos);
	}

}
