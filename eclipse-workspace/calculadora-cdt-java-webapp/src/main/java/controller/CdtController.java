package controller;


import service.UsuarioService;
import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class CdtController implements Serializable{
		
	@Inject UsuarioService ObjService;

	private static final long serialVersionUID = 1428259387931014374L;
	//Tengo que modificar el service para que reciba los datos, y lo envie al modelodao
	public void agregarNuevoUsuarioDesdeVista(int idFormulario,String nombreFormulario) {		
		ObjService.guardarNuevoUsuario(idFormulario,nombreFormulario);
	}
	
	public void agregarNuevaInversionDesdeVista(int i, 
			String n, double m, int p, double t, int idIngresado) {

		ObjService.guardarInversionToUsuario(i, n, m, p, t, idIngresado);
	}
}
