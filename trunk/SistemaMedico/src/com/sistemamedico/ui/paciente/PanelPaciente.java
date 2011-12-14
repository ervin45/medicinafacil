package com.sistemamedico.ui.paciente;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sistemamedico.manejadores.ManejadorDoctor;
import com.sistemamedico.manejadores.ManejadorPaciente;
import com.sistemamedico.modelo.ModeloDoctor;
import com.sistemamedico.modelo.ModeloPaciente;
import com.sistemamedico.ui.doctor.FormularioEditarDoctor;

import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

import java.lang.String;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelPaciente = null;
	private JScrollPane jspPacientes = null;
	private JTable tblPacientes = null;
	private JPanel panelBusqueda = null;
	private JLabel lblBusqueda = null;
	private JComboBox cmbBusqueda = null;
	private JTextField txtBusqueda = null;
	private JButton btnAgregar = null;
	private JButton btnModificar = null;
	private JButton btnCambiarStatus = null;
	private ModeloPaciente modeloPaciente = null;
	private static int idPaciente = 0;


	/**
	 * This is the default constructor
	 */
	public PanelPaciente() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		modeloPaciente = ModeloPaciente.getInstancia();
		this.setSize(744, 420);
		this.setLayout(null);
		this.add(getPanelPaciente(), null);
		this.add(getPanelBusqueda(), null);
		this.add(getBtnAgregar(), null);
		this.add(getBtnModificar(), null);
		this.add(getBtnCambiarStatus(), null);
	}

	/**
	 * This method initializes panelPaciente
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelPaciente() {
		if (panelPaciente == null) {
			panelPaciente = new JPanel();
			panelPaciente.setLayout(null);
			panelPaciente.setBounds(new Rectangle(27, 91, 679, 268));
			panelPaciente.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Lista  Pacientes", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelPaciente.add(getJspPacientes(), null);
		}
		return panelPaciente;
	}

	/**
	 * This method initializes jspPacientes
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJspPacientes() {
		if (jspPacientes == null) {
			jspPacientes = new JScrollPane();
			jspPacientes.setBounds(new Rectangle(10, 31, 652, 221));
			jspPacientes.setViewportView(getTblPacientes());
		}
		return jspPacientes;
	}

	/**
	 * This method initializes tblPacientes
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getTblPacientes() {
		if (tblPacientes == null) {
			tblPacientes = new JTable();
			tblPacientes.setModel(modeloPaciente);
		}
		return tblPacientes;
	}

	/**
	 * This method initializes panelBusqueda
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelBusqueda() {
		if (panelBusqueda == null) {
			lblBusqueda = new JLabel();
			lblBusqueda.setBounds(new Rectangle(23, 17, 66, 25));
			lblBusqueda.setText("Busqueda:");
			panelBusqueda = new JPanel();
			panelBusqueda.setLayout(null);
			panelBusqueda.setBounds(new Rectangle(181, 26, 361, 56));
			panelBusqueda.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1), "Busqueda",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelBusqueda.add(lblBusqueda, null);
			panelBusqueda.add(getCmbBusqueda(), null);
			panelBusqueda.add(getTxtBusqueda(), null);
		}
		return panelBusqueda;
	}

	/**
	 * This method initializes cmbBusqueda
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbBusqueda() {
		if (cmbBusqueda == null) {
			cmbBusqueda = new JComboBox();
			cmbBusqueda.setBounds(new Rectangle(97, 17, 86, 25));
			cmbBusqueda.setModel(new DefaultComboBoxModel(new String[] {
					"Nombre", "Apellido" }));
		}
		return cmbBusqueda;
	}

	/**
	 * This method initializes txtBusqueda
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtBusqueda() {
		if (txtBusqueda == null) {
			txtBusqueda = new JTextField();
			txtBusqueda.setBounds(new Rectangle(189, 17, 162, 25));
			txtBusqueda.setBorder((BorderFactory.createLineBorder(Color.black,
					1)));
			txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {

					if (cmbBusqueda.getSelectedIndex() == 0) {

						TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(
								modeloPaciente);
						filtro.setRowFilter(RowFilter.regexFilter(txtBusqueda
								.getText(), 1));
						tblPacientes.setRowSorter(filtro);
					} else if (cmbBusqueda.getSelectedIndex() == 1) {
						TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(
								modeloPaciente);
						filtro.setRowFilter(RowFilter.regexFilter(txtBusqueda
								.getText(), 2));
						tblPacientes.setRowSorter(filtro);
					}

				}
			});

		}
		return txtBusqueda;
	}

	/**
	 * This method initializes btnAgregar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton();
			btnAgregar.setBounds(new Rectangle(196, 368, 87, 30));
			btnAgregar.setText("Agregar");
			btnAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FormularioPaciente formulario = new FormularioPaciente();
					formulario.setAlwaysOnTop(true);
					formulario.setVisible(true);
				}
			});
		}
		return btnAgregar;
	}

	/**
	 * This method initializes btnModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton();
			btnModificar.setBounds(new Rectangle(298, 368, 87, 30));
			btnModificar.setText("Modificar");
			btnModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (tblPacientes.isRowSelected(tblPacientes
							.getSelectedRow()) == false) {

						JOptionPane
								.showMessageDialog(
										null,
										"Debe de seleccionar un Paciente para modificar",
										"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String idPaciente = tblPacientes.getValueAt(
								tblPacientes.getSelectedRow(), 0).toString();
						
						
						
						setIdPaciente(Integer.parseInt(idPaciente));
						
						
						FormularioEditarPaciente formularioEditarPaciente = new FormularioEditarPaciente();
						formularioEditarPaciente.setAlwaysOnTop(true);
						formularioEditarPaciente.setVisible(true);
					}
				}
			});
		}
		return btnModificar;
	}

	/**
	 * This method initializes btnCambiarStatus
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnCambiarStatus() {
		if (btnCambiarStatus == null) {
			btnCambiarStatus = new JButton();
			btnCambiarStatus.setBounds(new Rectangle(397, 368, 146, 30));
			btnCambiarStatus.setText("Cambiar Estatus");
			btnCambiarStatus.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (tblPacientes.isRowSelected(tblPacientes
							.getSelectedRow()) == false) {

						JOptionPane
								.showMessageDialog(
										null,
										"Debe de seleccionar un Paciente para cambiar el status",
										"Error",
										JOptionPane.ERROR_MESSAGE);
					} else {

						String idPaciente = tblPacientes.getValueAt(
								tblPacientes.getSelectedRow(), 0)
								.toString();

						int option = JOptionPane
								.showConfirmDialog(
										null,
										
										"Esta seguro que desea cambiarle el status a este Paciente ?",
										"Informacion",
										JOptionPane.YES_OPTION);
						if (option == JOptionPane.YES_OPTION) {

							ManejadorPaciente.getInstancia()
									.cambiarStatus(
											Integer.parseInt(idPaciente));
							
							ModeloPaciente.getInstancia().actualizarTabla();
						}

					}
				}
			});
		}
		return btnCambiarStatus;
	}

	public static int getIdPaciente() {
		return idPaciente;
	}

	public static void setIdPaciente(int idPaciente) {
		PanelPaciente.idPaciente = idPaciente;
	}


	
	

} // @jve:decl-index=0:visual-constraint="10,3"
