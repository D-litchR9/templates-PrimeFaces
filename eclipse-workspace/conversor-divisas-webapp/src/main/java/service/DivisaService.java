package service;
import model.Transaccion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class DivisaService {
	
	private static final String API_URL_DOLAR = "https://co.dolarapi.com/v1/trm";
	private static final String API_URL_COP = "https://freecurrencyapi.com";
	
	public double obtenerPrecioDolar(){
		try {
			//Cliente y petición
			 HttpClient client = HttpClient.newHttpClient();
			 HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(API_URL_DOLAR))
	                    .GET()
	                    .build();
			 
			 //Enviar petición
			 HttpResponse<String> response = client.send(request, 
					 HttpResponse.BodyHandlers.ofString());
			 
			 //Parsear JSON
			 ObjectMapper mapper = new ObjectMapper();
             JsonNode rootNode = mapper.readTree(response.body());
             
             //Obtener el valor de la API
             double valorDolar = rootNode.get("valor").asDouble();
             System.out.println("Precio actual del dólar obtenido: "+ valorDolar);
             //Retornar el precio del dolar
             return valorDolar;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al obtener el precio del dólar de la API");
			return 3800; 
		}
	}
	
	
	public double obtenerprecioCOP() {
		try {
		//Cliente y petición
		 HttpClient client = HttpClient.newHttpClient();
		 HttpRequest request = HttpRequest.newBuilder()
                   .uri(URI.create(API_URL_COP))
                   .GET()
                   .build();
		 
		 //Enviar petición
		 HttpResponse<String> response = client.send(request, 
				 HttpResponse.BodyHandlers.ofString());
		 
		 //Parsear JSON
		 ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.body());
        
        //Obtener el valor de COP
        double valorCOP = rootNode.get("valor").asDouble();
        
        //Retornar COP
        return valorCOP;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener el precio de COP de la API.");
			return 4000;
		}
	}
	public Transaccion registrarTransaccion(double valorIngresado, String tipoTr){
		double tasa;
		 if ("USD_A_COP".equals(tipoTr)) 
			tasa = obtenerprecioCOP();
		else 
			tasa = obtenerPrecioDolar();
		
		Transaccion nuevaTransaccion = new Transaccion(valorIngresado,tasa,tipoTr);
		nuevaTransaccion.convertir();
		return nuevaTransaccion;
	}
}
