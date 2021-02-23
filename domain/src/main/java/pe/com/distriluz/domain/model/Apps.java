package pe.com.distriluz.domain.model;

import java.util.List;

public class Apps {

	private List<App> recurrentes;

	private List<App> destacados;

	private List<App> todos;

	private List<App> lanzamientos;

	public void setRecurrentes(List<App> recurrentes){
		this.recurrentes = recurrentes;
	}

	public List<App> getRecurrentes(){
		return recurrentes;
	}

	public void setDestacados(List<App> destacados){
		this.destacados = destacados;
	}

	public List<App> getDestacados(){
		return destacados;
	}

	public void setTodos(List<App> todos){
		this.todos = todos;
	}

	public List<App> getTodos(){
		return todos;
	}

	public void setLanzamientos(List<App> lanzamientos){
		this.lanzamientos = lanzamientos;
	}

	public List<App> getLanzamientos(){
		return lanzamientos;
	}


}