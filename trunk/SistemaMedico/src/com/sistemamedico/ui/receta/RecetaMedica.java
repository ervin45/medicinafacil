package com.sistemamedico.ui.receta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.sistemamedico.entidades.Consulta;
import com.toedter.calendar.JCalendar;

public class RecetaMedica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel panelConsulta = null;
	private JLabel lblDoctor = null;
	private JTextField txtNombreDoctor = null;
	private JButton btnBuscarDoctor = null;
	private JLabel lblNombrePaciente = null;
	private JTextField txtNombrePaciente = null;
	private JButton btnBuscarPaciente = null;
	private JLabel lblFecha = null;
	private JTextField txtFecha = null;
	private JButton btnFecha = null;
	private Date fecha = null;
	private JLabel lblDescripcion = null;
	private JTextArea txtDescripcion = null;
	private JButton btnAceptar = null;
	private JButton btnCancelar = null;

	/**
	 * This is the default constructor
	 */
	public RecetaMedica() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(533, 489);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta");
		this.setLocationRelativeTo(null);
		fecha = new Date();
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
			jContentPane.add(getPanelConsulta(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelConsulta
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelConsulta() {
		if (panelConsulta == null) {
			lblDescripcion = new JLabel();
			lblDescripcion.setBounds(new Rectangle(15, 203, 120, 24));
			lblDescripcion.setText("Descripcion:");
			lblFecha = new JLabel();
			lblFecha.setBounds(new Rectangle(15, 150, 120, 24));
			lblFecha.setText("Fecha:");
			lblNombrePaciente = new JLabel();
			lblNombrePaciente.setBounds(new Rectangle(15, 93, 122, 26));
			lblNombrePaciente.setText("Nombre del Paciente:");
			lblDoctor = new JLabel();
			lblDoctor.setBounds(new Rectangle(15, 39, 122, 26));
			lblDoctor.setText("Nombre del Doctor:");
			panelConsulta = new JPanel();
			panelConsulta.setLayout(null);
			panelConsulta.setBounds(new Rectangle(4, 4, 513, 439));
			panelConsulta.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Datos de la Consulta", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			panelConsulta.add(lblDoctor, null);
			panelConsulta.add(getTxtNombreDoctor(), null);
			panelConsulta.add(getBtnBuscarDoctor(), null);
			panelConsulta.add(lblNombrePaciente, null);
			panelConsulta.add(getTxtNombrePaciente(), null);
			panelConsulta.add(getBtnBuscarPaciente(), null);
			panelConsulta.add(lblFecha, null);
			panelConsulta.add(getTxtFecha(), null);
			panelConsulta.add(getBtnFecha(), null);
			panelConsulta.add(lblDescripcion, null);
			panelConsulta.add(getTxtDescripcion(), null);
			panelConsulta.add(getBtnAceptar(), null);
			panelConsulta.add(getBtnCancelar(), null);
		}
		return panelConsulta;
	}

	/**
	 * This method initializes txtNombreDoctor
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNombreDoctor() {
		if (txtNombreDoctor == null) {
			txtNombreDoctor = new JTextField();
			txtNombreDoctor.setEnabled(false);
			txtNombreDoctor.setBounds(new Rectangle(156, 39, 234, 26));
		}
		return txtNombreDoctor;
	}

	/**
	 * This method initializes btnBuscarDoctor
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBuscarDoctor() {
		if (btnBuscarDoctor == null) {
			btnBuscarDoctor = new JButton();
			btnBuscarDoctor.setBounds(new Rectangle(405, 39, 80, 26));
			btnBuscarDoctor.setText("Buscar");
		}
		return btnBuscarDoctor;
	}

	/**
	 * This method initializes txtNombrePaciente
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNombrePaciente() {
		if (txtNombrePaciente == null) {
			txtNombrePaciente = new JTextField();
			txtNombrePaciente.setEnabled(false);
			txtNombrePaciente.setBounds(new Rectangle(156, 93, 234, 26));
		}
		return txtNombrePaciente;
	}

	/**
	 * This method initializes btnBuscarPaciente
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBuscarPaciente() {
		if (btnBuscarPaciente == null) {
			btnBuscarPaciente = new JButton();
			btnBuscarPaciente.setBounds(new Rectangle(405, 95, 80, 26));
			btnBuscarPaciente.setText("Buscar");
		}
		return btnBuscarPaciente;
	}

	/**
	 * This method initializes txtFecha
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtFecha() {
		if (txtFecha == null) {
			txtFecha = new JTextField();
			txtFecha.setEnabled(false);
			txtFecha.setBounds(new Rectangle(156, 150, 175, 26));
		}
		return txtFecha;
	}

	/**
	 * This method initializes btnFecha
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnFecha() {
		if (btnFecha == null) {
			btnFecha = new JButton();
			btnFecha.setBounds(new Rectangle(397, 150, 105, 23));
			btnFecha.setText("Seleccionar");
			btnFecha.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("llegue");
					fecha = seleccionarFecha();
					txtFecha.setText((fecha.getYear() + 1900) + "-"
							+ (fecha.getMonth() + 1) + "-" + fecha.getDate());
				}
			});
		}
		return btnFecha;
	}

	private Date seleccionarFecha() {
		JCalendar calendar = new JCalendar();
		JDialog dialogo = new JDialog();
		dialogo.setTitle("Elija Fecha de la consulta");
		dialogo.setModal(true);
		dialogo.setContentPane(calendar);
		dialogo.setSize(300, 300);
		dialogo.setVisible(true);
		return (Date) calendar.getDate();

	}

	/**
	 * This method initializes txtDescripcion
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtDescripcion() {
		if (txtDescripcion == null) {
			txtDescripcion = new JTextArea();
			txtDescripcion.setBorder(BorderFactory.createLineBorder(
					Color.black, 1));
			txtDescripcion.setBounds(new Rectangle(156, 203, 310, 155));
		}
		return txtDescripcion;
	}

	/**
	 * This method initializes btnAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setBounds(new Rectangle(132, 392, 115, 28));
			btnAceptar.setText("Aceptar");
			btnAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (validarCampos()) {
						
						Consulta consulta = new Consulta();
						//consulta.setIdConsulta(idConsulta)
					
					}
				}
			});
		}
		return btnAceptar;
	}

	public boolean validarCampos() {
		boolean validado = true;

		if (txtNombreDoctor.getText().equals("")
				|| txtNombrePaciente.getText().equals("")
				|| txtFecha.getText().equals("")
				|| txtDescripcion.getText().equals("")) {
			validado = false;
			JOptionPane.showMessageDialog(null, "Faltan Campos por llenar");
		}

		return validado;
	}

	/**
	 * This method initializes btnCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBounds(new Rectangle(268, 392, 115, 28));
			btnCancelar.setText("Cancelar");
		}
		return btnCancelar;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
