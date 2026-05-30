package controller;

import model.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("tareaBean")
@SessionScoped
public class TareaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private TareasDAO interfazDao;
    private List<Tarea> listaTareas;
    private Tarea nuevaTarea;
    private Tarea tareaSeleccionada;
    private int ultimoId;

    @PostConstruct
    public void init() {
        interfazDao = new TareasDAO();
        listaTareas = interfazDao.listaDeTareasDAO;
        nuevaTarea = new Tarea();
        calcularUltimoId();
    }

    private void calcularUltimoId() {
        ultimoId = listaTareas.stream().mapToInt(Tarea::getId).max().orElse(0);
    }

    // Acciones desde la vista
    public String agregarTarea() {
        ultimoId++;
        nuevaTarea.setId(ultimoId);
        interfazDao.agregarTarea(nuevaTarea);
        nuevaTarea = new Tarea(); // limpiar
        return "/tareas/lista.xhtml?faces-redirect=true";
    }

    public void eliminarTarea(Tarea tarea) {
        interfazDao.eliminarTarea(tarea.getId());
    }

    public String prepararEditar(Tarea tarea) {
        this.tareaSeleccionada = tarea;
        return "/tareas/editar.xhtml";
    }

    public String actualizarTarea() {
        interfazDao.actualizarTarea(tareaSeleccionada.getId(),
                tareaSeleccionada.getDescripcion(),
                tareaSeleccionada.getEstado());
        tareaSeleccionada = null;
        return "/tareas/lista.xhtml?faces-redirect=true";
    }

    // Getters y setters (solo los necesarios)
    public List<Tarea> getListaTareas() { return listaTareas; }
    public Tarea getNuevaTarea() { return nuevaTarea; }
    public void setNuevaTarea(Tarea nuevaTarea) { this.nuevaTarea = nuevaTarea; }
    public Tarea getTareaSeleccionada() { return tareaSeleccionada; }
    public void setTareaSeleccionada(Tarea tareaSeleccionada) { this.tareaSeleccionada = tareaSeleccionada; }
}