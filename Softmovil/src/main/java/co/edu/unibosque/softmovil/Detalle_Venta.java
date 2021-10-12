package co.edu.unibosque.softmovil;

public class Detalle_Venta {

	private Integer codigo_detalle_venta;
	private Integer cantidad_producto;
	private Long codigo_producto;
	private String descripcion_producto;
	private Long codigo_venta;
	private Double valor_total;
	private Double valor_venta;
	private Double valor_iva;
	private Double precio_producto;
	
	public Integer getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public Integer getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public Long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public String getDescripcion_producto() {
		return descripcion_producto;
	}
	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Double getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(Double valor_iva) {
		this.valor_iva = valor_iva;
	}
	public Double getPrecio_producto() {
		return precio_producto;
	}
	public void setPrecio_producto(Double precio_producto) {
		this.precio_producto = precio_producto;
	}

}
