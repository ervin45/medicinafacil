package com.sistemamedico.ui.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FormularioVerDoctor extends JFrame {

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

	/**
	 * This is the default constructor
	 */
	public FormularioVerDoctor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(550, 585);
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
			jContentPane.add(getPanelDoctor(), null);
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
			lblConfirmar.setBounds(new Rectangle(30, 407, 98, 22));
			lblConfirmar.setText("Confirmar Clave:");
			lblClave = new JLabel();
			lblClave.setBounds(new Rectangle(30, 361, 82, 22));
			lblClave.setText("Clave:");
			lblUsuario = new JLabel();
			lblUsuario.setBounds(new Rectangle(30, 317, 82, 22));
			lblUsuario.setText("Usuario:");
			lblEspecialidad = new JLabel();
			lblEspecialidad.setBounds(new Rectangle(30, 271, 82, 22));
			lblEspecialidad.setText("Especialidad:");
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
			panelDoctor.setBounds(new Rectangle(0, 1, 524, 548));
			panelDoctor.setFont(new Font("Dialog", Font.PLAIN, 14));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Datos del Doctor", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
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
			panelDoctor.add(lblEspecialidad, null);
			panelDoctor.add(getCmbEspecialidad(), null);
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
	 * This method initializes cmbEspecialidad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbEspecialidad() {
		if (cmbEspecialidad == null) {
			cmbEspecialidad = new JComboBox();
			cmbEspecialidad.setBounds(new Rectangle(144, 271, 182, 25));
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
			txtUsuario.setBounds(new Rectangle(144, 317, 182, 25));
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
			txtClave.setBounds(new Rectangle(144, 361, 182, 25));
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
			txtConfirmarClave.setBounds(new Rectangle(144, 407, 182, 25));
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
			btnAceptar.setBounds(new Rectangle(117, 481, 91, 26));
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
			btnCancelar.setBounds(new Rectangle(239, 481, 91, 26));
			btnCancelar.setText("Cancelar");
		}
		return btnCancelar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,-2"
