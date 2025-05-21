package ar.edu.unlam.empresaTransporte;

import java.util.LinkedList;
import java.util.List;

public class Empresa {
	
	private List<Vehiculo> vehiculos = new LinkedList<>();
	
	public Empresa(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public Empresa(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	
	public Empresa() {
	}
	
	public boolean agregarVehiculo(Vehiculo vehiculo) {
		if(!vehiculos.contains(vehiculo)) {
			return vehiculos.add(vehiculo);
		}
		return false;
	}
	
	public boolean agregarPaquete(Vehiculo vehiculo, Paquete paquete) {
		return vehiculo.agregarPaquete(paquete);
	}
	
	public List<Vehiculo> getVehiculos(){
		return vehiculos;
	}
	
	public boolean eliminarVehiculo(Vehiculo vehiculo) {
		return vehiculos.remove(vehiculo);
	}
	
	public boolean eliminarPaquete(Vehiculo vehiculo, Paquete paquete) {
		return vehiculo.paquetes.remove(paquete);
	}
	
	public List<Paquete> obtenerListadoDePaquetes(Vehiculo vehiculo) {
		return vehiculo.getPaquetes();
	}
}
