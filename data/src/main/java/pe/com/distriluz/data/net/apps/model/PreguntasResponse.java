package pe.com.distriluz.data.net.apps.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PreguntasResponse{

	@SerializedName("preguntasFrecuentes")
	private List<PreguntasfrecuentesItem> preguntasfrecuentes;

	public void setPreguntasfrecuentes(List<PreguntasfrecuentesItem> preguntasfrecuentes){
		this.preguntasfrecuentes = preguntasfrecuentes;
	}

	public List<PreguntasfrecuentesItem> getPreguntasfrecuentes(){
		return preguntasfrecuentes;
	}


	public static class PreguntasfrecuentesItem{

		@SerializedName("orden")
		private int orden;

		@SerializedName("respuesta")
		private String respuesta;

		@SerializedName("pregunta")
		private String pregunta;

		public PreguntasfrecuentesItem(int orden, String respuesta, String pregunta) {
			this.orden = orden;
			this.respuesta = respuesta;
			this.pregunta = pregunta;
		}

		public void setOrden(int orden){
			this.orden = orden;
		}

		public int getOrden(){
			return orden;
		}

		public void setRespuesta(String respuesta){
			this.respuesta = respuesta;
		}

		public String getRespuesta(){
			return respuesta;
		}

		public void setPregunta(String pregunta){
			this.pregunta = pregunta;
		}

		public String getPregunta(){
			return pregunta;
		}
	}
}