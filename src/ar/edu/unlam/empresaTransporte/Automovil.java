package ar.edu.unlam.empresaTransporte;

public class Automovil extends Vehiculo {
	private Integer cantidadDeCiudades = 0;

	public Automovil() {
		this.limiteVolumen = 2.0;
		this.cantidadDestinos = 3;
		this.limiteCapacidadKg = 500.0;
		this.cantidadDePaquetes = new Paquete[10];
	}

	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		Boolean puedeTransportar = false;
		if (paquete.getDestino() == null) {
			return false;
		}

		if (entraEnLosLimites(paquete) && verificarCiudad(paquete) && verificarCiudadYDireccion(paquete)
				&& verificarPaquetes() && hayEspacioParaPaquetes()) {

			puedeTransportar = true;
		}
		if (puedeTransportar) {
			CantidadDeCiudades(paquete);
		}
		return puedeTransportar;
	}

	@Override
	public String toString() {
		return "Automóvil";
	}

	private void CantidadDeCiudades(Paquete paquete) {
		boolean ciudadRepetida = false;
		for (int i = 0; i < cantidadDePaquetes.length; i++) {
			if (cantidadDePaquetes[i] != null && paquete.getCiudad().equals(cantidadDePaquetes[i].getCiudad())) {
				ciudadRepetida = true;
				break;
			}
		}
		if (!ciudadRepetida) {
			cantidadDeCiudades += 1;
		}

	}

	private boolean entraEnLosLimites(Paquete paquete) {
		if ((paquete.calcularVolumen() + volumenAcumulado) > limiteVolumen
				|| (paquete.getPeso() + pesoAcumulado) > limiteCapacidadKg) {
			return false;
		}
		return true;
	}

	private boolean verificarCiudad(Paquete paquete) {
		for (int i = 0; i < cantidadDePaquetes.length; i++) {
			if (cantidadDePaquetes[i] != null && cantidadDePaquetes[i].getCiudad().equals((paquete).getCiudad())) {
				return false;
			}
		}
		return true;
	}

	private boolean verificarCiudadYDireccion(Paquete paquete) {
		for (int i = 0; i < cantidadDePaquetes.length; i++) {
			if (cantidadDePaquetes[i] != null && cantidadDePaquetes[i].getCiudad().equals(paquete.getCiudad())
					&& cantidadDePaquetes[i].getDireccion().equals(paquete.getDireccion())) {
				return false;
			}
		}
		return true;
	}

	private boolean verificarPaquetes() {
		if (cantidadDeCiudades >= 3) {
			return false;
		}
		return true;
	}

	private boolean hayEspacioParaPaquetes() {
		for (Paquete p : cantidadDePaquetes) {
			if (p == null) {
				return true;
			}
		}
		return false;
	}
}
