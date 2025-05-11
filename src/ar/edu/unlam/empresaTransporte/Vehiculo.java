package ar.edu.unlam.empresaTransporte;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
	protected Double limiteVolumen;
	protected Double limiteCapacidadKg;
	protected Integer cantidadDestinos;
	protected List<Paquete> paquetes = new ArrayList<>();
	protected Double pesoAcumulado = 0.0;
	protected Double volumenAcumulado = 0.0;

	abstract protected Boolean puedeTransportar(Paquete paquete);

	public Boolean agregarPaquete(Paquete paquete) {
		if (puedeTransportar(paquete)) {
			paquetes.add(paquete);
			pesoAcumulado += paquete.getPeso();
			volumenAcumulado += paquete.calcularVolumen();
			return true;
		}
		return false;
	}
	
	protected boolean entraEnLosLimites(Paquete paquete) {
		if ((paquete.calcularVolumen() + volumenAcumulado) > limiteVolumen) return false;
		if ((paquete.getPeso() + pesoAcumulado) > limiteCapacidadKg) return false;
		return true;
	}

}
