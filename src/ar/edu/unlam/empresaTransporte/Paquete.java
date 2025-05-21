package ar.edu.unlam.empresaTransporte;

public class Paquete {
	private Double alto;
	private Double ancho;
	private Double profundo;
	private Double peso;
	private Destino destino;
	
	public Paquete(Double alto, Double ancho, Double profundo, Double peso, Destino destino) {
	 this.alto = alto;
	 this.ancho = ancho;
	 this.profundo = profundo;
	 this.peso = peso;
	 this.destino = destino;
	}
	
	public Paquete(Double alto, Double ancho, Double profundo, Double peso) {
		 this.alto = alto;
		 this.ancho = ancho;
		 this.profundo = profundo;
		 this.peso = peso;
		}
	
	public Double calcularVolumen() {
		return alto * ancho * profundo;
	}


	public String getCiudad() {
		return destino.getCiudad();
	}
	
	public String getDireccion() {
		return destino.getDireccion();
	}
	
	public Double getPeso() {
		return this.peso;
	}
	
	public Destino getDestino() {
		return destino;
	}
	
	public void setDireccion(String direccion) {
		destino.setDireccion(direccion);
	}
	
	public void setCiudad(String ciudad) {
		destino.setCiudad(ciudad);
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}
