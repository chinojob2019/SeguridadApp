package pe.com.distriluz.data.net.auth.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ParametrosResponse{

	@SerializedName("parametros")
	private List<ParametrosItem> parametros;

	public void setParametros(List<ParametrosItem> parametros){
		this.parametros = parametros;
	}

	public List<ParametrosItem> getParametros(){
		return parametros;
	}


	public static class ParametrosItem{

		@SerializedName("llave")
		private String llave;

		@SerializedName("valor")
		private String valor;

		public void setLlave(String llave){
			this.llave = llave;
		}

		public String getLlave(){
			return llave;
		}

		public void setValor(String valor){
			this.valor = valor;
		}

		public String getValor(){
			return valor;
		}
	}
}