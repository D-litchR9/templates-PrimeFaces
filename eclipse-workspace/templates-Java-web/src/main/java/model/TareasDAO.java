package model;

import java.util.ArrayList;
import java.util.List;

public class TareasDAO {

	
	public TareasDAO(){
		cargarDatos();
	}
	public List<Tarea> listaDeTareasDAO = new ArrayList<>();
	
	public void agregarTarea(Tarea nuevatarea) {
		listaDeTareasDAO.add(nuevatarea);
	}
	
	public void eliminarTarea(int identificador) {
		Tarea TareaParaBorrar = buscarTarea(identificador);
		listaDeTareasDAO.remove(TareaParaBorrar);
	}
	
	public Tarea buscarTarea(int identificador) {
		return listaDeTareasDAO.stream()
	            .filter(t -> t.getId() == identificador)
	            .findFirst()
	            .orElse(null);
	}
	
	public void actualizarTarea(int identificador, String nuevaDescripcion, String nuevoEstado) {
		Tarea tareaParaActualizar = buscarTarea(identificador);
		tareaParaActualizar.setDescripcion(nuevaDescripcion);
		tareaParaActualizar.setEstado(nuevoEstado);
	}
	
	public void cargarDatos() {
		//Para simular persistencia
		Tarea t1,t2,t3;
		t1 = new Tarea(01,"tarea de programación","pendiente");
		t2 = new Tarea(02,"tarea de base de datos","completada");
		t3 = new Tarea(03,"tarea de taller de investigación","pendiente");
		
		listaDeTareasDAO.add(t1);
		listaDeTareasDAO.add(t2);
		listaDeTareasDAO.add(t3);
	
	}
	
}
