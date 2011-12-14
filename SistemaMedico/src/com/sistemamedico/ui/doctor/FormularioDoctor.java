package com.sistemamedico.ui.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.sistemamedico.entidades.Doctor;
import com.sistemamedico.modelo.ModeloDoctor;

public class FormularioDoctor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel panelDoctor = null;
	private JLabel lblNombreDoctor = null;
	private JTextField txtNombreDoctor = null;
	private JLabel lblApellido = null;
	private JTextField txtApellido = null;
	private JLabel lblTelefono = null;
	private JTextField txtTelefono = null;
	private JLabel lblCelular = null;
	private JTextField txtCelular = null;
	private JLabel jLabel = null;
	private JTextField txtCedula = null;
	private JLabel lblEspecialidad = null;
	private JComboBox cmbEspecialidad = null;
	private JLabel lblUsuario = null;
	private JTextField txtUsuario = null;
	private JLabel lblClave = null;
	private JLabel lblConfirmar = null;
	private JPasswordField txtClave = null;
	private JPasswordField txtConfirmarClave = null;
	private JButton btnAceptar = null;
	private JButton btnCancelar = null;
	private JPanel panelDatosGenerales = null;
	private JPanel panelSeguridad = null;
	private JLabel lblDireccion = null;
	private JTextArea txtDireccion = null;
	private JButton btnLimpiarCampos = null;

	/**
	 * This is the default constructor
	 */
	public FormularioDoctor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(543, 637);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Formulario Doctor");
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPanelDoctor(), null);
			jContentPane.add(getBtnAceptar(), null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(getBtnLimpiarCampos(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelDoctor
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelDoctor() {
		if (panelDoctor == null) {
			lblConfirmar = new JLabel();
			lblConfirmar.setText("Confirmar Clave:");
			lblConfirmar.setBounds(new Rectangle(19, 102, 98, 27));
			lblClave = new JLabel();
			lblClave.setText("Clave:");
			lblClave.setBounds(new Rectangle(19, 66, 53, 27));
			lblUsuario = new JLabel();
			lblUsuario.setText("Usuario:");
			lblUsuario.setBounds(new Rectangle(19, 31, 62, 27));
			lblEspecialidad = new JLabel();
			lblEspecialidad.setText("Especialidad:");
			lblEspecialidad.setBounds(new Rectangle(245, 104, 82, 22));
			jLabel = new JLabel();
			jLabel.setText("Cedula:");
			jLabel.setBounds(new Rectangle(16, 104, 63, 25));
			lblCelular = new JLabel();
			lblCelular.setText("Celular:");
			lblCelular.setBounds(new Rectangle(257, 68, 63, 25));
			lblTelefono = new JLabel();
			lblTelefono.setText("Telefono:");
			lblTelefono.setBounds(new Rectangle(257, 34, 63, 25));
			lblApellido = new JLabel();
			lblApellido.setText("Apellido:");
			lblApellido.setBounds(new Rectangle(16, 68, 63, 25));
			lblNombreDoctor = new JLabel();
			lblNombreDoctor.setText("Nombre:");
			lblNombreDoctor.setBounds(new Rectangle(16, 34, 63, 25));
			panelDoctor = new JPanel();
			panelDoctor.setLayout(null);
			panelDoctor.setBounds(new Rectangle(7, 10, 514, 540));
			panelDoctor.setFont(new Font("Dialog", Font.PLAIN, 14));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Formulario Doctor", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			panelDoctor.add(getCmbEspecialidad(), null);
			panelDoctor.add(getPanelDatosGenerales(), null);
			panelDoctor.add(getPanelSeguridad(), null);
		}
		return panelDoctor;
	}

	/**
	 * This method initializes txtNombreDoctor
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNombreDoctor() {
		if (txtNombreDoctor == null) {
			txtNombreDoctor = new JTextField();
			txtNombreDoctor.setBounds(new Rectangle(89, 34, 145, 25));
			txtNombreDoctor.setBorder(BorderFactory.createLineBorder(
					Color.black, 1));
		}
		return txtNombreDoctor;
	}

	/**
	 * This method initializes txtApellido
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtApellido() {
		if (txtApellido == null) {
			txtApellido = new JTextField();
			txtApellido.setBorder(BorderFactory
					.createLineBorder(Color.black, 1));
			txtApellido.setBounds(new Rectangle(89, 68, 145, 25));

		}
		return txtApellido;
	}

	/**
	 * This method initializes txtTelefono
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtTelefono() {
		if (txtTelefono == null) {
			try {
				txtTelefono = new JFormattedTextField(new MaskFormatter(
						"###-###-####"));
				txtTelefono.setBounds(new Rectangle(324, 34, 145, 25));
				txtTelefono.setBorder(BorderFactory.createLineBorder(
						Color.black, 1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return txtTelefono;
	}

	/**
	 * This method initializes txtCelular
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtCelular() {
		if (txtCelular == null) {
			try {
				txtCelular = new JFormattedTextField(new MaskFormatter(
						"###-###-####"));
				txtCelular.setBounds(new Rectangle(324, 68, 145, 25));
				txtCelular.setBorder(BorderFactory.createLineBorder(
						Color.black, 1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return txtCelular;
	}

	/**
	 * This method initializes txtCedula
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtCedula() {
		if (txtCedula == null) {
			try {
				txtCedula = new JFormattedTextField(new MaskFormatter(
						"###-#######-#"));
				txtCedula.setBounds(new Rectangle(89, 104, 145, 25));
				txtCedula.setBorder(BorderFactory.createLineBorder(Color.black,
						1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return txtCedula;
	}

	/**
	 * This method initializes cmbEspecialidad
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbEspecialidad() {
		if (cmbEspecialidad == null) {
			String[] opciones = { "Seleccionar", "Medico General", "Pediatra",
					"Gastroenterologo", "Oftalmologo" };
			cmbEspecialidad = new JComboBox(opciones);
			cmbEspecialidad.setBounds(new Rectangle(323, 105, 145, 22));
		}
		return cmbEspecialidad;
	}

	/**
	 * This method initializes txtUsuario
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtUsuario() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setBounds(new Rectangle(122, 31, 148, 27));
			txtUsuario
					.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
		return txtUsuario;
	}

	/**
	 * This method initializes txtClave
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getTxtClave() {
		if (txtClave == null) {
			txtClave = new JPasswordField();
			txtClave.setBounds(new Rectangle(122, 66, 148, 27));
			txtClave.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
		return txtClave;
	}

	/**
	 * This method initializes txtConfirmarClave
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getTxtConfirmarClave() {
		if (txtConfirmarClave == null) {
			txtConfirmarClave = new JPasswordField();
			txtConfirmarClave.setBounds(new Rectangle(122, 102, 148, 27));
			txtConfirmarClave.setBorder(BorderFactory.createLineBorder(
					Color.black, 1));
		}
		return txtConfirmarClave;
	}

	/**
	 * This method initializes btnAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			ImageIcon agregar = new ImageIcon("img/accept.png");
			btnAceptar = new JButton(agregar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(new Rectangle(137, 560, 85, 28));
			btnAceptar.addActionListener(new java.awt.event.ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (validarTexto() && validarClave()) {
						Doctor doctor = new Doctor();

						doctor.setNombre(txtNombreDoctor.getText());
						doctor.setApellido(txtApellido.getText());
						doctor.setTelefono(txtTelefono.getText());
						doctor.setCelular(txtCelular.getText());
						doctor.setCedula(txtCedula.getText());
						doctor.setDireccion(txtDireccion.getText());
						doctor.setEspecialidad(cmbEspecialidad
								.getSelectedItem().toString());
						doctor.setStatus("Activo");
						doctor.setRole("Doctor");
						doctor.setUsuario(txtUsuario.getText());
						doctor.setClave(txtClave.getText());

						ModeloDoctor.getInstancia().agregar(doctor);
						limpiarCampos();
						JOptionPane.showMessageDialog(null,

						"Se ha Creado un nuevo record Doctor exitosamente",
								"Informacion", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null,
								"Faltan Campos por llenar");
					}
				}
			});
		}
		return btnAceptar;
	}

	/**
	 * This method initializes btnCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			ImageIcon cancelar = new ImageIcon("img/cancelar.png");
			btnCancelar = new JButton(cancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(new Rectangle(235, 560, 93, 28));
			btnCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					int opcion = JOptionPane
							.showConfirmDialog(
									null,
									"La Ventana actual se cerrara ,Esta Seguro que desea cancelar ? ",
									"Informacion", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						FormularioDoctor.this.dispose();

					}

				}
			});
		}
		return btnCancelar;
	}

	@SuppressWarnings("deprecation")
	public boolean validarTexto() {
		boolean validado = true;
		if (txtNombreDoctor.getText().trim().equals("")
				|| txtApellido.getText().trim().equals("")
				|| txtTelefono.getText().trim().equals("")
				|| txtCelular.getText().trim().equals("")
				|| txtCedula.getText().equals("")
				|| txtUsuario.getText().trim().equals("")
				|| txtClave.getText().trim().equals("")
				|| txtConfirmarClave.getText().trim().equals("")
				|| txtDireccion.getText().trim().equals("")
				|| cmbEspecialidad.getSelectedItem().equals("Seleccionar")) {
			validado = false;

		}
		return validado;
	}
	
	public void limpiarCampos(){
		txtNombreDoctor.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtCedula.setText("");
		cmbEspecialidad.setSelectedIndex(0);
		txtDireccion.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtConfirmarClave.setText("");
	}

	@SuppressWarnings("deprecation")
	public boolean validarClave() {
		boolean validado = true;

		if (!txtClave.getText().trim().equals(
				txtConfirmarClave.getText().trim())) {
			validado = false;
			JOptionPane.showMessageDialog(null, "Confirme su clave");
		}
		return validado;
	}

	/**
	 * This method initializes panelDatosGenerales
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelDatosGenerales() {
		if (panelDatosGenerales == null) {
			lblDireccion = new JLabel();
			lblDireccion.setBounds(new Rectangle(16, 150, 63, 25));
			lblDireccion.setText("Direccion:");
			panelDatosGenerales = new JPanel();
			panelDatosGenerales.setLayout(null);
			panelDatosGenerales.setBounds(new Rectangle(13, 26, 484, 319));
			panelDatosGenerales.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Datos Generales", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelDatosGenerales.add(lblDireccion, null);
			panelDatosGenerales.add(getTxtCedula(), null);
			panelDatosGenerales.add(jLabel, null);
			panelDatosGenerales.add(lblApellido, null);
			panelDatosGenerales.add(lblNombreDoctor, null);
			panelDatosGenerales.add(getTxtNombreDoctor(), null);
			panelDatosGenerales.add(getTxtApellido(), null);
			panelDatosGenerales.add(lblCelular, null);
			panelDatosGenerales.add(lblEspecialidad, null);
			panelDatosGenerales.add(getTxtCelular(), null);
			panelDatosGenerales.add(getTxtTelefono(), null);
			panelDatosGenerales.add(lblTelefono, null);
			panelDatosGenerales.add(getCmbEspecialidad(), null);
			panelDatosGenerales.add(getTxtDireccion(), null);
		}
		return panelDatosGenerales;
	}

	/**
	 * This method initializes panelSeguridad
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelSeguridad() {
		if (panelSeguridad == null) {
			panelSeguridad = new JPanel();
			panelSeguridad.setLayout(null);
			panelSeguridad.setBounds(new Rectangle(13, 352, 484, 167));
			panelSeguridad.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Seguridad", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelSeguridad.add(lblUsuario, null);
			panelSeguridad.add(getTxtUsuario(), null);
			panelSeguridad.add(getTxtClave(), null);
			panelSeguridad.add(lblClave, null);
			panelSeguridad.add(lblConfirmar, null);
			panelSeguridad.add(getTxtConfirmarClave(), null);
		}
		return panelSeguridad;
	}

	/**
	 * This method initializes txtDireccion
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextArea();
			txtDireccion.setBounds(new Rectangle(89, 150, 379, 131));

			txtDireccion.setBorder(BorderFactory.createLineBorder(Color.black,
					1));
			txtDireccion.setWrapStyleWord(true);
			txtDireccion.setLineWrap(true);
		}
		return txtDireccion;
	}

	/**
	 * This method initializes btnLimpiarCampos
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnLimpiarCampos() {
		if (btnLimpiarCampos == null) {
			ImageIcon limpiar = new ImageIcon("img/clean.png");
			btnLimpiarCampos = new JButton(limpiar);
			btnLimpiarCampos.setBounds(new Rectangle(391, 560, 130, 28));
			btnLimpiarCampos.setText("Limpiar Campos");
			btnLimpiarCampos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							limpiarCampos();
						}
					});
		}
		return btnLimpiarCampos;
	}

} // @jve:decl-index=0:visual-constraint="10,-2"
