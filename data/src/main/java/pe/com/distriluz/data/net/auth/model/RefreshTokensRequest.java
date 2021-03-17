package pe.com.distriluz.data.net.auth.model;

import com.google.gson.annotations.SerializedName;

public class RefreshTokensRequest {

    private UsuarioId usuario;
    @SerializedName("refreshToken")
    private String refreshToken;

    public RefreshTokensRequest(String refreshToken, UsuarioId usuario) {
        this.refreshToken = refreshToken;
        this.usuario = usuario;
    }

    public UsuarioId getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioId usuario) {
        this.usuario = usuario;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static class UsuarioId {

        private int id;

        public UsuarioId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}