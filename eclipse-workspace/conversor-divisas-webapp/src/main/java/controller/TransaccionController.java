package controller;

import service.DivisaService;
import model.Transaccion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.faces.view.ViewScoped;


@ViewScoped
public class TransaccionController implements Serializable{
	

	private static final long serialVersionUID = -1354805372699217573L;
	
	DivisaService ObjDvService = new DivisaService();
	public static List<Transaccion> historial = new ArrayList<>();

	

	public Transaccion realizarConversioDesdeVista(double montoFormulario, String TipoTrpFormulario){
		
		Transaccion ObjTransaccion = ObjDvService.registrarTransaccion(montoFormulario,TipoTrpFormulario);
		historial.add(ObjTransaccion);
		return ObjTransaccion;
	}

}
