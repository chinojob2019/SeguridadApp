package pe.com.distriluz.domain.model;

public class Preguntasfrecuentes {

	private int orden;
	private String respuesta;
	private String pregunta;

	public Preguntasfrecuentes(int orden, String respuesta, String pregunta) {
		this.orden = orden;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
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

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
}