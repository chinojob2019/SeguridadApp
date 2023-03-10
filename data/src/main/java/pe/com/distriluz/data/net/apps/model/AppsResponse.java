package pe.com.distriluz.data.net.apps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AppsResponse{

	@SerializedName("aplicaciones")
	private Aplicaciones aplicaciones;

	public void setAplicaciones(Aplicaciones aplicaciones){
		this.aplicaciones = aplicaciones;
	}

	public Aplicaciones getAplicaciones(){
		return aplicaciones;
	}


	public  class Aplicaciones{

		@SerializedName("recurrentes")
		private List<Appitem> recurrentes;

		@SerializedName("destacados")
		private List<Appitem> destacados;

		@SerializedName("todos")
		private List<Appitem> todos;

		@SerializedName("lanzamientos")
		private List<Appitem> lanzamientos;

		public void setRecurrentes(List<Appitem> recurrentes){
			this.recurrentes = recurrentes;
		}

		public List<Appitem> getRecurrentes(){
			return recurrentes;
		}

		public void setDestacados(List<Appitem> destacados){
			this.destacados = destacados;
		}

		public List<Appitem> getDestacados(){
			return destacados;
		}

		public void setTodos(List<Appitem> todos){
			this.todos = todos;
		}

		public List<Appitem> getTodos(){
			return todos;
		}

		public void setLanzamientos(List<Appitem> lanzamientos){
			this.lanzamientos = lanzamientos;
		}

		public List<Appitem> getLanzamientos(){
			return lanzamientos;
		}
	}

	public static class DesplieguesItem{

		@SerializedName("urlEmpresa")
		private String urlEmpresa;

		@SerializedName("nombreEmpresa")
		private String nombreEmpresa;

		public void setUrlEmpresa(String urlEmpresa){
			this.urlEmpresa = urlEmpresa;
		}

		public String getUrlEmpresa(){
			return urlEmpresa;
		}

		public void setNombreEmpresa(String nombreEmpresa){
			this.nombreEmpresa = nombreEmpresa;
		}

		public String getNombreEmpresa(){
			return nombreEmpresa;
		}

	}

	public static class Appitem{


		@SerializedName("id")
		private int id;

		@SerializedName("nombre")
		private String nombre;

		@SerializedName("descripcion")
		private String descripcion;

		@SerializedName("esLanzador")
		private Boolean esLanzador;

		@SerializedName("url")
		private String url;

		@SerializedName("key")
		private String key;

		@SerializedName("code")
		private String code;

		@SerializedName("idTipoAplicacion")
		private int idTipo;

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("imagenUrl")
		private String imagenUrl;

		@SerializedName("destacadas")
		private int destacadas;

		@SerializedName("vistaUsuario")
		private int vistaUsuario;

		@SerializedName("vistaGeneral")
		private int vistaGeneral;

		@SerializedName("esAppLanzamiento")
		private boolean esapplanzamiento;

		@SerializedName("despliegues")
		private List<DesplieguesItem> despliegues;

		public void setDespliegues(List<DesplieguesItem> despliegues){
			this.despliegues = despliegues;
		}

		public List<DesplieguesItem> getDespliegues(){
			return despliegues;
		}

		public void setDescripcion(String descripcion){
			this.descripcion = descripcion;
		}

		public String getDescripcion(){
			return descripcion;
		}


		public void setCode(String code){
			this.code = code;
		}

		public String getCode(){
			return code;
		}

		public void setVistaGeneral(int vistaGeneral){
			this.vistaGeneral = vistaGeneral;
		}

		public int getVistaGeneral(){
			return vistaGeneral;
		}

		public void setDestacadas(int destacadas){
			this.destacadas = destacadas;
		}

		public int getDestacadas(){
			return destacadas;
		}

		public void setNombre(String nombre){
			this.nombre = nombre;
		}

		public String getNombre(){
			return nombre;
		}

		public void setVistaUsuario(int vistaUsuario){
			this.vistaUsuario = vistaUsuario;
		}

		public int getVistaUsuario(){
			return vistaUsuario;
		}

		public void setUrl(String url){
			this.url = url;
		}

		public String getUrl(){
			return url;
		}

		public void setImagenUrl(String imagenUrl){
			this.imagenUrl = imagenUrl;
		}

		public String getImagenUrl(){
			return imagenUrl;
		}

		public void setEsLanzador(Boolean esLanzador){
			this.esLanzador = esLanzador;
		}

		public Boolean getEsLanzador(){
			return esLanzador;
		}

		public void setIdEstado(int idEstado){
			this.idEstado = idEstado;
		}

		public int getIdEstado(){
			return idEstado;
		}

		public void setIdTipo(int idTipo){
			this.idTipo = idTipo;
		}

		public int getIdTipo(){
			return idTipo;
		}

		public void setEsapplanzamiento(boolean esapplanzamiento){
			this.esapplanzamiento = esapplanzamiento;
		}

		public boolean getEsapplanzamiento(){
			return esapplanzamiento;
		}

		public void setId(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}

		public void setKey(String key){
			this.key = key;
		}

		public String getKey(){
			return key;
		}
	}
}