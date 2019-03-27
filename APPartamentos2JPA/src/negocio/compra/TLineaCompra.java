package negocio.compra;

public class TLineaCompra {
	private int idTipoVivienda;
	private int cantidadComprada;
	private double precioTotal;
	
	public TLineaCompra() {}
	
	public TLineaCompra(int idTipoVivienda, int cantidadComprada, double precioTotal) {
		this.idTipoVivienda = idTipoVivienda;
		this.cantidadComprada = cantidadComprada;
		this.precioTotal = precioTotal;
	}
	
	public int getId() {
		return this.idTipoVivienda;
	}
	
	public int getCantidadComprada() {
		return this.cantidadComprada;
	}
	
	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public String toString() {
		String temp = "ID de la Vivienda: " + this.getId() + "\n"
				+ "Cantidad de viviendas compradas: " + this.getCantidadComprada() + "\n"
				+ "Precio de la compra: " + this.getPrecioTotal() + "\n";
		return temp;
	}
}
