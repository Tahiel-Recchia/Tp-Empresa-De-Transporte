package ar.edu.unlam.empresaTransporte;

public abstract class Vehiculo {
	protected Double limiteVolumen;
	protected Double limiteCapacidadKg;
	protected Integer cantidadDestinos;
	protected Paquete[] cantidadDePaquetes;
	protected Double pesoAcumulado = 0.0;
	protected Double volumenAcumulado = 0.0;

	abstract protected Boolean puedeTransportar(Paquete paquete);

	public Boolean agregarPaquete(Paquete paquete) {
			if (puedeTransportar(paquete)) {
				for (int i = 0; i < cantidadDePaquetes.length; i++) {
					if (cantidadDePaquetes[i] == null) {
						cantidadDePaquetes[i] = paquete;
						pesoAcumulado += paquete.getPeso();
						volumenAcumulado += paquete.calcularVolumen();
						return true;
					}
				}
			}
			return false;
		}

	public String getDestinos() {
		String resultado = "";
		for (Paquete p : cantidadDePaquetes) {
			if (p != null) {
				resultado += " \n" + p.getDestino().getCiudad() + " - " + p.getDestino().getDireccion() + "\n";
			}
		}
		return resultado;
	}

}
