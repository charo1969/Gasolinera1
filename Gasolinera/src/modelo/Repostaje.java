package modelo;

public class Repostaje {
	
	private String matricula;
	private String nombre;
	private String dni;
	private Combustible combustible;
	private double litros;
	private double total;
	private boolean agrario;
	private boolean bGobierno;
	private boolean siVuelves;
	
	public static final double DESCUENTO_AGRARIO = 0.45;
	public static final double DESCUENTO_GOBIERNO = 0.20;
	public static final double DESCUENTO_VUELVES = 0.05;
	
	// los constructores tanto con parámetros como sin parámetros
	
	public Repostaje(String matricula, String nombre, String dni, Combustible combustible, double litros, double total,
			boolean agrario, boolean bGobierno, boolean siVuelves) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.dni = dni;
		this.combustible = combustible;
		this.litros = litros;
		this.total = total;
		this.agrario = agrario;
		this.bGobierno = bGobierno;
		this.siVuelves = siVuelves;
	}

	public Repostaje() {
		this.matricula = "";
		this.nombre = "";
		this.dni = "";
		this.combustible = new Combustible();
		this.litros = 0;
		this.agrario =this.bGobierno=this.siVuelves = false;
	
	}
	
	// son los getters y setters
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}
	

	public boolean isAgrario() {
		return agrario;
	}

	public void setAgrario(boolean agrario) {
		this.agrario = agrario;
	}

	public boolean isbGobierno() {
		return bGobierno;
	}

	public void setbGobierno(boolean bGobierno) {
		this.bGobierno = bGobierno;
	}

	public boolean isSiVuelves() {
		return siVuelves;
	}

	public void setSiVuelves(boolean siVuelves) {
		this.siVuelves = siVuelves;
	}
	
	// el toString
	@Override
	public String toString() {
		return "Repostaje [matricula=" + matricula + ", nombre=" + nombre + ", dni=" + dni + ", combustible="
				+ combustible + ", litros=" + litros + ", total=" + total + ", agrario=" + agrario + ", bGobierno="
				+ bGobierno + ", siVuelves=" + siVuelves + "]";
	}
	
	// esto son los precios con los distintos descuentos.
	protected double getPrecioLitroDescuento() {
		double precio = this.combustible.getPrecio();
		
		if(isAgrario()) {
			precio = precio  - DESCUENTO_AGRARIO;
		}else {
			if(isbGobierno()) {
				precio = precio -  DESCUENTO_GOBIERNO;
			}
			if(isSiVuelves()) {
				precio = precio - DESCUENTO_VUELVES;
			}
		}
		return precio ;
	}
	
	//para hacer el descuento de los precios de los productos de la gasolinera
	public double getTotal() {
		return getPrecioLitroDescuento() * this.litros;
		
	}
	
	public void setTotal (double total) {
		double precio =getPrecioLitroDescuento();
		this.litros = total/precio;
	}
	
}
