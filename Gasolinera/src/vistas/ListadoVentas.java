package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.Principal;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoVentas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	
	private Principal controlador;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVentas frame = new ListadoVentas();
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
	public ListadoVentas() {
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Ventas:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre", "DNI", "Combustible", "Litros", "Total", "Agrario", "Bonificaci\u00F3n Gobierno", "Porque tu vuelves"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Object.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 2,grow");
		
		btnVolver = new JButton("Volver");
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAlta();
			}
		});
		
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnVolver);
		
		btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				controlador.mostrarAlta(fila);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnNewButton);
	}

	public void setListaRepostaje(List<Repostaje> listaRepostaje) {
		
		// añadir los datos al modelo
		DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
		
		// vaciamos la tabla.
		modelo.setRowCount(0);
		
		// recorrer la lista de la tabla repostaje
		for (Repostaje repostaje : listaRepostaje) {
			Object [] fila = {
					repostaje.getMatricula(),
					repostaje.getNombre(),
					repostaje.getDni(),
					repostaje.getCombustible(),
					repostaje.getLitros(),
					repostaje.getTotal(),
					repostaje.isAgrario(),
					repostaje.isbGobierno(),
					repostaje.isSiVuelves()
			};
			modelo.addRow(fila);
		}
	
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}
	
	
	

}
