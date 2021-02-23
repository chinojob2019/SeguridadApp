package pe.com.distriluz.data.net.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("result")
	private int result;

	public void setResult(int result){
		this.result = result;
	}

	public int getResult(){
		return result;
	}
}