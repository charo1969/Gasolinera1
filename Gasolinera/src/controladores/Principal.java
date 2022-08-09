package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Combustible;
import modelo.Repostaje;
import vistas.FormularioAlta;
import vistas.ListadoVentas;

public class Principal {
	
	private FormularioAlta fAlta;
	private List<Combustible> listaCombustibles;
	
	private ListadoVentas fListado;
	
	private List<Repostaje> listaRepostaje;

	public Principal() {
		
		fAlta = new FormularioAlta();
		fAlta.setControlador(this);
		
		fListado = new ListadoVentas();
		fListado.setControlador(this);
		
		listaRepostaje = new ArrayList<>();
		
		
		listaCombustibles = new ArrayList<Combustible> ();
		listaCombustibles.add(new Combustible("Gasolina", 1.794));
		listaCombustibles.add(new Combustible("Gasoil", 1.773));
		listaCombustibles.add(new Combustible("Gasolina Plus", 1.832));
		listaCombustibles.add(new Combustible("Gasoil Plus", 1.842));
		
		mostrarAlta();
		
		
	}
	// metodo insertar a la lista un repostaje como parámetro
	
	public void insertarRepostaje(Repostaje r) {
		listaRepostaje.add(r);
		mostrarListado();
	}
	
	// metodos de llamada mostrarAlta 
	public void mostrarAlta() {
		fListado.setVisible(false);
		
		fAlta.setListaCombustibles(listaCombustibles);
		
		// limpiar formulario
		fAlta.limpiarFormulario();
		
		//mostrar la ventana
		fAlta.setVisible(true);
	}
	
	
	public void mostrarListado() {
		
		fAlta.setVisible(false);
		fListado.setListaRepostaje(listaRepostaje);
		fListado.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		Principal ppa1 = new Principal();
	

	}

	public void mostrarAlta(int fila) {
		
		fListado.setVisible(false);
		fAlta.setListaCombustibles(listaCombustibles);
		
		Repostaje r = listaRepostaje.get(fila);
		fAlta.setRepostaje(r);
		fAlta.setVisible(true);
	}

	public void borrarRpostaje(Repostaje editar) {
		listaRepostaje.remove(editar);
		mostrarListado();
		
	}


}
