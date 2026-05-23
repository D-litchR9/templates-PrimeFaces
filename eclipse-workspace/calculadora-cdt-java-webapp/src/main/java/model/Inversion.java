package model;

public class Inversion {
	//Variables
	private int id;
	private String nombreInversion;
	private double montoInversion;
	private int plazoEnDias;
	private double tasa;
	private double gananciaBruta;
	private double gananciaNeta;
	
	//Constructor
	public Inversion( int id, String nombreIngresado, double montoIngresado, int plazoIngresado, double tasaIngresada) {
		this.id = id;
		this.nombreInversion = nombreIngresado;
		this.montoInversion =montoIngresado;
		this.plazoEnDias = plazoIngresado;
		this.tasa = tasaIngresada;
	}
	//Función para calcular ganancia Bruta
	public double calcularGananciaBruta() {
		return gananciaBruta = this.montoInversion * this.tasa * (this.plazoEnDias/365.0);
	}
	public double calcularGananciaNeta() {
		double gb = this.calcularGananciaBruta();
		this.gananciaNeta = gb - (gb * 0.04);
		return this.gananciaNeta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreInversion() {
		return nombreInversion;
	}
	public void setNombreInversion(String nombreInversion) {
		this.nombreInversion = nombreInversion;
	}
	public double getMontoInversion() {
		return montoInversion;
	}
	public void setMontoInversion(double montoInversion) {
		this.montoInversion = montoInversion;
	}
	public int getPlazoEnDias() {
		return plazoEnDias;
	}
	public void setPlazoEnDias(int plazoEnDias) {
		this.plazoEnDias = plazoEnDias;
	}
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	public double getGananciaBruta() {
		return gananciaBruta;
	}
	public void setGananciaBruta(double gananciaBruta) {
		this.gananciaBruta = gananciaBruta;
	}
	public double getGananciaNeta() {
		return gananciaNeta;
	}
	public void setGananciaNeta(double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}
	
}
