package pe.com.distriluz.data.repository.datasource.auth;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.auth.model.ParametrosResponse;
import pe.com.distriluz.domain.model.Parametros;

/**
 * domain layer.
 */
@Singleton
public class AuthDataMapper {

    @Inject
    public AuthDataMapper() {
    }

    public Parametros mapperParametros(ParametrosResponse data){
        Parametros parametros= new Parametros();

        List<Parametros.ParametrosItem> listado = new ArrayList<>();

        for( ParametrosResponse.ParametrosItem item : data.getParametros() ){
            Parametros.ParametrosItem valor = new  Parametros.ParametrosItem();
            valor.setLlave(item.getLlave());
            valor.setValor(item.getValor());
            listado.add(valor);

        }

        parametros.setParametros(listado);
        return parametros;

    }



}
