package com.sistemamedico.ui.receta;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sistemamedico.modelo.ModeloConsulta;
import com.sistemamedico.modelo.ModeloPaciente;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.lang.String;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelConsulta = null;
	private JScrollPane jspConsultas = null;
	private JTable tblConsultas = null;
	private JPanel panelBusqueda = null;
	private JLabel lblBusqueda = null;
	private JComboBox cmbBusqueda = null;
	private JTextField txtBusqueda = null;
	private ModeloConsulta modeloConsulta = null;
	private JButton btnAgregar = null;
	private JButton btnModificar = null;

	/**
	 * This is the default constructor
	 */
	public PanelConsulta() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		modeloConsulta = ModeloConsulta.getInstancia();
		this.setSize(744, 420);
		this.setLayout(null);
		this.add(getPanelConsulta(), null);
		this.add(getPanelBusqueda(), null);
		this.add(getBtnAgregar(), null);
		this.add(getBtnModificar(), null);
	}

	/**
	 * This method initializes panelConsulta
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelConsulta() {
		if (panelConsulta == null) {
			panelConsulta = new JPanel();
			panelConsulta.setLayout(null);
			panelConsulta.setBounds(new Rectangle(27, 91, 679, 268));
			panelConsulta.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Lista  Pacientes", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			panelConsulta.add(getJspConsultas(), null);
		}
		return panelConsulta;
	}

	/**
	 * This method initializes jspConsultas
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJspConsultas() {
		if (jspConsultas == null) {
			jspConsultas = new JScrollPane();
			jspConsultas.setBounds(new Rectangle(10, 31, 652, 221));
			jspConsultas.setViewportView(getTblConsultas());
		}
		return jspConsultas;
	}

	/**
	 * This method initializes tblConsultas
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getTblConsultas() {
		if (tblConsultas == null) {
			tblConsultas = new JTable();
			tblConsultas.setModel(modeloConsulta);
		}
		return tblConsultas;
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
			panelBusqueda.setBounds(new Rectangle(181, 26, 382, 56));
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
			cmbBusqueda.setBounds(new Rectangle(95, 17, 100, 25));
			cmbBusqueda.setModel(new DefaultComboBoxModel(new String[] {
					"ID Consulta", "ID Doctor" }));
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
			txtBusqueda.setBounds(new Rectangle(203, 17, 162, 25));
			txtBusqueda.setBorder((BorderFactory.createLineBorder(Color.black,
					1)));
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
			btnAgregar.setBounds(new Rectangle(268, 372, 87, 30));
			btnAgregar.setText("Agregar");
			btnAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					RecetaMedica recetaMedica=new RecetaMedica();
					recetaMedica.setAlwaysOnTop(true);
					recetaMedica.setVisible(true);
					
					
					
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
			btnModificar.setBounds(new Rectangle(370, 372, 87, 30));
			btnModificar.setText("Modificar");
			btnModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				
				}
			});
		}
		return btnModificar;
	}

}
