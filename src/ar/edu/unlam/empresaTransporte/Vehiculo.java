package ar.edu.unlam.empresaTransporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(cantidadDestinos, limiteCapacidadKg, limiteVolumen, paquetes, pesoAcumulado,
				volumenAcumulado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(cantidadDestinos, other.cantidadDestinos)
				&& Objects.equals(limiteCapacidadKg, other.limiteCapacidadKg)
				&& Objects.equals(limiteVolumen, other.limiteVolumen) && Objects.equals(paquetes, other.paquetes)
				&& Objects.equals(pesoAcumulado, other.pesoAcumulado)
				&& Objects.equals(volumenAcumulado, other.volumenAcumulado);
	}
}
