package Modelo;

public class productosDTO {
	
	private long codigoProducto;
	private double ivaCompra;
	private long nitProveedor;
	private String nombreProducto;	
	private double precioCompra;
	private double precioVenta;
	public productosDTO(long codigoProducto, double ivaCompra, long nitProveedor, String nombreProducto,
			double precioCompra, double precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.ivaCompra = ivaCompra;
		this.nitProveedor = nitProveedor;
		this.nombreProducto = nombreProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	
	public productosDTO(long codigoProducto, String nombreProducto, double precioVenta) {
		
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precioVenta = precioVenta;
	}
	
	public productosDTO(long codigoProducto, double ivaCompra, String nombreProducto, double precioVenta) {
		
		this.codigoProducto = codigoProducto;
		this.ivaCompra = ivaCompra;
		this.nombreProducto = nombreProducto;
		this.precioVenta = precioVenta;
	}
	
	public long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public double getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public long getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
}
