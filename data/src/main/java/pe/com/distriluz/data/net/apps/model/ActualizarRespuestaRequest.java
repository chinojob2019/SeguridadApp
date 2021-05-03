package pe.com.distriluz.data.net.apps.model;

import com.google.gson.annotations.SerializedName;

public class ActualizarRespuestaRequest{

	@SerializedName("descripcion")
	private String descripcion;

	@SerializedName("idEstado")
	private int idEstado;

	@SerializedName("orden")
	private int orden;

	@SerializedName("idRespuesta")
	private int idRespuesta;

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setIdEstado(int idEstado){
		this.idEstado = idEstado;
	}

	public int getIdEstado(){
		return idEstado;
	}

	public void setOrden(int orden){
		this.orden = orden;
	}

	public int getOrden(){
		return orden;
	}

	public void setIdRespuesta(int idRespuesta){
		this.idRespuesta = idRespuesta;
	}

	public int getIdRespuesta(){
		return idRespuesta;
	}
}