package ar.edu.unlam.empresaTransporte;

import java.util.Objects;

public class Destino {
	private String ciudad;
	private String direccion;
	
	public Destino(String ciudad, String direccion) {
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Destino destino = (Destino) o;
	    return ciudad.equals(destino.ciudad) && direccion.equals(destino.direccion);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(ciudad, direccion);
	}
}
