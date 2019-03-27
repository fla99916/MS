package presentacion.vistas.vistaPrincipal;

import javax.swing.JOptionPane;

import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaPrincipalImp extends VistaPrincipal {
	
	private principalGUI vista;
	
	public VistaPrincipalImp(){
		vista = new principalGUI();
	}

	
	@Override
	public void update(Contexto contexto) {
		if(contexto.getEvento() == ListaComandos.VISTAMENUPRINCIPAL){
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
		}
		
		else if(contexto.getEvento() == ListaComandos.CERRARVISTAPRINCIPAL){
			
			JOptionPane.showMessageDialog(
	    		    vista, 
	    		    "Hasta luego!", 
	    		    "Información",
	    		    JOptionPane.INFORMATION_MESSAGE, 
	         null);
			vista.setVisible(false);
			System.exit(0);
			
		}
	}
	

}
