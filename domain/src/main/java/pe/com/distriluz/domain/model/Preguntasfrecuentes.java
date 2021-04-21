package pe.com.distriluz.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Preguntasfrecuentes {

	private int idEstado;
	private List<RespuestasItem> respuestas;
	private int orden;
	private int idPregunta;
	private String pregunta;


	public Preguntasfrecuentes(int idEstado, List<RespuestasItem> respuestas, int orden, int idPregunta, String pregunta) {
		this.idEstado = idEstado;
		this.respuestas = respuestas;
		this.orden = orden;
		this.idPregunta = idPregunta;
		this.pregunta = pregunta;
	}


	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public List<RespuestasItem> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestasItem> respuestas) {
		this.respuestas = respuestas;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public static class RespuestasItem{

		private int idEstado;
		private int orden;
		private String respuesta;
		private int idRespuesta;

		public int getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(int idEstado) {
			this.idEstado = idEstado;
		}

		public int getOrden() {
			return orden;
		}

		public void setOrden(int orden) {
			this.orden = orden;
		}

		public String getRespuesta() {
			return respuesta;
		}

		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}

		public int getIdRespuesta() {
			return idRespuesta;
		}

		public void setIdRespuesta(int idRespuesta) {
			this.idRespuesta = idRespuesta;
		}
	}

}