package pe.com.distriluz.data.net.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GenericResponse {

	@SerializedName("data")
	private Data data;

	@SerializedName("resultcode")
	private int resultcode;

	@SerializedName("mensaje")
	private String mensaje;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setResultcode(int resultcode){
		this.resultcode = resultcode;
	}

	public int getResultcode(){
		return resultcode;
	}

	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje(){
		return mensaje;
	}
}