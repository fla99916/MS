package presentacion.vistas.vistaTipoVivienda;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ScrollPaneConstants;

import negocio.tipoVivienda.TChalet;
import negocio.tipoVivienda.TPiso;
import negocio.tipoVivienda.TTipoVivienda;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Controlador;

@SuppressWarnings("serial")
public class TipoViviendaGUI extends javax.swing.JFrame {
	
	
	public TipoViviendaGUI(){
		initComponents();
	}

	private void initComponents() {
		jLabelIDTipoVivienda = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCiudad = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelActivo = new javax.swing.JLabel();
        jLabelPiso = new javax.swing.JLabel();
        jLabelPortero = new javax.swing.JLabel();
        jLabelNAscensores = new javax.swing.JLabel();
        jLabelChalet = new javax.swing.JLabel();
        jLabelJardin = new javax.swing.JLabel();
        jLabelNPlantas = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldNPlantas = new javax.swing.JTextField();
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jCheckBoxPiso = new JRadioButton();
        jCheckBoxChalet = new JRadioButton();
        group.add(jCheckBoxPiso);
        group.add(jCheckBoxChalet);
        jCheckBoxPortero = new javax.swing.JCheckBox();
        jCheckBoxJardin = new javax.swing.JCheckBox();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldNAscensores = new javax.swing.JTextField();
        jButtonAlta = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonMostrar = new javax.swing.JButton();
        jButtonTipoVivMasVendio = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jTextAreaLista = new javax.swing.JTextArea();
        jButtonListar = new javax.swing.JButton();
        jScrollPaneLista = new javax.swing.JScrollPane(jTextAreaLista);
        jScrollPaneLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
        jTextFieldNPlantas.setEditable(false);
        jTextFieldNAscensores.setEditable(false);
        jCheckBoxPortero.setEnabled(false);
        jCheckBoxJardin.setEnabled(false);
        jTextAreaLista.setEditable(false);

	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    setPreferredSize(new java.awt.Dimension(1200, 550));
	    
	    jLabelIDTipoVivienda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jLabelIDTipoVivienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    jLabelIDTipoVivienda.setText("ID TIPOVIVIENDA:");

	    jLabelDireccion.setFont(new java.awt.Font("Tahoma", 1, 14));
	    jLabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDireccion.setText("DIRECCIÓN:");

        jLabelCiudad.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCiudad.setText("CIUDAD:");

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrecio.setText("PRECIO:");

        jLabelCantidad.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad.setText("CANTIDAD:");

        jLabelActivo.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelActivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelActivo.setText("ACTIVO:");

        jLabelPiso.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelPiso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPiso.setText("PISO:");

        jLabelPortero.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelPortero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPortero.setText("PORTERO:");

        jLabelNAscensores.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelNAscensores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNAscensores.setText("NÚMERO ASCENSORES:");

        jLabelChalet.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelChalet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChalet.setText("CHALET:");

        jLabelJardin.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelJardin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJardin.setText("JARDÍN:");

        jLabelNPlantas.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelNPlantas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNPlantas.setText("NÚMERO PLANTAS:");
        
        jButtonAlta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAlta.setText("ALTA");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonBaja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N        
        jButtonBaja.setText("BAJA");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });
        
        //--------------------------------------------------------------------------------
        jCheckBoxChalet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N        
        jCheckBoxChalet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxChaletActionPerformed(evt);
            }
        });
        
        jCheckBoxPiso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N        
        jCheckBoxPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPisoActionPerformed(evt);
            }
        });
        
        
        //---------------------------------------------------------------------------------

        
        jButtonModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonMostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonMostrar.setText("CONSULTAR");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });
        
        jButtonListar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonListar.setText("LISTAR");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonTipoVivMasVendio.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonTipoVivMasVendio.setText("TIPO VIVIENDA MÁS VENDIDO");
        jButtonTipoVivMasVendio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoVivMasVendidoActionPerformed(evt);
            }
        });
        
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelIDTipoVivienda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(jLabelDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldID)
                                        .addComponent(jTextFieldDireccion)
                                        .addComponent(jTextFieldCiudad)
                                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBoxActivo))
                                    .addGap(95, 95, 95))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelNAscensores)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldNAscensores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabelPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jCheckBoxPiso))
                                                .addComponent(jLabelPortero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBoxPortero)))
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelJardin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBoxJardin))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelChalet, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBoxChalet))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelNPlantas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldNPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(61, 61, 61)))
                            .addComponent(jScrollPaneLista, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(jButtonAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonTipoVivMasVendio, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                    .addGap(108, 108, 108))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelIDTipoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBoxActivo))
                            .addGap(18, 38, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelChalet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBoxChalet, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxPiso)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelPortero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBoxPortero)
                                        .addComponent(jLabelJardin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBoxJardin))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelNAscensores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNAscensores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelNPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jCheckBoxJardin)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPaneLista, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonTipoVivMasVendio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jButtonAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addContainerGap())
            );
        pack();
	}
	
	private void limpiarComponentes(){
		this.jCheckBoxActivo.setSelected(false);
		this.jCheckBoxChalet.setSelected(false);
		this.jCheckBoxJardin.setSelected(false);
		this.jCheckBoxPiso.setSelected(false);
		this.jCheckBoxPortero.setSelected(false);
		this.group.clearSelection();
		this.jTextAreaLista.setText("");
		this.jTextFieldCantidad.setText("");
		this.jTextFieldCiudad.setText("");
		this.jTextFieldDireccion.setText("");
		this.jTextFieldID.setText("");
		this.jTextFieldNAscensores.setText("");
		this.jTextFieldNPlantas.setText("");
		this.jTextFieldPrecio.setText("");
	}
	
	
	 // Rellenar el id
    public void setIdField(int id){
	   String idAux = Integer.toString(id);
	   jTextFieldID.setText(idAux);
    }
    
 // Rellenar el campo de la lista
    public void setListField(ArrayList<TTipoVivienda> lista) {
 	   String temp;
 	   for (TTipoVivienda viv : lista) {
 		   temp = viv.toString();
 		   jTextAreaLista.append(temp + "\n");
 	   }
    }
    
    public void setTViviendatField(TTipoVivienda vivienda, String mensaje) {
  	   String temp;
  	   
  	   temp=mensaje+"\n";
  	   temp += vivienda.toString();
  	   jTextAreaLista.append(temp + "\n");
  	   
     }
    
    
 // Rellenar los campos de datos
   /* public void setDataFields(TTipoVivienda tTipoViv) {
 	  String id = Integer.toString(tTipoViv.getId());
 	   if (tTipoViv.getActivo())
 		   this.jCheckBoxActivo.setSelected(true);
 	   else
 		   this.jCheckBoxActivo.setSelected(false);
 	   
 		this.jTextFieldID.setText(id);
 		this.jTextFieldDireccion.setText(tTipoViv.getDireccion());
 		this.jTextFieldCiudad.setText(tTipoViv.getCiudad());
 		this.jTextFieldPrecio.setText(Double.toString(tTipoViv.getPrecio()));
 		this.jTextFieldCantidad.setText(Integer.toString(tTipoViv.getCantidad()));
 	   	
 		//Falta las funciones en negocio
 		if(tTipoViv instanceof TChalet){
 			//crear un transfer chaelt
 			this.jCheckBoxChalet.setSelected(true);
 			if(((TChalet)tTipoViv).getJardin())
 				this.jCheckBoxJardin.setSelected(true);
 			else
 				this.jCheckBoxJardin.setSelected(false);
 			this.jTextFieldNPlantas.setText(Integer.toString(((TChalet)tTipoViv).getPlantas()));
 		}
 		else if(tTipoViv instanceof TPiso){
 			//crear un transfer piso
 			this.jCheckBoxPiso.setSelected(true);
 			this.jCheckBoxChalet.setSelected(false);
 			if(((TPiso)tTipoViv).getPortero() == true)
 				this.jCheckBoxPortero.setSelected(true);
 			else
 				this.jCheckBoxPortero.setSelected(false);
 			this.jTextFieldNAscensores.setText(Integer.toString(((TPiso)tTipoViv).getNumAscensores()));
 		}
 			
 		
    }*/
    
    public void mensaje(String mensaje, String status){
	   	if(status=="Exito"){
		   JOptionPane.showMessageDialog(this, mensaje, status, JOptionPane.INFORMATION_MESSAGE);
	   	}
	   	else if(status=="Error"){
		   JOptionPane.showMessageDialog(this, mensaje, status, JOptionPane.ERROR_MESSAGE);
	   	}
    }

      
   protected void jCheckBoxChaletActionPerformed(ActionEvent evt){
	   if(jCheckBoxChalet.isSelected()){
		   jTextFieldNPlantas.setEditable(true);
		   jCheckBoxJardin.setEnabled(true);
	   }
	   
	   if(!jCheckBoxPiso.isSelected()){
		   jTextFieldNAscensores.setEditable(false);
		   jCheckBoxPortero.setEnabled(false);
		   jCheckBoxPortero.setSelected(false);
		   jTextFieldNAscensores.setText("");
	   }

   }
   
   protected void jCheckBoxPisoActionPerformed(ActionEvent evt){
	   if(jCheckBoxPiso.isSelected()){
		   jTextFieldNAscensores.setEditable(true);
		   jCheckBoxPortero.setEnabled(true);
	   }
	   
	   if(!jCheckBoxChalet.isSelected()){
		   jTextFieldNPlantas.setEditable(false);
		   jCheckBoxJardin.setEnabled(false);
		   jCheckBoxJardin.setSelected(false);
		   jTextFieldNPlantas.setText("");
	   }
	   
	   

   }
      
      
      
    
	protected void jButtonAltaActionPerformed(ActionEvent evt) {	
		//Primero comprobamos que los campos estén rellenos correctamente
		// en este caso se debe comprobar que el usuario ha indicado el Tipo de Vivienda
		if( jTextFieldDireccion.getText().isEmpty() || jTextFieldCiudad.getText().isEmpty()|| jTextFieldPrecio.getText().isEmpty() || jTextFieldCantidad.getText().isEmpty() 
    			|| (!jCheckBoxChalet.isSelected() && !jCheckBoxPiso.isSelected()) || (jTextFieldNPlantas.getText().isEmpty() && jCheckBoxChalet.isSelected()) 
    			|| (jTextFieldNAscensores.getText().isEmpty() && jCheckBoxPiso.isSelected())){
    		JOptionPane.showMessageDialog(this, "Rellena los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		try {
        		String dirAux = jTextFieldDireccion.getText();
        		String ciuAux = jTextFieldCiudad.getText();
        		double precioAux = Double.parseDouble(jTextFieldPrecio.getText());
        		int cantAux = Integer.parseInt(jTextFieldCantidad.getText());
        		TTipoVivienda tTVivienda = null;
        		
        		if(cantAux < 1){
            		JOptionPane.showMessageDialog(this, "La cantidad de viviendas debe ser un número mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        		}	
        		
        		else if(precioAux <= 0){
            		JOptionPane.showMessageDialog(this, "El precio debe ser un número mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        		else{
        			if(this.jCheckBoxChalet.isSelected()){
            			boolean jardin=false;
            			int auxNPlantas = 0;
            			auxNPlantas=Integer.parseInt(jTextFieldNPlantas.getText());
            			
            			if(auxNPlantas < 1){
            	    		JOptionPane.showMessageDialog(this, "Número de plantas debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            			else{
            				//En caso de que tenga jardin se modifican los atributos
                			if(this.jCheckBoxJardin.isSelected()){
                				jardin=true;
                			}
                			
                			tTVivienda=new TChalet(-1,jardin,auxNPlantas, cantAux, dirAux, ciuAux, precioAux,true);
                			Controlador.getInstance().run(ListaComandos.ALTATIPOVIVIENDA,tTVivienda);
                    		limpiarComponentes();
            			}
            		}
            		
            		else if(this.jCheckBoxPiso.isSelected()){
            			boolean portero=false;
            			int auxNAsc = 0;
            			auxNAsc=Integer.parseInt(jTextFieldNAscensores.getText());
            			if(auxNAsc < 0){
            	    		JOptionPane.showMessageDialog(this, "Número de ascensores debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            			
            			else{
            				//En el caso de que tenga portero se modifican los atributos
                			if(this.jCheckBoxPortero.isSelected()){
                				portero=true;
                			}
                			//TPiso(int id, boolean portero, int numAscensores, int cantidad, String direccion, String ciudad, double precio, boolean activo)
                			tTVivienda=new TPiso(-1,portero,auxNAsc,cantAux,dirAux,ciuAux,precioAux,true);
                			Controlador.getInstance().run(ListaComandos.ALTATIPOVIVIENDA,tTVivienda);
                    		limpiarComponentes();
            			}
            		}
        		}
        		
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "Error en el formato de los campos", "Error", JOptionPane.ERROR_MESSAGE);

            }
    	}	
	}

	protected void jButtonBajaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		if (this.jTextFieldID.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "Por favor indica el id del Tipo de Vivienda.", "Error", JOptionPane.ERROR_MESSAGE);
    	} else{
    		try {
    			int id =Integer.parseInt(jTextFieldID.getText());
        		Controlador.getInstance().run(ListaComandos.BAJATIPOVIVIENDA, id);
    	    	limpiarComponentes();
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "El campo ID CLIENTE debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        		limpiarComponentes();

            }
    		
    	}
	}

	protected void jButtonModificarActionPerformed(ActionEvent evt) {
		if( jTextFieldID.getText().isEmpty() || jTextFieldDireccion.getText().isEmpty() || jTextFieldCiudad.getText().isEmpty()|| jTextFieldPrecio.getText().isEmpty() || jTextFieldCantidad.getText().isEmpty() 
    			|| (!jCheckBoxChalet.isSelected() && !jCheckBoxPiso.isSelected()) || (jTextFieldNPlantas.getText().isEmpty() && jCheckBoxChalet.isSelected()) 
    			|| (jTextFieldNAscensores.getText().isEmpty() && jCheckBoxPiso.isSelected())){
    		JOptionPane.showMessageDialog(this, "Rellena los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
    	}
		else{
    		
    		try {
    			int id =Integer.parseInt(jTextFieldID.getText());
        		String dirAux = jTextFieldDireccion.getText();
        		String ciuAux= jTextFieldCiudad.getText();
        		double precioAux = Double.parseDouble(jTextFieldPrecio.getText());
        		int cantAux = Integer.parseInt(jTextFieldCantidad.getText());
        		TTipoVivienda tTVivienda = null;
        		
        		if(cantAux < 1){
            		JOptionPane.showMessageDialog(this, "La cantidad de viviendas debe ser un número mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        		}	
        		
        		else if(precioAux <= 0){
            		JOptionPane.showMessageDialog(this, "El precio debe ser un número mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        		
        		else{
        			if(this.jCheckBoxChalet.isSelected()){
            			boolean jardin=false;
            			int auxNPlantas = 0;
            			auxNPlantas=Integer.parseInt(jTextFieldNPlantas.getText());
            			//En caso de que tenga jardin se modifican los atributos
            			if(this.jCheckBoxJardin.isSelected()){
            				jardin=true;
            			}
            			
            			if(auxNPlantas < 1){
            	    		JOptionPane.showMessageDialog(this, "Número de plantas debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            			
            			else{
            				//TChalet(int id, boolean jardin, int plantas, int cantidad, String direccion, String ciudad, double precio, boolean activo)
                			tTVivienda=new TChalet(id,jardin,auxNPlantas, cantAux, dirAux, ciuAux, precioAux,true);
                			Controlador.getInstance().run(ListaComandos.MODIFICARTIPOVIVIENDA, tTVivienda);
                	    	limpiarComponentes();
            			}
            			
            		}
            		else if(this.jCheckBoxPiso.isSelected()){
            			boolean portero=false;
            			int auxNAsc = 0;
            			auxNAsc=Integer.parseInt(jTextFieldNAscensores.getText());
            			//En el caso de que tenga portero se modifican los atributos
            			if(this.jCheckBoxPortero.isSelected()){
            				portero=true;
            			}
            			
            			if(auxNAsc < 0){
            	    		JOptionPane.showMessageDialog(this, "Número de ascensores debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            			
            			else{
            				//TPiso(int id, boolean portero, int numAscensores, int cantidad, String direccion, String ciudad, double precio, boolean activo)
                			tTVivienda=new TPiso(id,portero,auxNAsc,cantAux,dirAux,ciuAux,precioAux,true);
                			Controlador.getInstance().run(ListaComandos.MODIFICARTIPOVIVIENDA, tTVivienda);
                	    	limpiarComponentes();
            			}
            		}
	
        		}
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "Error en el formato de los campos", "Error", JOptionPane.ERROR_MESSAGE);

            }
    	}
	}

	protected void jButtonMostrarActionPerformed(ActionEvent evt) {
		if (jTextFieldID.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "Por favor indica el id del TipoVivienda.", "Error", JOptionPane.ERROR_MESSAGE);
    	} else{
    		try {
    			int id = Integer.parseInt(jTextFieldID.getText());
        		limpiarComponentes();
        		Controlador.getInstance().run(ListaComandos.CONSULTARTIPOVIVIENDA, id);
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "El campo ID CLIENTE debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        		limpiarComponentes();

            }
    		
    	}
	}

	protected void jButtonListarActionPerformed(ActionEvent evt) {
		limpiarComponentes();
    	Controlador.getInstance().run(ListaComandos.LISTARTIPOVIVIENDA, 0);
    	this.jCheckBoxPiso.setSelected(false);
    	this.jCheckBoxChalet.setSelected(false);
	}

	protected void jButtonTipoVivMasVendidoActionPerformed(ActionEvent evt) {
		limpiarComponentes();
    	Controlador.getInstance().run(ListaComandos.TIPOVIVIENDAMASVENDIDO, 0);
		
	}

	protected void jButtonSalirActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		limpiarComponentes();
		Controlador.getInstance().run(ListaComandos.CERRARVISTATIPOVIVIENDA, null);
		
	}
	
	public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TipoViviendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoViviendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoViviendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoViviendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoViviendaGUI().setVisible(true);
            }
        });
    }

	// Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonTipoVivMasVendio;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton jCheckBoxChalet;
    private javax.swing.JCheckBox jCheckBoxJardin;
    private JRadioButton jCheckBoxPiso;
    private javax.swing.JCheckBox jCheckBoxPortero;
    private javax.swing.JLabel jLabelActivo;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelChalet;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelIDTipoVivienda;
    private javax.swing.JLabel jLabelJardin;
    private javax.swing.JLabel jLabelNAscensores;
    private javax.swing.JLabel jLabelNPlantas;
    private javax.swing.JLabel jLabelPiso;
    private javax.swing.JLabel jLabelPortero;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTextArea jTextAreaLista;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNAscensores;
    private javax.swing.JTextField jTextFieldNPlantas;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration 
	
}
