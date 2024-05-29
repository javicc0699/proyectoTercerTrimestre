package proyectoTercerTrimestre;

public class Circuito {

	private final int TAMANO_UBICACION = 45;
	private final int TAMANO_DIFICULTAD = 15;

	private int idCircuito;
	private int curvas;
	private String ubicacion;
	private String dificultad;

	public Circuito(int idCircuito) {

		this.idCircuito = idCircuito;
	}

	public Circuito(int idCircuito, int curvas, String ubicacion, String dificultad) {
		super();
		this.idCircuito = idCircuito;
		this.curvas = curvas;
		this.ubicacion = ubicacion;
		this.dificultad = dificultad;
	}

	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}

	public void setCurvas(int curvas) {
		this.curvas = curvas;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion.substring(0, Math.min(TAMANO_UBICACION, ubicacion.length()));
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad.substring(0, Math.min(TAMANO_DIFICULTAD, dificultad.length()));
	}

}
