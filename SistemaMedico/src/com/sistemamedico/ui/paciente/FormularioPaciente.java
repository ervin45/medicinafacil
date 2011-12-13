package com.sistemamedico.ui.paciente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class FormularioPaciente extends JFrame {

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
	private JLabel lblUsuario = null;
	private JTextField txtUsuario = null;
	private JLabel lblClave = null;
	private JLabel lblConfirmar = null;
	private JPasswordField txtClave = null;
	private JPasswordField txtConfirmarClave = null;
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
		this.setSize(544, 555);
		this.setContentPane(getJContentPane());
		this.setTitle("Formulario Doctor");
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
			lblConfirmar.setBounds(new Rectangle(29, 362, 98, 22));
			lblConfirmar.setText("Confirmar Clave:");
			lblClave = new JLabel();
			lblClave.setBounds(new Rectangle(29, 316, 82, 22));
			lblClave.setText("Clave:");
			lblUsuario = new JLabel();
			lblUsuario.setBounds(new Rectangle(29, 272, 82, 22));
			lblUsuario.setText("Usuario:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(29, 226, 63, 22));
			jLabel.setText("Cedula:");
			lblCelular = new JLabel();
			lblCelular.setBounds(new Rectangle(29, 181, 63, 22));
			lblCelular.setText("Celular:");
			lblTelefono = new JLabel();
			lblTelefono.setBounds(new Rectangle(29, 135, 63, 22));
			lblTelefono.setText("Telefono:");
			lblApellido = new JLabel();
			lblApellido.setBounds(new Rectangle(29, 91, 63, 22));
			lblApellido.setText("Apellido:");
			lblNombreDoctor = new JLabel();
			lblNombreDoctor.setBounds(new Rectangle(29, 44, 63, 22));
			lblNombreDoctor.setText("Nombre:");
			panelDoctor = new JPanel();
			panelDoctor.setLayout(null);
			panelDoctor.setFont(new Font("Dialog", Font.PLAIN, 14));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Agregar Paciente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			panelDoctor.add(lblNombreDoctor, null);
			panelDoctor.add(getTxtNombreDoctor(), null);
			panelDoctor.add(lblApellido, null);
			panelDoctor.add(getTxtApellido(), null);
			panelDoctor.add(lblTelefono, null);
			panelDoctor.add(getTxtTelefono(), null);
			panelDoctor.add(lblCelular, null);
			panelDoctor.add(getTxtCelular(), null);
			panelDoctor.add(jLabel, null);
			panelDoctor.add(getTxtCedula(), null);
			panelDoctor.add(lblUsuario, null);
			panelDoctor.add(getTxtUsuario(), null);
			panelDoctor.add(lblClave, null);
			panelDoctor.add(lblConfirmar, null);
			panelDoctor.add(getTxtClave(), null);
			panelDoctor.add(getTxtConfirmarClave(), null);
			panelDoctor.add(getBtnAceptar(), null);
			panelDoctor.add(getBtnCancelar(), null);
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
			txtNombreDoctor.setBounds(new Rectangle(144, 44, 273, 25));
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
			txtApellido.setBounds(new Rectangle(144, 91, 273, 25));
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
			txtTelefono = new JTextField();
			txtTelefono.setBounds(new Rectangle(144, 135, 182, 25));
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
			txtCelular = new JTextField();
			txtCelular.setBounds(new Rectangle(144, 181, 182, 25));
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
			txtCedula = new JTextField();
			txtCedula.setBounds(new Rectangle(144, 226, 182, 25));
		}
		return txtCedula;
	}

	/**
	 * This method initializes txtUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUsuario() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setBounds(new Rectangle(144, 272, 182, 25));
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
			txtClave.setBounds(new Rectangle(144, 316, 182, 25));
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
			txtConfirmarClave.setBounds(new Rectangle(144, 362, 182, 25));
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
			btnAceptar = new JButton();
			btnAceptar.setBounds(new Rectangle(115, 433, 91, 26));
			btnAceptar.setText("Aceptar");
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
			btnCancelar.setBounds(new Rectangle(237, 433, 91, 26));
			btnCancelar.setText("Cancelar");
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
			tabPaciente.setBounds(new Rectangle(1, 3, 526, 511));
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
			panelRecord.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Record Medico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
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
			cmbTipoSangre = new JComboBox();
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
			txtAlergias.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
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
			txtCirujias.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
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
			txtNombreContacto.setBounds(new Rectangle(185, 361, 278, 26));
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
			txtTelefonoContacto = new JTextField();
			txtTelefonoContacto.setBounds(new Rectangle(185, 412, 188, 26));
		}
		return txtTelefonoContacto;
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
	
}  //  @jve:decl-index=0:visual-constraint="10,-2"
