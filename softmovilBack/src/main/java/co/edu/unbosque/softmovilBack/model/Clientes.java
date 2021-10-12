package co.edu.unbosque.softmovilBack.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Clientes {
	@Id
	private Long cedula_cliente;
	private String nombre_cliente;
	private String direccion;
	private Long telefono_cliente;
	private String correo_cliente;
	
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(Long telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	public String getCorreo_cliente() {
		return correo_cliente;
	}
	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}
	
	
}
