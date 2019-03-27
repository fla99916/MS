package presentacion.vistas.vistaCompra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



import negocio.compra.TCompra;
import negocio.compra.TLineaCompra;
import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;


public class VistaCompraImp extends VistaCompra {
	private CompraGUI02 vista;
	String mensaje = "";
	int id;

	
	public VistaCompraImp(){
		vista = new CompraGUI02();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) {
		ArrayList<TTipoVivienda> listaClientes = null;
	
		switch(contexto.getEvento()){
			case ListaComandos.VISTAMENUCOMPRA:
				vista.actualizaVista();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
			break;
			case ListaComandos.VISTAACTUALIZACOMPRA:
				
				listaClientes = (ArrayList<TTipoVivienda>)contexto.getDatos();
				/**for(TTipoVivienda t: listaClientes) {
					if(t.getCantidad() == 0) {
						listaClientes.remove(t);
					}
				}*/
				for (Iterator<TTipoVivienda> iterator = listaClientes.iterator(); iterator.hasNext(); ) {
				    TTipoVivienda t = iterator.next();
				    if (t.getCantidad() == 0) {
				        iterator.remove();
				    }
				}
				vista.actualizaListaViviendas(listaClientes);
			break;
			case ListaComandos.CERRARVISTACOMPRA:
				vista.setVisible(false);
			break;
			case ListaComandos.MOSTRARALTACOMPRA:
				mensaje ="";
				id = (int)contexto.getDatos();
				
				switch(id){
				case -1:
					mensaje += "Error: El cliente introducido no existe ";
				break;
				case -2:
					mensaje += "Error: Fallo al dar de alta la compra ";
				break;
				default:
					mensaje += "Éxito al dar de alta la compra ID: " + Integer.toString(id);
					break;	
				}
				
				if(id >= 1){
					vista.mensaje(mensaje, "Exito");
					vista.setIdField( (int)contexto.getDatos());
				}	
				else{
					vista.mensaje(mensaje, "Error");
				}
			break;
			
			case ListaComandos.MOSTRARBAJACOMPRA:
				mensaje ="";
				id = (int)contexto.getDatos();
				
				switch(id){
				case -3:
					mensaje += "Error: La compra introducida no existe ";
				break;
				case -2:
					mensaje += "Error: La compra ya está dada de baja ";
				break;
				case -1:
					mensaje += "Error: en la bd ";
				break;
				
				default:
					mensaje += "Éxito al dar de baja la compra ID: " + Integer.toString(id);
					break;	
				}
				
				if(id >= 1){
					vista.mensaje(mensaje, "Exito");
					vista.setIdField( (int)contexto.getDatos());
				}	
				else{
					vista.mensaje(mensaje, "Error");
				}
			break;
			
			case ListaComandos.MOSTRARCONSULTARCOMPRA:
				mensaje ="";
				TCompra tCompra = (TCompra)contexto.getDatos();
				
				if(tCompra == null){
					mensaje += "Error: La compra introducida no existe ";
				} else {
					mensaje += "Éxito al mostrar la compra ID: " + Integer.toString(tCompra.getIdCompra());
				}
				
				if(tCompra != null){
					vista.mensaje(mensaje, "Exito");
					//vista.setDataFields(tCompra);
					vista.setCompraFields(tCompra, "COMPRA "+ Integer.toString(tCompra.getIdCompra())+" : \n");
					//vista.setListFieldViviendas(tCompra.getLineaCompra().values());
					
					Collection<TLineaCompra> lista = tCompra.getLineaCompra().values();
					ArrayList<TLineaCompra> viviendas = new ArrayList<TLineaCompra>();
					for(TLineaCompra v: lista) {
						viviendas.add(v);
					}
					vista.setCarrito(viviendas);
				}	
				else{
					vista.mensaje(mensaje, "Error");
				}
			break;
			
			case ListaComandos.MOSTRARLISTARCOMPRA:
				mensaje ="";
				ArrayList<TCompra> listaCompras = (ArrayList<TCompra>)contexto.getDatos();
				
				if(listaCompras.size() == 0){
					mensaje += "Error: No existen compras ";
				} else {
					mensaje += "Éxito al mostrar la lista de compras";
				}
				
				if(listaCompras.size() > 0){
					vista.mensaje(mensaje, "Exito");
					vista.setListFieldCompras(listaCompras);
				}	
				else{
					vista.mensaje(mensaje, "Error");
				}
			break;
			
			case ListaComandos.MOSTRARMODIFICARCOMPRA:
				mensaje ="";
				id = (Integer)contexto.getDatos();
				
				if(id <= 0){
					mensaje += "Error: No existen compras o el cliente introducido ";
				} else {
					mensaje += "Éxito al modificar la compra ";
				}
				
				if(id > 0){
					vista.mensaje(mensaje, "Exito");
				}	
				else{
					vista.mensaje(mensaje, "Error");
				}
			break;
		}
	}

}
