package proyectoTercerTrimestre;

public class PiezasCoche {

	private String calidad;
	private double caballosPieza;
	private double manejoPieza;

	public PiezasCoche(String calidad, double caballosPieza, double manejoPieza) {
		
		this.calidad = calidad;
		this.caballosPieza = caballosPieza;
		this.manejoPieza = manejoPieza;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public double getCaballosPieza() {
		return caballosPieza;
	}

	public void setCaballosPieza(double caballosPieza) {
		this.caballosPieza = caballosPieza;
	}

	public double getManejoPieza() {
		return manejoPieza;
	}

	public void setManejoPieza(double manejoPieza) {
		this.manejoPieza = manejoPieza;
	}

}
