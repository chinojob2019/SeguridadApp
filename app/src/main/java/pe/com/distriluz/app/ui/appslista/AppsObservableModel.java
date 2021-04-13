package pe.com.distriluz.app.ui.appslista;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class AppsObservableModel extends BaseObservable {

    private ObservableList<AppObservable> recurrentes = new ObservableArrayList<>();
    private ObservableList<AppObservable> destacados = new ObservableArrayList<>();
    private ObservableList<AppObservable> todos = new ObservableArrayList<>();
    private ObservableList<AppObservable> lanzamientos = new ObservableArrayList<>();
    private ObservableField<Boolean> isGrid = new ObservableField<>(true);

    @Bindable
    public Boolean getVisibleDestacados() {
        return !destacados.isEmpty();
    }
    @Bindable
    public Boolean getVisibleRecurrentes() {
        return !recurrentes.isEmpty();
    }
    @Bindable
    public Boolean getVisibleTodos() {
        return !todos.isEmpty();
    }
    @Bindable
    public Boolean getVisibleLanzamientos() {
        return !lanzamientos.isEmpty();
    }
    @Bindable
    public ObservableField<Boolean> getIsGrid() {
        return isGrid;
    }

    public void setIsGrid(ObservableField<Boolean> isGrid) {
        this.isGrid = isGrid;
        notifyPropertyChanged(pe.com.distriluz.app.BR.isGrid);
    }

    @Bindable
    public ObservableList<AppObservable> getRecurrentes() {
        return recurrentes;
    }

    public void setRecurrentes(ObservableList<AppObservable> recurrentes) {
        this.recurrentes = recurrentes;
        notifyPropertyChanged(pe.com.distriluz.app.BR.recurrentes);
    }

    @Bindable
    public ObservableList<AppObservable> getDestacados() {
        return destacados;
    }

    public void setDestacados(ObservableList<AppObservable> destacados) {
        this.destacados = destacados;
        notifyPropertyChanged(pe.com.distriluz.app.BR.destacados);
    }

    @Bindable
    public ObservableList<AppObservable> getTodos() {
        return todos;
    }

    public void setTodos(ObservableList<AppObservable> todos) {
        this.todos = todos;
        notifyPropertyChanged(pe.com.distriluz.app.BR.todos);
    }

    @Bindable
    public ObservableList<AppObservable> getLanzamientos() {
        return lanzamientos;
    }

    public void setLanzamientos(ObservableList<AppObservable> lanzamientos) {
        this.lanzamientos = lanzamientos;
        notifyPropertyChanged(pe.com.distriluz.app.BR.lanzamientos);
    }

    public static class AppObservable extends BaseObservable {

        private String descripcion;
        private String tipo;
        private String code;
        private String nombreHost;
        private String dominio;
        private int vistaGeneral;
        private String ipAddress;
        private int destacadas;
        private String nombre;
        private double version;
        private int vistaUsuario;
        private String url;
        private String imagenUrl;
        private Boolean esLanzador;
        private int idEstado;
        private int idTipo;
        private boolean esapplanzamiento;
        private int id;
        private String browserDefault;
        private String key;

        @Bindable
        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            notifyPropertyChanged(pe.com.distriluz.app.BR.descripcion);
        }

        @Bindable
        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
            notifyPropertyChanged(pe.com.distriluz.app.BR.tipo);
        }

        @Bindable
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
            notifyPropertyChanged(pe.com.distriluz.app.BR.code);
        }

        @Bindable
        public String getNombreHost() {
            return nombreHost;
        }

        public void setNombreHost(String nombreHost) {
            this.nombreHost = nombreHost;
            notifyPropertyChanged(pe.com.distriluz.app.BR.nombreHost);
        }

        @Bindable
        public String getDominio() {
            return dominio;
        }

        public void setDominio(String dominio) {
            this.dominio = dominio;
            notifyPropertyChanged(pe.com.distriluz.app.BR.dominio);
        }

        @Bindable
        public int getVistaGeneral() {
            return vistaGeneral;
        }


        @Bindable
        public String getTextVistaGeneral() {
            return vistaGeneral+  "";
        }

        public void setVistaGeneral(int vistaGeneral) {
            this.vistaGeneral = vistaGeneral;
            notifyPropertyChanged(pe.com.distriluz.app.BR.vistaGeneral);
            notifyPropertyChanged(pe.com.distriluz.app.BR.textVistaGeneral);
        }

        @Bindable
        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            notifyPropertyChanged(pe.com.distriluz.app.BR.ipAddress);
        }

        @Bindable
        public int getDestacadas() {
            return destacadas;
        }

        public void setDestacadas(int destacadas) {
            this.destacadas = destacadas;
            notifyPropertyChanged(pe.com.distriluz.app.BR.destacadas);
        }

        @Bindable
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
            notifyPropertyChanged(pe.com.distriluz.app.BR.nombre);
        }

        @Bindable
        public double getVersion() {
            return version;
        }

        public void setVersion(double version) {
            this.version = version;
            notifyPropertyChanged(pe.com.distriluz.app.BR.version);
        }

        @Bindable
        public int getVistaUsuario() {
            return vistaUsuario;
        }

        public void setVistaUsuario(int vistaUsuario) {
            this.vistaUsuario = vistaUsuario;
            notifyPropertyChanged(pe.com.distriluz.app.BR.vistaUsuario);
        }

        @Bindable
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
            notifyPropertyChanged(pe.com.distriluz.app.BR.url);
        }

        @Bindable
        public String getImagenUrl() {
            return imagenUrl;
        }

        public void setImagenUrl(String imagenUrl) {
            this.imagenUrl = imagenUrl;
            notifyPropertyChanged(pe.com.distriluz.app.BR.imagenUrl);
        }

        @Bindable
        public Boolean getEsLanzador() {
            return esLanzador;
        }

        public void setEsLanzador(Boolean esLanzador) {
            this.esLanzador = esLanzador;
            notifyPropertyChanged(pe.com.distriluz.app.BR.esLanzador);
        }

        @Bindable
        public int getIdEstado() {
            return idEstado;
        }

        public void setIdEstado(int idEstado) {
            this.idEstado = idEstado;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idEstado);
        }

        @Bindable
        public int getIdTipo() {
            return idTipo;
        }

        public void setIdTipo(int idTipo) {
            this.idTipo = idTipo;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idTipo);
        }

        @Bindable
        public boolean getEsapplanzamiento() {
            return esapplanzamiento;
        }

        public void setEsapplanzamiento(boolean esapplanzamiento) {
            this.esapplanzamiento = esapplanzamiento;
            notifyPropertyChanged(pe.com.distriluz.app.BR.esapplanzamiento);
        }

        @Bindable
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
            notifyPropertyChanged(pe.com.distriluz.app.BR.id);
        }

        @Bindable
        public String getBrowserDefault() {
            return browserDefault;
        }

        public void setBrowserDefault(String browserDefault) {
            this.browserDefault = browserDefault;
            notifyPropertyChanged(pe.com.distriluz.app.BR.browserDefault);
        }

        @Bindable
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
            notifyPropertyChanged(pe.com.distriluz.app.BR.key);
        }

    }
}
