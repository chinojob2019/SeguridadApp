package pe.com.distriluz.domain.model;

public class DetailUser {

	private Corporativos corporativos;
	private Personales personales;
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

	public static class Corporativos{

		private String tipousuario;
		private String empresa;
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


	public static class Personales{

		private String fechanacimiento;
		private String apellidomaterno;
		private String direccion;
		private String apellidopaterno;
		private String login;
		private String telefono;
		private String nombre;
		private String email;
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

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}
	}
}