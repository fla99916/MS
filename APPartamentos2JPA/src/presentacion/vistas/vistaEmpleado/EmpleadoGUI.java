/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vistas.vistaEmpleado;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.empleado.TAgenteInmobiliario;
import negocio.empleado.TDirector;
import negocio.empleado.TEmpleado;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 *
 * @author Admin
 */
@SuppressWarnings("serial")
public class EmpleadoGUI extends javax.swing.JFrame {

    /**
     * Creates new form Empleado
     */
    public EmpleadoGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDomicilio = new javax.swing.JTextField();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jCheckBoxDirector = new javax.swing.JCheckBox();
        jCheckBoxAgente = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jButtonAlta = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtoModificar = new javax.swing.JButton();
        jButtonMostrar = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jTextFieldPolitica = new javax.swing.JTextField();
        jTextFieldAnosExperiencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDepartamentos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSueldo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Empleado");

        jLabel2.setText("Id Empleado");

        jLabel3.setText("DNI");

        jLabel4.setText("Nombre");

        jLabel5.setText("Domicilio");

        jLabel6.setText("Activo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBoxDirector.setText("Director");
        jCheckBoxDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDirectorActionPerformed(evt);
            }
        });
        

        jCheckBoxAgente.setText("Agente inmoviliario");
        jCheckBoxAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAgenteActionPerformed(evt);
            }
        });

        jLabel7.setText("Pol�tica empresarial");

        jLabel8.setText("A�os experiencia");

        jButtonAlta.setText("Alta");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonBaja.setText("Baja");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jButtoModificar.setText("Modificar");
        jButtoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabel9.setText("Id Departamento");

        jLabel10.setText("Sueldo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator9)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jCheckBoxActivo)
                                        .addComponent(jTextFieldId)
                                        .addComponent(jTextFieldDni)
                                        .addComponent(jTextFieldNombre)
                                        .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .addComponent(jTextFieldSueldo)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldDepartamentos)))
                            .addComponent(jLabel10))
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBoxDirector)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldPolitica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(210, 210, 210)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBoxAgente))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(107, 107, 107)
                                    .addComponent(jLabel8)
                                    .addGap(21, 21, 21)
                                    .addComponent(jTextFieldAnosExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButtonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxActivo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(34, 34, 34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxDirector)
                    .addComponent(jCheckBoxAgente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldPolitica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldAnosExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlta)
                    .addComponent(jButtonBaja)
                    .addComponent(jButtoModificar)
                    .addComponent(jButtonMostrar)
                    .addComponent(jButtonListar)
                    .addComponent(jButtonSalir))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void limpiarComponentes() {
		jTextFieldAnosExperiencia.setText("");
		jTextFieldDepartamentos.setText("");
		jTextFieldDni.setText("");
		jTextFieldDomicilio.setText("");
		jTextFieldId.setText("");
		jTextFieldNombre.setText("");
		jTextFieldPolitica.setText("");
		jCheckBoxActivo.setSelected(false);
		jCheckBoxAgente.setSelected(false);
		jCheckBoxDirector.setSelected(false);
		jTextFieldPolitica.setEditable(false);
		jTextFieldAnosExperiencia.setEditable(false);
		jTextArea1.setText("");
	}

	
	public void mensaje(String mensaje, boolean exito){
	   	if(exito){
		   JOptionPane.showMessageDialog(this, mensaje, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
	   	}
	   	else{
		   JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	   	}

   }
	
	public void mostrarEmpleado(String mensaje, TEmpleado emp){
		limpiarComponentes();
	   	if(emp != null){
		   JOptionPane.showMessageDialog(this, mensaje, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
		   jTextFieldDepartamentos.setText(Integer.toString(emp.getDepartamento()));
		   jTextFieldDni.setText(emp.getDni());
		   jTextFieldDomicilio.setText(emp.getDomicilio());
		   jTextFieldId.setText(Integer.toString(emp.getIdEmpleado()));
		   jTextFieldNombre.setText(emp.getNombre());
		   jTextFieldSueldo.setText(Double.toString(emp.getSueldo()));
		   jCheckBoxActivo.setSelected(emp.getActivo());
		   
		   if(emp.getClass().getName() == "negocio.empleado.TDirector"){
				jCheckBoxDirector.setSelected(true);
				jTextFieldPolitica.setText(((TDirector) emp).getPoliticaEmpresarial());
		   }else{
				jCheckBoxAgente.setSelected(true);
				jTextFieldAnosExperiencia.setText(Integer.toString(((TAgenteInmobiliario) emp).getA�osExperiencia()));
		   }
		   
	   	}
	   	else{
		   JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	   	}

   }
	
	 public void setListField(ArrayList<TEmpleado> lista) {
		   String temp;
		   for (TEmpleado emp : lista) {
			   temp = emp.toString();
			   jTextArea1.append(temp + "\n");
		   }
	   }
	
	
	// Comprobaciones hechas
	private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {
		

		try {
			String dni = jTextFieldDni.getText();
			String nombre = jTextFieldNombre.getText();
			String domicilio = jTextFieldDomicilio.getText();
			int departamento = Integer.parseInt(jTextFieldDepartamentos.getText());
			double sueldo = Double.parseDouble(jTextFieldSueldo.getText());
			
			// Dni, nombre, domicilio relleno
			if (jTextFieldDni.getText().isEmpty() || jTextFieldNombre.getText().isEmpty()
					|| jTextFieldDomicilio.getText().isEmpty() || jTextFieldDepartamentos.getText().isEmpty() || jTextFieldSueldo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, rellena los campos de empleado", "Error",
						JOptionPane.ERROR_MESSAGE);
			}			
			else if(departamento <= 0 ){
				JOptionPane.showMessageDialog(this, "El id departamento debe ser un n�mero mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(sueldo <= 0 ){
				JOptionPane.showMessageDialog(this, "El id departamento debe ser un n�mero mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else {
				// Comprobar que algun tipo de empleado esta seleccionado
				if (jCheckBoxDirector.isSelected() || jCheckBoxAgente.isSelected()) {
					// Comprobar que el campo referente al checkbox seleccionado
					// esta relleno
					if (jCheckBoxDirector.isSelected()) {
						if (!jTextFieldPolitica.getText().isEmpty()) {
							String politicaEmpresarial = jTextFieldPolitica.getText();
							TEmpleado e = new TDirector(dni, nombre, domicilio, true, departamento,	politicaEmpresarial, sueldo);
							Controlador.getInstance().run(ListaComandos.ALTAEMPLEADO, e);
						} else {
							JOptionPane.showMessageDialog(this, "Por favor, rellena la pol�tica empresarial del director", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						if (!jTextFieldAnosExperiencia.getText().isEmpty()) {
							int anosEperiencia = Integer.parseInt(jTextFieldAnosExperiencia.getText());
							if(anosEperiencia >= 0){
								TEmpleado e = new TAgenteInmobiliario(dni, nombre, domicilio, true, departamento, anosEperiencia, sueldo);
								Controlador.getInstance().run(ListaComandos.ALTAEMPLEADO, e);
							}
							else{
								JOptionPane.showMessageDialog(this, "Los a�os de experiencia del agente inmobiliario debe ser un n�mero positivo","Error", JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(this, "Por favor, rellena los a�os de experiencia del agente",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de empleado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Los a�os de experiencia y el id departamento  deben ser un entero positivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Comprobaciones hechas
	private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {
		int id;
		try {
			if (!jTextFieldId.getText().isEmpty()) {

				id = Integer.parseInt(jTextFieldId.getText());
				
				if(id <= 0){
					JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else{
					Controlador.getInstance().run(ListaComandos.BAJAEMPLEADO, id);
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "Introduzca un ID de empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private int jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {
		int id;
		String dni = "";
		String nombre = "";
		String domicilio = "";
		int departamento = -1;
		double sueldo = -1;

		if (!jTextFieldId.getText().isEmpty()) { 
			try {
				id = Integer.parseInt(jTextFieldId.getText());
				
				if(id <= 0){
					JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else{
					
					if(jTextFieldDni.getText().isEmpty() || jTextFieldNombre.getText().isEmpty() || jTextFieldDomicilio.getText().isEmpty() || jTextFieldDepartamentos.getText().isEmpty() || jTextFieldSueldo.getText().isEmpty()){
						JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);

					}
					else{
						dni = jTextFieldDni.getText();
						nombre = jTextFieldNombre.getText();
						domicilio = jTextFieldDomicilio.getText();
						departamento = Integer.parseInt(jTextFieldDepartamentos.getText());
						sueldo = Double.parseDouble(jTextFieldSueldo.getText());
						
						if(departamento <= 0){		
							JOptionPane.showMessageDialog(this, "Id departamento debe ser un n�mero positivo", "Error", JOptionPane.ERROR_MESSAGE);
							return 0;
						}
						if(sueldo <= 0){		
							JOptionPane.showMessageDialog(this, "Sueldo debe ser un n�mero positivo", "Error", JOptionPane.ERROR_MESSAGE);
							return 0;
						}
						if(!jCheckBoxDirector.isSelected() && !jCheckBoxAgente.isSelected()){
							JOptionPane.showMessageDialog(this, "Decide si quieres un agente inmobiliario o un director", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else{
							if (jCheckBoxDirector.isSelected()) {// Director
								if (!jTextFieldPolitica.getText().isEmpty()) {
									String politicaEmpresarial = jTextFieldPolitica.getText();
									TEmpleado e = new TDirector(id, dni, nombre, domicilio, true, departamento,	politicaEmpresarial, sueldo);
									Controlador.getInstance().run(ListaComandos.MODIFICAREMPLEADO, e);
								} else {
									JOptionPane.showMessageDialog(this, "Rellene pol�tica empresarial", "Alta empleado", JOptionPane.ERROR_MESSAGE);
								}
							} else {// Agente Inmobiliario
								if (!jTextFieldAnosExperiencia.getText().isEmpty()) {
									int anosEperiencia = Integer.parseInt(jTextFieldAnosExperiencia.getText());
									
									if(anosEperiencia >= 0){
										TEmpleado e = new TAgenteInmobiliario(id, dni, nombre, domicilio, true, departamento, anosEperiencia, sueldo);
										Controlador.getInstance().run(ListaComandos.MODIFICAREMPLEADO, e);
									}
									else{
										JOptionPane.showMessageDialog(this, "Los a�os de experiencia del agente inmobiliario debe ser un n�mero positivo","Error", JOptionPane.ERROR_MESSAGE);
									}

								} else {
									JOptionPane.showMessageDialog(this, "Rellene a�os experiencia", "Alta empleado",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
	
				}
				
				
			}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El Id departamento, el id Empleado y los a�os de experiencia deben ser un n�mero positivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
					
			
		}
		
		else{
			JOptionPane.showMessageDialog(this, "Por favor, rellena el campo id", "Error", JOptionPane.ERROR_MESSAGE);

		}
		
		return 0;
	}

	// Comprobaciones hechas
	private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {
		int id;
		if (!jTextFieldId.getText().isEmpty()) {
			try {
				id = Integer.parseInt(jTextFieldId.getText());
				
				if(id <= 0){
					JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else{
					Controlador.getInstance().run(ListaComandos.CONSULTAREMPLEADO,id);
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Consulta empleado",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Introduzca un ID de empleado", "Consulta empleado",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {
		Controlador.getInstance().run(ListaComandos.LISTAREMPLEADO,null);
	}

	private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
		limpiarComponentes();
		Controlador.getInstance().run(ListaComandos.CERRARVISTAEMPLEADO, null);
	}

	protected void jCheckBoxDirectorActionPerformed(ActionEvent evt) {

		
		
		jTextFieldPolitica.setEditable(true);
		jTextFieldAnosExperiencia.setEditable(false);
		jTextFieldAnosExperiencia.setText("");

		if (jCheckBoxAgente.isSelected()) {
			jCheckBoxAgente.setSelected(false);
		}
	}

	protected void jCheckBoxAgenteActionPerformed(ActionEvent evt) {

		jTextFieldAnosExperiencia.setEditable(true);
		jTextFieldPolitica.setEditable(false);
		jTextFieldPolitica.setText("");

		if (jCheckBoxDirector.isSelected()) {
			jCheckBoxDirector.setSelected(false);
		}
	}                                           

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtoModificar;
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JCheckBox jCheckBoxAgente;
    private javax.swing.JCheckBox jCheckBoxDirector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAnosExperiencia;
    private javax.swing.JTextField jTextFieldDepartamentos;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldDomicilio;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPolitica;
    private javax.swing.JTextField jTextFieldSueldo;
    // End of variables declaration                   
}
