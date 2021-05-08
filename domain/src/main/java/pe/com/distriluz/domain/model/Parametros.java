package pe.com.distriluz.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parametros {

    private List<ParametrosItem> parametros;
    public void setParametros(List<ParametrosItem> parametros){
        this.parametros = parametros;
    }
    public List<ParametrosItem> getParametros(){
        return parametros;
    }

    public static class ParametrosItem{
        private String llave;
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
