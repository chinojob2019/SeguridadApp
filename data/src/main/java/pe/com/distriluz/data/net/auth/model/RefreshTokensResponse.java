package pe.com.distriluz.data.net.auth.model;
import com.google.gson.annotations.SerializedName;

public class RefreshTokensResponse {

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("refreshToken")
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
