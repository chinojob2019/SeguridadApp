package pe.com.distriluz.data.net.acceso.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OpcionesMenuResponse{

	@SerializedName("opcionesMenu")
	private List<OpcionesMenuItem> opcionesMenu;

	public void setOpcionesMenu(List<OpcionesMenuItem> opcionesMenu){
		this.opcionesMenu = opcionesMenu;
	}

	public List<OpcionesMenuItem> getOpcionesMenu(){
		return opcionesMenu;
	}

	public class OpcionesMenuItem{

		@SerializedName("descripcion")
		private String descripcion;

		@SerializedName("idAplicacion")
		private int idAplicacion;

		@SerializedName("imagen")
		private String imagen;

		@SerializedName("tipoOpcion")
		private int tipoOpcion;

		@SerializedName("nombre")
		private String nombre;

		@SerializedName("url")
		private String url;

		@SerializedName("idVista")
		private int idVista;

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("descripcionTipoOpcion")
		private String descripcionTipoOpcion;

		@SerializedName("id")
		private int id;

		@SerializedName("orden")
		private int orden;

		@SerializedName("idOpcionMenuPadre")
		private int idOpcionMenuPadre;

		@SerializedName("nivel")
		private int nivel;

		@SerializedName("vista")
		private Vista vista;

		public void setDescripcion(String descripcion){
			this.descripcion = descripcion;
		}

		public String getDescripcion(){
			return descripcion;
		}

		public void setIdAplicacion(int idAplicacion){
			this.idAplicacion = idAplicacion;
		}

		public int getIdAplicacion(){
			return idAplicacion;
		}

		public void setImagen(String imagen){
			this.imagen = imagen;
		}

		public String getImagen(){
			return imagen;
		}

		public void setTipoOpcion(int tipoOpcion){
			this.tipoOpcion = tipoOpcion;
		}

		public int getTipoOpcion(){
			return tipoOpcion;
		}

		public void setNombre(String nombre){
			this.nombre = nombre;
		}

		public String getNombre(){
			return nombre;
		}

		public void setUrl(String url){
			this.url = url;
		}

		public String getUrl(){
			return url;
		}

		public void setIdVista(int idVista){
			this.idVista = idVista;
		}

		public int getIdVista(){
			return idVista;
		}

		public void setIdEstado(int idEstado){
			this.idEstado = idEstado;
		}

		public int getIdEstado(){
			return idEstado;
		}

		public void setDescripcionTipoOpcion(String descripcionTipoOpcion){
			this.descripcionTipoOpcion = descripcionTipoOpcion;
		}

		public String getDescripcionTipoOpcion(){
			return descripcionTipoOpcion;
		}

		public void setId(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}

		public void setOrden(int orden){
			this.orden = orden;
		}

		public int getOrden(){
			return orden;
		}

		public void setIdOpcionMenuPadre(int idOpcionMenuPadre){
			this.idOpcionMenuPadre = idOpcionMenuPadre;
		}

		public int getIdOpcionMenuPadre(){
			return idOpcionMenuPadre;
		}

		public void setNivel(int nivel){
			this.nivel = nivel;
		}

		public int getNivel(){
			return nivel;
		}

		public void setVista(Vista vista){
			this.vista = vista;
		}

		public Vista getVista(){
			return vista;
		}

	}
	public class Vista{

		@SerializedName("descripcion")
		private String descripcion;

		@SerializedName("ensamblado")
		private String ensamblado;

		@SerializedName("idEstado")
		private int idEstado;

		@SerializedName("comando")
		private String comando;

		@SerializedName("id")
		private int id;

		@SerializedName("nombre")
		private String nombre;

		@SerializedName("url")
		private String url;

		@SerializedName("clase")
		private String clase;

		public void setDescripcion(String descripcion){
			this.descripcion = descripcion;
		}

		public String getDescripcion(){
			return descripcion;
		}

		public void setEnsamblado(String ensamblado){
			this.ensamblado = ensamblado;
		}

		public String getEnsamblado(){
			return ensamblado;
		}

		public void setIdEstado(int idEstado){
			this.idEstado = idEstado;
		}

		public int getIdEstado(){
			return idEstado;
		}

		public void setComando(String comando){
			this.comando = comando;
		}

		public String getComando(){
			return comando;
		}

		public void setId(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}

		public void setNombre(String nombre){
			this.nombre = nombre;
		}

		public String getNombre(){
			return nombre;
		}

		public void setUrl(String url){
			this.url = url;
		}

		public String getUrl(){
			return url;
		}

		public void setClase(String clase){
			this.clase = clase;
		}

		public String getClase(){
			return clase;
		}


	}
}