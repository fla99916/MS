package negocio.compra;

import java.sql.Date;
import java.util.HashMap;

public class TCompra {
	private int idCompra;
	private int idCliente;
	private Date fecha; 
	private boolean activo;
	private HashMap<Integer, TLineaCompra> lineaCompra;
	
	public TCompra(){
		lineaCompra = new HashMap<>();
	}
	
	public TCompra(int idCompra, int idCliente, Date fecha, boolean activo) {
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.activo = activo;
		lineaCompra = new HashMap<>();;
	}
	
	public TCompra(int idCompra, int idCliente, Date fecha, boolean activo, HashMap<Integer, TLineaCompra> lineaCompra) {
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.activo = activo;
		this.lineaCompra = lineaCompra;
	}
	
	public int getIdCompra() {
		return this.idCompra;
	}
	
	public int getIdCliente() {
		return this.idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public HashMap<Integer, TLineaCompra> getLineaCompra() {
		return lineaCompra;
	}
	
	public void setLineaCompra(HashMap<Integer, TLineaCompra> lineaCompra) {
		this.lineaCompra = lineaCompra;
	}
	
	public String toString() {
		String temp = "ID de la Compra: " + this.getIdCompra() + "\n"
				+ "ID del Cliente comprador: " + this.getIdCliente() + "\n"
				+ "Fecha de la compra: " + this.getFecha() + "\n" + "\n";

		temp += "LISTA DE VIVIENDAS:\n";
		for(TLineaCompra v: this.getLineaCompra().values()){
			temp += v.toString();
		}
		temp += "-----------------------------------------------------";
		return temp;
	}
}