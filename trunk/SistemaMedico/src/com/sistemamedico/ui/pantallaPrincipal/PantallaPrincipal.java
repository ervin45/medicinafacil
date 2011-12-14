package com.sistemamedico.ui.pantallaPrincipal;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import com.sistemamedico.ui.doctor.PanelDoctor;
import com.sistemamedico.ui.paciente.PanelPaciente;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JToolBar;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel panelDinamico = null;
	private CardLayout cardlayout = null;
	private JPanel panelFachada = null;
	private PanelDoctor panelDoctor = null;
	private JToolBar barraOpciones = null;
	private JLabel lblDoctor = null;
	private PanelPaciente panelPaciente = null;
	private JLabel lblPaciente = null;

	/**
	 * This is the default constructor
	 */
	public PantallaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(900, 548);
		cardlayout = new CardLayout();
		this.cardlayout.show(getPanelDinamico(), "fachada");
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		// Dimension pantallaTamano =
		// Toolkit.getDefaultToolkit().getScreenSize();

		// this.setLocation((pantallaTamano.width/2)-(this.getWidth()/2),
		// (pantallaTamano.height/2)-(this.getHeight()/2));

		this.setTitle("Sistema Medico");
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
			jContentPane.add(getPanelDinamico(), null);
			jContentPane.add(getBarraOpciones(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelDinamico
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelDinamico() {
		if (panelDinamico == null) {
			panelDinamico = new JPanel();
			panelDinamico.setBounds(new Rectangle(36, 60, 796, 411));
			panelDinamico.setLayout(cardlayout);
			panelDinamico.add("panelFachada", getPanelFachada());

			cardlayout.show(getPanelDinamico(), "fachada");

			panelDinamico.add("panelDoctor", getPanelDoctor());
			panelDinamico.add("panelPaciente", getPanelPaciente());
		}
		return panelDinamico;
	}

	public JPanel getPanelFachada() {
		if (panelFachada == null) {
			panelFachada = new JPanel();
			panelFachada.setLayout(new GridBagLayout());
			panelFachada.setSize(new Dimension(884, 378));
			JLabel lbl = new JLabel("Snailin");
			panelFachada.add(lbl);
		}
		return panelFachada;
	}

	public PanelDoctor getPanelDoctor() {
		if (panelDoctor == null) {
			panelDoctor = new PanelDoctor();
		}
		return panelDoctor;
	}

	/**
	 * This method initializes barraOpciones
	 * 
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getBarraOpciones() {
		if (barraOpciones == null) {
			lblPaciente = new JLabel();
			lblPaciente.setText("Paciente");
			lblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					cardlayout.show(getPanelDinamico(), "panelPaciente");
				}
			});

			lblDoctor = new JLabel();
			lblDoctor.setText("Doctor");
			lblDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					cardlayout.show(getPanelDinamico(), "panelDoctor");
				}
			});
			barraOpciones = new JToolBar();
			barraOpciones.setBounds(new Rectangle(1, 1, 897, 38));
			barraOpciones.add(lblDoctor);
			barraOpciones.addSeparator();
			barraOpciones.addSeparator();
			barraOpciones.add(lblPaciente);

		}
		return barraOpciones;
	}

	public PanelPaciente getPanelPaciente() {
		if (panelPaciente == null) {
			panelPaciente = new PanelPaciente();
		}
		return panelPaciente;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
