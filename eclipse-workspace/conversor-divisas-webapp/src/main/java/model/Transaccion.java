package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaccion implements Serializable{

	private static final long serialVersionUID = -760149887136496294L;
	
	private double valorIngresado;
	private double tasa;
	//private LocalDateTime fecha;
	private String tipoTransaccion; // "USD_A_COP" o "COP_A_USD"
	
	//Constructores
	public Transaccion() {}
	public Transaccion(double valorIngresado, double tasa, String tipoRecibido){
		this.valorIngresado=valorIngresado;
		this.tasa = tasa;
		this.tipoTransaccion = tipoRecibido;
	}
	
	//Función de conversión
	public double convertir() {
		System.out.println("Se ha ejecutado la función convertir");
		
		if("USD_A_COP".equals(this.tipoTransaccion)) 
			return valorIngresado * tasa;
		else 
			return valorIngresado / tasa;
	}
	
}
