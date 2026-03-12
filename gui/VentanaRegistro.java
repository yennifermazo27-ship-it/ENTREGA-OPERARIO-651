package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ModeloDatos;
import clases.Procesos;
import entidades.Operario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRegistro extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtSueldo;
	private JTextField txtAntiguedad;
	private JLabel lblDocumento;
	private JLabel lblNombre;
	private JLabel lblSueldo;
	private JLabel lblResSueldoN;
	private JLabel lblPorAumento;
	private JLabel lblPorAumentoFin;
	private JLabel lblSueldoNuevo;
	private JLabel lblAntiguedad;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	
	Procesos miProceso;
	private JButton btnConsultar;
	ModeloDatos miModelo;
	private JButton btnConsultarLista;
	
	

	public VentanaRegistro() {
		
		miProceso=new Procesos();
		miModelo=new ModeloDatos();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		

	}


	private void iniciarComponentes() {
		JLabel lblSistemaGestionUsuarios = new JLabel("Cálculo de aumentos salariales anuales");
		lblSistemaGestionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaGestionUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSistemaGestionUsuarios.setBounds(-20, 50, 500, 30);
		contentPane.add(lblSistemaGestionUsuarios);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(150, 130, 200, 26);
		contentPane.add(txtDocumento);		
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(150, 180, 200, 26);
		contentPane.add(txtNombre);	
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(131, 230, 78, 26);
		contentPane.add(txtSueldo);		
		
		txtAntiguedad = new JTextField();
		txtAntiguedad.setColumns(10);
		txtAntiguedad.setBounds(320, 230, 78, 26);
		contentPane.add(txtAntiguedad);	
		

		JLabel lblDocumento = new JLabel("Nombre:");
		lblDocumento.setBounds(55, 135, 90, 16);
		contentPane.add(lblDocumento);		
		
		JLabel lblNombre = new JLabel("Documento:");
		lblNombre.setBounds(55, 185, 90, 16);
		contentPane.add(lblNombre);	
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(55, 235, 90, 16);
		contentPane.add(lblSueldo);	
		
		JLabel lblAntiguedad = new JLabel("% Aumento:");
		lblAntiguedad.setBounds(55, 285, 90, 16);
		contentPane.add(lblAntiguedad);	
		
		JLabel lblPorAumento = new JLabel("Antiguedad");
		lblPorAumento.setBounds(235, 235, 90, 16);
		contentPane.add(lblPorAumento);	
		
		lblPorAumentoFin = new JLabel();
		lblPorAumentoFin.setForeground(Color.BLUE);
		lblPorAumentoFin.setBounds(150, 285, 90, 16);
		contentPane.add(lblPorAumentoFin);	
		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(30, 392, 415, 29);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(30, 440, 415, 29);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setBounds(30, 392, 415, 29);
		btnConsultarLista.addActionListener(this);
		contentPane.add(btnConsultarLista);
		
		JLabel lblSueldoNuevo = new JLabel("Sueldo Nuevo:");
		lblSueldoNuevo.setBounds(55, 310, 90, 16);
		contentPane.add(lblSueldoNuevo);	
		
		lblResSueldoN = new JLabel();
		lblResSueldoN.setForeground(Color.BLUE);
		lblResSueldoN.setBounds(155, 310, 102, 16);
		contentPane.add(lblResSueldoN);	
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(30, 490, 415, 29);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			
			registrarOperario();
			
		} else if(e.getSource()==btnCancelar) {

			limpiar();
		}else if(e.getSource()==btnConsultar) {
			
			consultarIndividual();
		}else if(e.getSource()==btnConsultarLista) {
			
			miModelo.consultarOperarioLista();
		}
		
	}
	


private void consultarIndividual() {
		
	String documento=txtDocumento.getText();
	Operario miOpera = miModelo.consultarOperarioPorDocumento(documento);
	
	if(miOpera!=null) {
		System.out.println("Objeto encontrado: " +miOpera);
		txtDocumento.setText(miOpera.getDocumento());
		txtNombre.setText(miOpera.getNombre());
		txtAntiguedad.setText(miOpera.getAntiguedad()+"");
		txtSueldo.setText(miOpera.getSueldo()+"");
		lblPorAumentoFin.setText(miOpera.getAumento()+"");
		lblResSueldoN.setText(miOpera.getSueldoNuevo()+"");
	}else {
		System.out.println("No existe la persona a buscar");
		JOptionPane.showMessageDialog(null, "No existe!");
		
	}
	}


private void registrarOperario() {
	System.out.println("Registro Exitoso");
	
	Operario miOperario=new Operario();
	miOperario.setDocumento(txtDocumento.getText());
	miOperario.setNombre(txtNombre.getText());
	miOperario.setAntiguedad(Integer.parseInt(txtAntiguedad.getText()));
	miOperario.setSueldo(Double.parseDouble(txtSueldo.getText()));
	
	System.out.println("Antes: " +miOperario);
	
	
	miProceso.calcularSueldoNuevo(miOperario);
	
	System.out.println("Despues: "+miOperario);
	
	lblResSueldoN.setText(miOperario.getSueldoNuevo()+"");  // ""Transforma un Double en texto
	lblPorAumentoFin.setText(miOperario.getAumento()+"");
	
	String resp=miModelo.registrarOperario(miOperario);
	
	if(resp.equals("Si")) {
		JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
	}else {
		JOptionPane.showMessageDialog(null, "No se pudo registrar, ya existe");
	}
	
}

private void limpiar() {
	txtDocumento.setText("");
	txtNombre.setText("");
	txtSueldo.setText("");
	txtAntiguedad.setText("");
	lblPorAumentoFin.setText("");
	lblResSueldoN.setText("");
	
}



}