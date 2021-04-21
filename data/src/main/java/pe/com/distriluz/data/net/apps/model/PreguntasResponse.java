package pe.com.distriluz.data.net.apps.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PreguntasResponse{



	@SerializedName("preguntasFrecuentes")
	private List<PreguntasFrecuentesItem> preguntasFrecuentes;

	public void setPreguntasFrecuentes(List<PreguntasFrecuentesItem> preguntasFrecuentes){
		this.preguntasFrecuentes = preguntasFrecuentes;
	}

	public List<PreguntasFrecuentesItem> getPreguntasFrecuentes(){
		return preguntasFrecuentes;
	}



	public class PreguntasFrecuentesItem {

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("respuestas")
		private List<RespuestasItem> respuestas;

		@SerializedName("orden")
		private int orden;

		@SerializedName("idPregunta")
		private int idPregunta;

		@SerializedName("descripcion")
		private String pregunta;


		public PreguntasFrecuentesItem(int idEstado, List<RespuestasItem> respuestas, int orden, int idPregunta, String pregunta) {
			this.idEstado = idEstado;
			this.respuestas = respuestas;
			this.orden = orden;
			this.idPregunta = idPregunta;
			this.pregunta = pregunta;
		}

		public int getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(int idEstado) {
			this.idEstado = idEstado;
		}

		public List<RespuestasItem> getRespuestas() {
			return respuestas;
		}

		public void setRespuestas(List<RespuestasItem> respuestas) {
			this.respuestas = respuestas;
		}

		public int getOrden() {
			return orden;
		}

		public void setOrden(int orden) {
			this.orden = orden;
		}

		public int getIdPregunta() {
			return idPregunta;
		}

		public void setIdPregunta(int idPregunta) {
			this.idPregunta = idPregunta;
		}

		public String getPregunta() {
			return pregunta;
		}

		public void setPregunta(String pregunta) {
			this.pregunta = pregunta;
		}
	}
	public class RespuestasItem{

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("orden")
		private int orden;

		@SerializedName("descripcion")
		private String respuesta;

		@SerializedName("idRespuesta")
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