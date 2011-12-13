package com.sistemamedico.ui.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sistemamedico.modelo.ModeloDoctor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
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
	private JButton btnBuscar = null;
	private JLabel lblBusqueda = null;
	private JComboBox cmbBusqueda = null;
	private ComboBoxModel modeloComboBox = null;
	private JTextField txtBusqueda = null;

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
		lblBusqueda.setBounds(new Rectangle(152, 19, 66, 26));
		lblBusqueda.setText("Busqueda:");
		modeloDoctor = ModeloDoctor.getInstancia();
		this.setSize(796, 411);
		this.setLayout(null);
		this.add(getPanelDoctor(), null);
		this.add(getBtnAgregar(), null);
		this.add(getBtnModificar(), null);
		this.add(getBtnCambiarStatus(), null);
		this.add(getBtnBuscar(), null);
		this.add(lblBusqueda, null);
		this.add(getCmbBusqueda(), null);
		this.add(getTxtBusqueda(), null);
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
			panelDoctor.setBounds(new Rectangle(48, 66, 679, 268));
			panelDoctor.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(
							SystemColor.activeCaptionText, 1),
					"Lista  Doctores", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), SystemColor.activeCaptionText));
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
			btnAgregar = new JButton();
			btnAgregar.setBounds(new Rectangle(90, 345, 124, 36));
			btnAgregar.setText("Agregar");
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
			btnModificar.setBounds(new Rectangle(234, 346, 124, 32));
			btnModificar.setText("Modificar");
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
			btnCambiarStatus.setBounds(new Rectangle(371, 350, 178, 24));
			btnCambiarStatus.setText("Cambiar Estatus");
		}
		return btnCambiarStatus;
	}

	/**
	 * This method initializes btnBuscar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton();
			btnBuscar.setBounds(new Rectangle(571, 17, 77, 29));
			btnBuscar.setText("Buscar");
		}
		return btnBuscar;
	}

	/**
	 * This method initializes cmbBusqueda
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbBusqueda() {
		if (cmbBusqueda == null) {
			cmbBusqueda = new JComboBox();
			cmbBusqueda.setModel(modeloComboBox);
			cmbBusqueda.setBounds(new Rectangle(223, 14, 134, 30));
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
			txtBusqueda.setBounds(new Rectangle(365, 11, 194, 37));
			txtBusqueda.setBorder((BorderFactory.createLineBorder(Color.black,
					1)));
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

} // @jve:decl-index=0:visual-constraint="10,10"
