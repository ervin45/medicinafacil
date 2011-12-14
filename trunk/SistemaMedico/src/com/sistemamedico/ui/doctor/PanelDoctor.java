package com.sistemamedico.ui.doctor;

import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Rectangle;

import javax.swing.BorderFactory;

import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sistemamedico.manejadores.ManejadorDoctor;
import com.sistemamedico.modelo.ModeloDoctor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class PanelDoctor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelDoctor = null;
	private JScrollPane jspDoctores = null;
	private JTable tblDoctores = null;
	private ModeloDoctor modeloDoctor = null;
	private JButton btnAgregar = null;
	private JButton btnModificar = null;
	private JButton btnCambiarStatus = null;
	private JLabel lblBusqueda = null;
	private JComboBox cmbBusqueda = null;
	private ComboBoxModel modeloComboBox = null;
	private JTextField txtBusqueda = null;
	private JPanel panelBusqueda = null;
	private static int idDoctor = 0;

	/**
	 * This is the default constructor
	 */
	public PanelDoctor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		modeloComboBox = new DefaultComboBoxModel(new String[] { "Nombre",
				"Apellido", "Especialidad" });
		lblBusqueda = new JLabel();
		lblBusqueda.setText("Busqueda:");
		lblBusqueda.setBounds(new Rectangle(23, 17, 66, 25));
		modeloDoctor = ModeloDoctor.getInstancia();
		this.setSize(744, 420);
		this.setLayout(null);

		this.add(getPanelDoctor(), null);
		this.add(getBtnAgregar(), null);
		this.add(getBtnModificar(), null);
		this.add(getBtnCambiarStatus(), null);
		this.add(getPanelBusqueda(), null);
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
			panelDoctor.setBounds(new Rectangle(27, 91, 679, 268));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Lista  Doctores", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelDoctor.add(getJspDoctores(), null);
		}
		return panelDoctor;
	}

	/**
	 * This method initializes jspDoctores
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJspDoctores() {
		if (jspDoctores == null) {
			jspDoctores = new JScrollPane();
			jspDoctores.setBounds(new Rectangle(10, 31, 652, 221));
			jspDoctores.setViewportView(getTblDoctores());
		}
		return jspDoctores;
	}

	/**
	 * This method initializes tblDoctores
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getTblDoctores() {
		if (tblDoctores == null) {
			tblDoctores = new JTable();
			tblDoctores.setModel(modeloDoctor);
		}
		return tblDoctores;
	}

	/**
	 * This method initializes btnAgregar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			ImageIcon aceptar = new ImageIcon("img/agregar.png");
			btnAgregar = new JButton(aceptar);
			btnAgregar.setBounds(new Rectangle(183, 368, 107, 30));
			btnAgregar.setText("Agregar");
			btnAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FormularioDoctor formulario = new FormularioDoctor();
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
			ImageIcon edit = new ImageIcon("img/edit.png");
			btnModificar = new JButton(edit);
			btnModificar.setBounds(new Rectangle(298, 368, 107, 30));
			btnModificar.setText("Modificar");
			btnModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (tblDoctores.isRowSelected(tblDoctores.getSelectedRow()) == false) {

						JOptionPane.showMessageDialog(null,
								"Debe de seleccionar un Doctor para modificar",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String idDoctor = tblDoctores.getValueAt(
								tblDoctores.getSelectedRow(), 0).toString();

						setIdDoctor(Integer.valueOf(idDoctor));
						FormularioEditarDoctor formularioEditarDoctor = new FormularioEditarDoctor();
						formularioEditarDoctor.setAlwaysOnTop(true);
						formularioEditarDoctor.setVisible(true);
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
			ImageIcon change = new ImageIcon("img/change.png");
			btnCambiarStatus = new JButton(change);
			btnCambiarStatus.setBounds(new Rectangle(416, 368, 169, 30));
			btnCambiarStatus.setText("Cambiar Estatus");
			btnCambiarStatus
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {

							if (tblDoctores.isRowSelected(tblDoctores
									.getSelectedRow()) == false) {

								JOptionPane
										.showMessageDialog(
												null,
												"Debe de seleccionar un Doctor para cambiar el status",
												"Error",
												JOptionPane.ERROR_MESSAGE);
							} else {

								String idDoctor = tblDoctores.getValueAt(
										tblDoctores.getSelectedRow(), 0)
										.toString();

								int option = JOptionPane
										.showConfirmDialog(
												null,
												
												"Esta seguro que desea cambiarle el status a este Doctor ?",
												"Informacion",
												JOptionPane.YES_OPTION);
								if (option == JOptionPane.YES_OPTION) {

									ManejadorDoctor.getInstancia()
											.cambiarStatus(
													Integer.parseInt(idDoctor));
									
									ModeloDoctor.getInstancia().actualizarTabla();
								}

							}

						}
					});
		}
		return btnCambiarStatus;
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
			cmbBusqueda.setModel(modeloComboBox);
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
			txtBusqueda.setBorder((BorderFactory.createLineBorder(Color.black,
					1)));
			txtBusqueda.setBounds(new Rectangle(189, 17, 162, 25));
			txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {

					if (cmbBusqueda.getSelectedIndex() == 0) {

						TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(
								modeloDoctor);
						filtro.setRowFilter(RowFilter.regexFilter(txtBusqueda
								.getText(), 1));
						tblDoctores.setRowSorter(filtro);
					} else if (cmbBusqueda.getSelectedIndex() == 1) {
						TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(
								modeloDoctor);
						filtro.setRowFilter(RowFilter.regexFilter(txtBusqueda
								.getText(), 2));
						tblDoctores.setRowSorter(filtro);
					} else if (cmbBusqueda.getSelectedIndex() == 2) {
						TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(
								modeloDoctor);
						filtro.setRowFilter(RowFilter.regexFilter(txtBusqueda
								.getText(), 7));
						tblDoctores.setRowSorter(filtro);
					}

				}
			});

		}
		return txtBusqueda;
	}

	/**
	 * This method initializes panelBusqueda
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelBusqueda() {
		if (panelBusqueda == null) {
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

	public static int getIdDoctor() {
		return idDoctor;
	}

	public static void setIdDoctor(int idDoctor) {
		PanelDoctor.idDoctor = idDoctor;
	}

} // @jve:decl-index=0:visual-constraint="20,10"
