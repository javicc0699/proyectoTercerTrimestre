package proyectoTercerTrimestre;

public class Pieza {
	
	private int codigo;
	private String pieza;
	private String calidad;
	private double caballosProp;
	private double manejoProp;
	
	
	public Pieza(int codigo, String pieza, String calidad, double caballosProp, double manejoProp) {
		
		this.codigo = codigo;
		this.pieza = pieza;
		this.calidad = calidad;
		this.caballosProp = caballosProp;
		this.manejoProp = manejoProp;
		
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPieza() {
		return pieza;
	}
	public void setPieza(String pieza) {
		this.pieza = pieza;
	}
	public String getCalidad() {
		return calidad;
	}
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	public double getCaballosProp() {
		return caballosProp;
	}
	public void setCaballosProp(double caballosProp) {
		this.caballosProp = caballosProp;
	}
	public double getManejoProp() {
		return manejoProp;
	}
	public void setManejoProp(double manejoProp) {
		this.manejoProp = manejoProp;
	}
	
	
	
}
