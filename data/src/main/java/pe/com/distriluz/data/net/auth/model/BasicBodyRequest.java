package pe.com.distriluz.data.net.auth.model;

import com.google.gson.annotations.SerializedName;

public class BasicBodyRequest {

	@SerializedName("llave")
	private String llave;

	@SerializedName("valor")
	private String valor;

	public BasicBodyRequest(String llave, String valor) {
		this.llave = llave;
		this.valor = valor;
	}

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