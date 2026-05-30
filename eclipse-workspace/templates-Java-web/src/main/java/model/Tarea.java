package model;
import java.io.Serializable;

public class Tarea implements Serializable{
	
	private static final long serialVersionUID = -5673115553538354536L;
	private int id;
    private String descripcion;
    private String estado;

    public Tarea() {}
    public Tarea(int id, String descripcion, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
    
}
