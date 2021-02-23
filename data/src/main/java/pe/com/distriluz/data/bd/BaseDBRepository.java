package pe.com.distriluz.data.bd;

import android.content.Context;

import pe.com.distriluz.data.bd.model.BaseModel;
import pe.com.distriluz.data.bd.repository.BaseOrmLiteRepository;


/**
 * Created by pedro.zevallos on 26/10/2017.
 */

public abstract class BaseDBRepository<T extends BaseModel, Id> extends BaseOrmLiteRepository<T, Id> {
    public BaseDBRepository(Context context) {
        super(context, DBHelper.class);
    }

    public Context getContext() {
        return context;
    }
}