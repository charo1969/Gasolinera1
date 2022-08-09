package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.Principal;
import modelo.Combustible;
import modelo.Repostaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioAlta extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtLitros;
	private JTextField txtTotal;
	private List<Combustible> listaCombustibles;
	private JComboBox <Combustible> cboxCombustible;
	private JCheckBox cbxAgrario;
	private JCheckBox cbxBonifGob;
	private JCheckBox cbxPorTuVuelvas;
	
	// instancia de la clase principal
	private Principal controlador;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAlta() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Nuevo Repostaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[35.00][][347.00,grow][35.00px:n]", 
				"[grow][grow][grow][grow][grow][grow][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula:");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel, "cell 1 1");
		
		txtMatricula = new JTextField();
		txtMatricula.setMaximumSize(new Dimension(2147483647, 35));
		txtMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtMatricula, "cell 2 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_1, "cell 1 2");
		
		txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(2147483647, 35));
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtNombre, "cell 2 2,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2, "cell 1 3");
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDni.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtDni, "cell 2 3,growx");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Combustible:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_3, "cell 1 4");
		
	    cboxCombustible = new JComboBox();
		cboxCombustible.setMaximumSize(new Dimension(32767, 35));
		contentPane.add(cboxCombustible, "cell 2 4,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Litros:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_4, "cell 1 5");
		
		txtLitros = new JTextField();
		txtLitros.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtLitros.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtLitros, "cell 2 5,growx");
		txtLitros.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Total:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_5, "cell 1 6");
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtTotal.setMaximumSize(new Dimension(2147483647, 35));
		txtTotal.setText("");
		contentPane.add(txtTotal, "cell 2 6,growx");
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Descuento:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_6, "cell 1 7");
		
		cbxAgrario = new JCheckBox("Agrario");
		cbxAgrario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaOtros();
			}
		});
		cbxAgrario.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(cbxAgrario, "flowx,cell 2 7");
		
		cbxBonifGob = new JCheckBox("Bonificaci\u00F3n Gobierno");
		cbxBonifGob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		cbxBonifGob.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(cbxBonifGob, "cell 2 7");
		
		cbxPorTuVuelvas = new JCheckBox("Porque tu vuelvas");
		cbxPorTuVuelvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		cbxPorTuVuelvas.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(cbxPorTuVuelvas, "cell 2 7");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 2 8,grow");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		
		panel.add(btnAceptar);
		
		btnNewButton = new JButton("Mostrar listado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListado();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnNewButton);
	}
	/**
	 * Comprobaciones para validar los datos del formulario de alta de la gasolinera
	 */
	protected void compruebaOtros() {
		if(cbxAgrario.isSelected() && 
				(cbxBonifGob.isSelected() || cbxPorTuVuelvas.isSelected())) {
			
				JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuentos"+
				"con el descuento agrario",
				"Descuento no aplicable",
				JOptionPane.INFORMATION_MESSAGE);
			cbxAgrario.setSelected(false);
		}
		
	}

	protected void compruebaAgrario() {
		
		if(cbxBonifGob.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuentos"+
					"con el descuento agrario",
					"Descuento no aplicable",
					JOptionPane.INFORMATION_MESSAGE);
				cbxBonifGob.setSelected(false);
			
		}
		if(cbxPorTuVuelvas.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuentos"+
					"con el descuento agrario",
					"Descuento no aplicable",
					JOptionPane.INFORMATION_MESSAGE);
				cbxPorTuVuelvas.setSelected(false);
	  }
	}
	
	
	protected void insertar() {
		
		Repostaje r = new Repostaje(); // recogemos los datos de todos los campos en r.
		
		if (txtMatricula.getText()==null || txtMatricula.getText().isBlank() ||
				txtNombre.getText()==null || txtNombre.getText().isBlank() ||
				txtDni.getText()==null || txtDni.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(this, 
					"Los campos matricula, nombre y DNI son obligatorios",
					"Campos obligatorios vacío",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		} 
			r.setMatricula(txtMatricula.getText());
			r.setNombre(txtNombre.getText());
			r.setDni(txtDni.getText());
		
		if(txtLitros.getText() != null && !txtLitros.getText().isBlank() &&
			txtTotal.getText() != null && !txtTotal.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, 
					"Solo debe rellenar uno de los dos campos, litro o total",
					"Datos incorrectos",
					JOptionPane.INFORMATION_MESSAGE);
			return;
				
		} 
		//recoger los datos de los checkbox
		r.setCombustible((Combustible) cboxCombustible.getSelectedItem());
		
		r.setAgrario(cbxAgrario.isSelected());
		r.setbGobierno(cbxBonifGob.isSelected());
		r.setSiVuelves(cbxPorTuVuelvas.isSelected());
		controlador.insertarRepostaje(r);
		
		
		// try catch para que los litros o el total esten rellenos.
		try {
			
			if(txtLitros.getText() != null && !txtLitros.getText().isBlank()) {
				r.setLitros(Double.parseDouble(txtLitros.getText()));
				
			} else {
				r.setTotal(Double.parseDouble(txtTotal.getText()));
				
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, 
					"Debe de introducir un número válido en litro o total",
					"Datos incorrectos",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		
	}
		
	
	// creamos la lista en el combobox para que sea visible y seleccionar el primero como defecto.
	// luego lanzamos la ventana en el archivo principal

	public void setListaCombustibles(List<Combustible> listaCombustibles) {
		this.listaCombustibles = listaCombustibles;
		
		DefaultComboBoxModel<Combustible> modelo = new DefaultComboBoxModel<>();
		
		modelo.addAll(listaCombustibles);
		
		cboxCombustible.setModel(modelo);
		
		cboxCombustible.setSelectedIndex(0);
	
	}
	
	// creamos el set para el principal

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}
	
	// limpiar datos
	
	public void limpiarFormulario() {
		this.txtMatricula.setText("");
		this.txtNombre.setText("");
		this.txtDni.setText("");
		this.cboxCombustible.setSelectedIndex(0);
		this.txtLitros.setText("");
		this.txtTotal.setText("");
		this.cbxAgrario.setSelected(false);
		this.cbxBonifGob.setSelected(false);
		this.cbxPorTuVuelvas.setSelected(false);
		
	}
	
	
	
	

}
