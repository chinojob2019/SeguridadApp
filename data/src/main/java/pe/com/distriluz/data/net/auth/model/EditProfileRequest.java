package pe.com.distriluz.data.net.auth.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EditProfileRequest{

	@SerializedName("llave")
	private String llave;

	@SerializedName("valor")
	private String valor;

	public EditProfileRequest(String llave, String valor) {
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