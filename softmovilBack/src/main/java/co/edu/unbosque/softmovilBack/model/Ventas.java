package co.edu.unbosque.softmovilBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ventas {
	
	@GeneratedValue @Id 
	private Long id_venta;
	
	private Long codigo_venta;
	private Long cedula_cliente;
	private Long cedula_usuario;
	private Double iva_venta;
	private Double total_venta;
	private Double valor_venta;
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public Long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public Double getIva_venta() {
		return iva_venta;
	}
	public void setIva_venta(Double iva_venta) {
		this.iva_venta = iva_venta;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Long getId_venta() {
		return id_venta;
	}
	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
	}
	
}
