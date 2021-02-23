package pe.com.distriluz.data.net.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailUserResponse2 {

	@SerializedName("data")
	private Data data;

	@SerializedName("resultcode")
	private int resultcode;

	@SerializedName("mensaje")
	private String mensaje;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setResultcode(int resultcode){
		this.resultcode = resultcode;
	}

	public int getResultcode(){
		return resultcode;
	}

	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje(){
		return mensaje;
	}

	public static class Data{

		@SerializedName("post")
		private List<ShortPostItemResponse> post;

		@SerializedName("info")
		private InfoUserResponse info;

		public void setPost(List<ShortPostItemResponse> post){
			this.post = post;
		}

		public List<ShortPostItemResponse> getPost(){
			return post;
		}

		public void setInfo(InfoUserResponse info){
			this.info = info;
		}

		public InfoUserResponse getInfo(){
			return info;
		}
	}

	public static class InfoUserResponse {

		@SerializedName("follow_me")
		private int followMe;

		@SerializedName("total_comments")
		private int totalComments;

		@SerializedName("firstname")
		private String firstname;

		@SerializedName("picture_perfil")
		private String picturePerfil;

		@SerializedName("id_user")
		private int idUser;

		@SerializedName("total_likes")
		private int totalLikes;

		@SerializedName("follow")
		private int follow;

		@SerializedName("lastname")
		private String lastname;

		@SerializedName("id_rol")
		private int idRol;

		@SerializedName("id_register")
		private long idRegister;

		@SerializedName("usernames")
		private String usernames;

		@SerializedName("user_arroba")
		private String userArroba;

		@SerializedName("seoname")
		private String seoname;

		@SerializedName("email")
		private String email;

		@SerializedName("username")
		private String username;

		public void setFollowMe(int followMe){
			this.followMe = followMe;
		}

		public int getFollowMe(){
			return followMe;
		}

		public void setTotalComments(int totalComments){
			this.totalComments = totalComments;
		}

		public int getTotalComments(){
			return totalComments;
		}

		public void setFirstname(String firstname){
			this.firstname = firstname;
		}

		public String getFirstname(){
			return firstname;
		}

		public void setPicturePerfil(String picturePerfil){
			this.picturePerfil = picturePerfil;
		}

		public String getPicturePerfil(){
			return picturePerfil;
		}

		public void setIdUser(int idUser){
			this.idUser = idUser;
		}

		public int getIdUser(){
			return idUser;
		}

		public void setTotalLikes(int totalLikes){
			this.totalLikes = totalLikes;
		}

		public int getTotalLikes(){
			return totalLikes;
		}

		public void setFollow(int follow){
			this.follow = follow;
		}

		public int getFollow(){
			return follow;
		}

		public void setLastname(String lastname){
			this.lastname = lastname;
		}

		public String getLastname(){
			return lastname;
		}

		public void setIdRol(int idRol){
			this.idRol = idRol;
		}

		public int getIdRol(){
			return idRol;
		}

		public void setIdRegister(long idRegister){
			this.idRegister = idRegister;
		}

		public long getIdRegister(){
			return idRegister;
		}

		public void setUsernames(String usernames){
			this.usernames = usernames;
		}

		public String getUsernames(){
			return usernames;
		}

		public void setUserArroba(String userArroba){
			this.userArroba = userArroba;
		}

		public String getUserArroba(){
			return userArroba;
		}

		public void setSeoname(String seoname){
			this.seoname = seoname;
		}

		public String getSeoname(){
			return seoname;
		}

		public void setEmail(String email){
			this.email = email;
		}

		public String getEmail(){
			return email;
		}

		public void setUsername(String username){
			this.username = username;
		}

		public String getUsername(){
			return username;
		}
	}

	public static class ShortPostItemResponse {

		@SerializedName("pub_id")
		private int pubId;

		@SerializedName("total_comments")
		private int totalComments;

		@SerializedName("picture_big")
		private String pictureBig;

		@SerializedName("total_likes")
		private int totalLikes;

		@SerializedName("title_pub")
		private String titlePub;

		public void setPubId(int pubId){
			this.pubId = pubId;
		}

		public int getPubId(){
			return pubId;
		}

		public void setTotalComments(int totalComments){
			this.totalComments = totalComments;
		}

		public int getTotalComments(){
			return totalComments;
		}

		public void setPictureBig(String pictureBig){
			this.pictureBig = pictureBig;
		}

		public String getPictureBig(){
			return pictureBig;
		}

		public void setTotalLikes(int totalLikes){
			this.totalLikes = totalLikes;
		}

		public int getTotalLikes(){
			return totalLikes;
		}

		public void setTitlePub(String titlePub){
			this.titlePub = titlePub;
		}

		public String getTitlePub(){
			return titlePub;
		}
	}
}