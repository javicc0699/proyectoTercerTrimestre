package proyectoTercerTrimestre;


public class TipoPieza {
	
	private static int ultimoCodigo = 0;
	
	private int codigo;
	private String pieza;
	private double caballosPorc;
	private double manejoPorc;
	
	public TipoPieza(String pieza) {

		this.codigo = ++ultimoCodigo;
		this.pieza = pieza;
		this.caballosPorc = 0;
		this.manejoPorc = 0;

	}

	public String getPieza() {
		return pieza;
	}

	public void setPieza(String pieza) {
		this.pieza = pieza;
	}
	
	


}

