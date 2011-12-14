package com.sistemamedico.ui.paciente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.sistemamedico.entidades.Paciente;
import com.sistemamedico.entidades.RecordPaciente;
import com.sistemamedico.manejadores.ManejadorRecordPaciente;
import com.sistemamedico.modelo.ModeloPaciente;
import com.sistemamedico.ui.doctor.FormularioDoctor;

import java.awt.Dimension;

public class FormularioPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel panelDoctor = null;
	private JButton btnAceptar = null;
	private JButton btnCancelar = null;
	private JTabbedPane tabPaciente = null;
	private JPanel panelRecord = null;
	private JLabel lblTipoSangre = null;
	private JComboBox cmbTipoSangre = null;
	private JLabel lblAlergias = null;
	private JTextArea txtAlergias = null;
	private JLabel lblCirujias = null;
	private JTextArea txtCirujias = null;
	private JLabel lblNombreContacto = null;
	private JTextField txtNombreContacto = null;
	private JLabel lblTelefonoContacto = null;
	private JTextField txtTelefonoContacto = null;
	private JButton btnLimpiarCampos = null;
	private JPanel panelDatosGenerales = null;
	private JLabel lblDireccion = null;
	private JFormattedTextField txtCedula = null;
	private JLabel jLabel = null;
	private JLabel lblApellido = null;
	private JLabel lblNombreDoctor = null;
	private JTextField txtNombreDoctor = null;
	private JTextField txtApellido = null;
	private JLabel lblCelular = null;
	private JFormattedTextField txtCelular = null;
	private JFormattedTextField txtTelefono = null;
	private JLabel lblTelefono = null;

	private JTextArea txtDireccion = null;

	/**
	 * This is the default constructor
	 */
	public FormularioPaciente() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(523, 579);
		this.setContentPane(getJContentPane());
		this.setTitle("Formulario Paciente");
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
			jContentPane.add(getTabPaciente(), null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(getBtnAceptar(), null);
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
			panelDoctor = new JPanel();
			panelDoctor.setLayout(null);
			panelDoctor.setFont(new Font("Dialog", Font.PLAIN, 14));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Formulario Paciente", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			panelDoctor.add(getPanelDatosGenerales(), null);
		}
		return panelDoctor;
	}

	/**
	 * This method initializes btnAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(new Rectangle(132, 508, 91, 29));
			btnAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (validarTexto()) {
						RecordPaciente recordPaciente = new RecordPaciente();

						recordPaciente.setTipoSange(cmbTipoSangre
								.getSelectedItem().toString());
						recordPaciente.setAlergia(txtAlergias.getText());
						recordPaciente.setNombreReferido(txtNombreContacto
								.getText());
						recordPaciente.setTelefonoReferido(txtTelefonoContacto
								.getText());
						recordPaciente.setCirugia(txtCirujias.getText());

						ManejadorRecordPaciente.getInstancia().agregar(
								recordPaciente);
						int idRecord = ManejadorRecordPaciente.getInstancia()
								.getUltimoRecordPaciente();
						Paciente paciente = new Paciente();
						paciente.setNombre(txtNombreDoctor.getText());
						paciente.setApellido(txtApellido.getText());
						paciente.setTelefono(txtTelefono.getText());
						paciente.setCelular(txtCelular.getText());
						paciente.setCedula(txtCedula.getText());
						paciente.setDireccion(txtDireccion.getText());
						paciente.setStatus("Activo");
						paciente.setRole("paciente");
						paciente.setIdRecord(idRecord);

						ModeloPaciente.getInstancia().agregar(paciente);

						JOptionPane.showMessageDialog(null,

						"Se ha Creado un nuevo record Paciente exitosamente",
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
			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(new Rectangle(237, 508, 91, 29));
			btnCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int opcion = JOptionPane
							.showConfirmDialog(
									null,
									"La Ventana actual se cerrara ,Esta Seguro que desea cancelar ? ",
									"Informacion", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						FormularioPaciente.this.dispose();

					}
				}
			});
		}
		return btnCancelar;
	}

	/**
	 * This method initializes tabPaciente
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getTabPaciente() {
		if (tabPaciente == null) {
			tabPaciente = new JTabbedPane();
			tabPaciente.setBounds(new Rectangle(1, 3, 515, 493));
			tabPaciente.addTab("Datos Paciente", null, getPanelDoctor(), null);
			tabPaciente.addTab("Historia Medica", null, getPanelRecord(), null);
		}
		return tabPaciente;
	}

	/**
	 * This method initializes panelRecord
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelRecord() {
		if (panelRecord == null) {
			lblTelefonoContacto = new JLabel();
			lblTelefonoContacto.setBounds(new Rectangle(29, 407, 129, 23));
			lblTelefonoContacto.setText("Telefono de Contacto:");
			lblNombreContacto = new JLabel();
			lblNombreContacto.setBounds(new Rectangle(29, 361, 129, 23));
			lblNombreContacto.setText("Nombre de Contacto:");
			lblCirujias = new JLabel();
			lblCirujias.setBounds(new Rectangle(29, 226, 94, 22));
			lblCirujias.setText("Cirujias:");
			lblAlergias = new JLabel();
			lblAlergias.setBounds(new Rectangle(29, 90, 94, 22));
			lblAlergias.setText("Alergias:");
			lblTipoSangre = new JLabel();
			lblTipoSangre.setBounds(new Rectangle(29, 44, 94, 22));
			lblTipoSangre.setText("Tipo de Sangre:");
			panelRecord = new JPanel();
			panelRecord.setLayout(null);
			panelRecord.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Record Medico", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			panelRecord.setFont(new Font("Dialog", Font.PLAIN, 14));
			panelRecord.add(lblTipoSangre, null);
			panelRecord.add(getCmbTipoSangre(), null);
			panelRecord.add(lblAlergias, null);
			panelRecord.add(getTxtAlergias(), null);
			panelRecord.add(lblCirujias, null);
			panelRecord.add(getTxtCirujias(), null);
			panelRecord.add(lblNombreContacto, null);
			panelRecord.add(getTxtNombreContacto(), null);
			panelRecord.add(lblTelefonoContacto, null);
			panelRecord.add(getTxtTelefonoContacto(), null);
		}
		return panelRecord;
	}

	/**
	 * This method initializes cmbTipoSangre
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbTipoSangre() {
		if (cmbTipoSangre == null) {
			String[] opciones = { "Seleccionar", "A", "A+", "A-", "B", "B+",
					"B-", "O+", "O-" };
			cmbTipoSangre = new JComboBox(opciones);
			cmbTipoSangre.setBounds(new Rectangle(183, 44, 182, 25));
		}
		return cmbTipoSangre;
	}

	/**
	 * This method initializes txtAlergias
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtAlergias() {
		if (txtAlergias == null) {
			txtAlergias = new JTextArea();
			txtAlergias.setBorder(BorderFactory
					.createTitledBorder(BorderFactory.createLineBorder(
							Color.black, 1)));
			txtAlergias.setBounds(new Rectangle(183, 90, 278, 111));
		}
		return txtAlergias;
	}

	/**
	 * This method initializes txtCirujias
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtCirujias() {
		if (txtCirujias == null) {
			txtCirujias = new JTextArea();
			txtCirujias.setBorder(BorderFactory
					.createTitledBorder(BorderFactory.createLineBorder(
							Color.black, 1)));
			txtCirujias.setBounds(new Rectangle(183, 226, 278, 111));
		}
		return txtCirujias;
	}

	/**
	 * This method initializes txtNombreContacto
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNombreContacto() {
		if (txtNombreContacto == null) {
			txtNombreContacto = new JTextField();
			txtNombreContacto.setBounds(new Rectangle(183, 361, 278, 26));
		}
		return txtNombreContacto;
	}

	/**
	 * This method initializes txtTelefonoContacto
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtTelefonoContacto() {
		if (txtTelefonoContacto == null) {
			try {
				txtTelefonoContacto = new JFormattedTextField(
						new MaskFormatter("###-###-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtTelefonoContacto.setBounds(new Rectangle(183, 407, 188, 26));
		}
		return txtTelefonoContacto;
	}

	@SuppressWarnings("deprecation")
	public boolean validarTexto() {
		boolean validado = true;
		if (txtNombreDoctor.getText().trim().equals("")
				|| txtApellido.getText().trim().equals("")
				|| txtTelefono.getText().trim().equals("")
				|| txtCelular.getText().trim().equals("")
				|| txtCedula.getText().equals("")
				|| txtAlergias.getText().trim().equals("")
				|| txtCirujias.getText().equals("")
				|| txtDireccion.getText().equals("")
				|| txtNombreContacto.getText().equals("")
				|| txtTelefonoContacto.getText().equals("")
				|| cmbTipoSangre.getSelectedItem().equals("Seleccionar")) {
			validado = false;

		}
		return validado;
	}

	/**
	 * This method initializes btnLimpiarCampos
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnLimpiarCampos() {
		if (btnLimpiarCampos == null) {
			btnLimpiarCampos = new JButton();
			btnLimpiarCampos.setBounds(new Rectangle(379, 508, 117, 26));
			btnLimpiarCampos.setText("Limpiar");
		}
		return btnLimpiarCampos;
	}

	/**
	 * This method initializes panelDatosGenerales
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelDatosGenerales() {
		if (panelDatosGenerales == null) {
			lblTelefono = new JLabel();
			lblTelefono.setBounds(new Rectangle(257, 34, 63, 25));
			lblTelefono.setText("Telefono:");
			lblCelular = new JLabel();
			lblCelular.setBounds(new Rectangle(257, 68, 63, 25));
			lblCelular.setText("Celular:");
			lblNombreDoctor = new JLabel();
			lblNombreDoctor.setBounds(new Rectangle(16, 34, 63, 25));
			lblNombreDoctor.setText("Nombre:");
			lblApellido = new JLabel();
			lblApellido.setBounds(new Rectangle(16, 68, 63, 25));
			lblApellido.setText("Apellido:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(16, 104, 63, 25));
			jLabel.setText("Cedula:");
			lblDireccion = new JLabel();
			lblDireccion.setBounds(new Rectangle(16, 150, 63, 25));
			lblDireccion.setText("Direccion:");
			panelDatosGenerales = new JPanel();
			panelDatosGenerales.setLayout(null);
			panelDatosGenerales.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Datos Generales", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelDatosGenerales.setBounds(new Rectangle(13, 26, 484, 309));
			panelDatosGenerales.add(lblDireccion, null);
			panelDatosGenerales.add(getTxtCedula(), null);
			panelDatosGenerales.add(jLabel, null);
			panelDatosGenerales.add(lblApellido, null);
			panelDatosGenerales.add(lblNombreDoctor, null);
			panelDatosGenerales.add(getTxtNombreDoctor(), null);
			panelDatosGenerales.add(getTxtApellido(), null);
			panelDatosGenerales.add(lblCelular, null);
			panelDatosGenerales.add(getTxtCelular(), null);
			panelDatosGenerales.add(getTxtTelefono(), null);
			panelDatosGenerales.add(lblTelefono, null);
			panelDatosGenerales.add(getTxtDireccion(), null);
		}
		return panelDatosGenerales;
	}

	/**
	 * This method initializes txtCedula
	 * 
	 * @return javax.swing.JFormattedTextField
	 */
	private JFormattedTextField getTxtCedula() {
		if (txtCedula == null) {
			try {
				txtCedula = new JFormattedTextField(new MaskFormatter(
						"###-#######-#"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtCedula.setBounds(new Rectangle(89, 104, 145, 25));
			txtCedula.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
		return txtCedula;
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
			txtApellido.setBounds(new Rectangle(89, 68, 145, 25));
			txtApellido.setBorder(BorderFactory
					.createLineBorder(Color.black, 1));
		}
		return txtApellido;
	}

	/**
	 * This method initializes txtCelular
	 * 
	 * @return javax.swing.JFormattedTextField
	 */
	private JFormattedTextField getTxtCelular() {
		if (txtCelular == null) {
			try {
				txtCelular = new JFormattedTextField(new MaskFormatter(
						"###-###-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtCelular.setBounds(new Rectangle(324, 68, 145, 25));
			txtCelular
					.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
		return txtCelular;
	}

	/**
	 * This method initializes txtTelefono
	 * 
	 * @return javax.swing.JFormattedTextField
	 */
	private JFormattedTextField getTxtTelefono() {
		if (txtTelefono == null) {
			try {
				txtTelefono = new JFormattedTextField(new MaskFormatter(
						"###-###-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtTelefono.setBounds(new Rectangle(324, 34, 145, 25));
			txtTelefono.setBorder(BorderFactory
					.createLineBorder(Color.black, 1));
		}
		return txtTelefono;
	}

	/**
	 * This method initializes cmbEspecialidad
	 * 
	 * @return javax.swing.JComboBox
	 */

	/**
	 * This method initializes txtDireccion
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextArea();
			txtDireccion.setBounds(new Rectangle(89, 150, 379, 131));
			txtDireccion.setLineWrap(true);
			txtDireccion.setWrapStyleWord(true);
			txtDireccion.setBorder(BorderFactory.createLineBorder(Color.black,
					1));
		}
		return txtDireccion;
	}

	/**
	 * This method initializes tabForm
	 * 
	 * @return javax.swing.JTabbedPane
	 */

	/**
	 * This method initializes tabRecord
	 * 
	 * @return javax.swing.JTabbedPane
	 */

	/**
	 * This method initializes panelRecord
	 * 
	 * @return javax.swing.JPanel
	 */

} // @jve:decl-index=0:visual-constraint="10,-2"
