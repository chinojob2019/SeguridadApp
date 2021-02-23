package pe.com.distriluz.data.repository.datasource.changepassword;


import io.reactivex.Single;
import pe.com.distriluz.domain.model.DetailUser;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface ChangePasswordDataStore {


    Single<Boolean> enviarEmail(String email);


}
