package proyectoTercerTrimestre;

public class Coche {
	
	 private final int TAMANO_MATRICULA = 7;
	 private final int TAMANO_MARCA_MODELO = 45;
	 private final int TAMANO_ANYO = 4;
	 
	
	 private String matricula;
	 private String marca;
	 private String modelo;
	 private String anyo;
	 private double caballos;
	 private double manejo;
	 
	 
	 
	public Coche(String matricula) {
		this.matricula = matricula;
	}
	
	public Coche(String matricula, String marca, String modelo, String anyo, double caballos, double manejo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.caballos = caballos;
		this.manejo = manejo;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula.substring(0, Math.min(TAMANO_MATRICULA, matricula.length()));
	}
	
	public void setMarca(String marca) {
		this.marca = marca.substring(0, Math.min(TAMANO_MARCA_MODELO, marca.length()));
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo.substring(0, Math.min(TAMANO_MARCA_MODELO, modelo.length()));
	}
	
	public void setAnyo(String anyo) {
		this.anyo = anyo.substring(0, Math.min(TAMANO_ANYO, anyo.length()));
	}
	
	

	public void setCaballos(double caballos) {
		this.caballos = caballos;
	}
	
	public void setManejo(double manejo) {
		this.manejo = manejo;
	}

	 
}