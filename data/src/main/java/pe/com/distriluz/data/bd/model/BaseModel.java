package pe.com.distriluz.data.bd.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by gilson.maciel on 27/04/2015.
 */
public abstract class BaseModel {

    public static final String USER = "user";

    @DatabaseField(columnName = USER, defaultValue = "")
    protected String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
