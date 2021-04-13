package pe.com.distriluz.data.net.auth.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("usuario")
	private Usuario usuario;
	@SerializedName("refreshToken")
	private String refreshToken;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getrefreshToken() {
		return refreshToken;
	}

	public void setrefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public static class Usuario{

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("id")
		private int id;

		@SerializedName("login")
		private String login;

		@SerializedName("fechaUltimaSesion")
		private String fechaUltimaSesion;

		@SerializedName("nombre")
		private String nombre;

		@SerializedName("idPersona")
		private int idPersona;

		@SerializedName("email")
		private String email;

		@SerializedName("esAd")
		private int esAd;

		public int getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(int idEstado) {
			this.idEstado = idEstado;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getFechaUltimaSesion() {
			return fechaUltimaSesion;
		}

		public void setFechaUltimaSesion(String fechaUltimaSesion) {
			this.fechaUltimaSesion = fechaUltimaSesion;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getIdPersona() {
			return idPersona;
		}

		public void setIdPersona(int idPersona) {
			this.idPersona = idPersona;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getEsAd() {
			return esAd;
		}

		public void setEsAd(int esAd) {
			this.esAd = esAd;
		}
	}
}