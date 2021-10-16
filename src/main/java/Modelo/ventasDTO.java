package Modelo;

public class ventasDTO {

	private long codigoVenta;
	private long cedulaCliente;
	private long cedulaUsuario;
	private double ivaVenta;
	private double totalVenta;
	private double valorVenta;
	public ventasDTO(long codigoVenta, long cedulaCliente, long cedulaUsuario, double ivaVenta, double totalVenta,
			double valorVenta) {
		
		this.codigoVenta = codigoVenta;
		this.cedulaCliente = cedulaCliente;
		this.cedulaUsuario = cedulaUsuario;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}
	public ventasDTO(long cedulaCliente, long cedulaUsuario, double ivaVenta, double totalVenta, double valorVenta) {
		
		this.cedulaCliente = cedulaCliente;
		this.cedulaUsuario = cedulaUsuario;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}
	public long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public long getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public long getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public double getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	
}
