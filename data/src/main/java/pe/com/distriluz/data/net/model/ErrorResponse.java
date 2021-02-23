package pe.com.distriluz.data.net.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ErrorResponse{

	@SerializedName("error")
	private Error error;

	public void setError(Error error){
		this.error = error;
	}

	public Error getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"ErrorResponse{" + 
			"error = '" + error + '\'' + 
			"}";
		}


	public static class Error{

		@SerializedName("codigo")
		private String codigo;

		@SerializedName("titulo")
		private String titulo;

		@SerializedName("mensaje")
		private String mensaje;

		public void setCodigo(String codigo){
			this.codigo = codigo;
		}

		public String getCodigo(){
			return codigo;
		}

		public void setTitulo(String titulo){
			this.titulo = titulo;
		}

		public String getTitulo(){
			return titulo;
		}

		public void setMensaje(String mensaje){
			this.mensaje = mensaje;
		}

		public String getMensaje(){
			return mensaje;
		}

		@Override
		public String toString(){
			return
					"Error{" +
							"codigo = '" + codigo + '\'' +
							",titulo = '" + titulo + '\'' +
							",mensaje = '" + mensaje + '\'' +
							"}";
		}
	}
}