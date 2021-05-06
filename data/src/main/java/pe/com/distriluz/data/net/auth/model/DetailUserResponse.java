package pe.com.distriluz.data.net.auth.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DetailUserResponse {

    @SerializedName("corporativos")
    private Corporativos corporativos;

    @SerializedName("personales")
    private Personales personales;

    @SerializedName("id")
    private int id;

    public Corporativos getCorporativos() {
        return corporativos;
    }

    public void setCorporativos(Corporativos corporativos) {
        this.corporativos = corporativos;
    }

    public Personales getPersonales() {
        return personales;
    }

    public void setPersonales(Personales personales) {
        this.personales = personales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Corporativos {

        @SerializedName("tipousuario")
        private String tipousuario;

        @SerializedName("empresa")
        private String empresa;

        @SerializedName("unidadnegocio")
        private String unidadnegocio;

        public String getTipousuario() {
            return tipousuario;
        }

        public void setTipousuario(String tipousuario) {
            this.tipousuario = tipousuario;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        public String getUnidadnegocio() {
            return unidadnegocio;
        }

        public void setUnidadnegocio(String unidadnegocio) {
            this.unidadnegocio = unidadnegocio;
        }
    }


    public static class Personales {

        @SerializedName("fechaNacimiento")
        private String fechanacimiento;

        @SerializedName("apellidoMaterno")
        private String apellidomaterno;

        @SerializedName("direccion")
        private String direccion;

        @SerializedName("apellidoPaterno")
        private String apellidopaterno;

        @SerializedName("login")
        private String login;

        @SerializedName("telefono")
        private String telefono;

        @SerializedName("nombre")
        private String nombre;

        @SerializedName("email")
        private String email;

        @SerializedName("tipoPersona")
        private String tipopersona;

        @SerializedName("foto")
        private String foto;

        public String getFechanacimiento() {
            return fechanacimiento;
        }

        public void setFechanacimiento(String fechanacimiento) {
            this.fechanacimiento = fechanacimiento;
        }

        public String getApellidomaterno() {
            return apellidomaterno;
        }

        public void setApellidomaterno(String apellidomaterno) {
            this.apellidomaterno = apellidomaterno;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getApellidopaterno() {
            return apellidopaterno;
        }

        public void setApellidopaterno(String apellidopaterno) {
            this.apellidopaterno = apellidopaterno;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTipopersona() {
            return tipopersona;
        }

        public void setTipopersona(String tipopersona) {
            this.tipopersona = tipopersona;
        }
    }
}