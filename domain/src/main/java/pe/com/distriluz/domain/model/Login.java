package pe.com.distriluz.domain.model;

import java.util.List;

public class Login {
    private String thirdCode;
    private String country;
    private boolean agent;
    private int tptid;
    private String tpName;
    private List<String> roles;
    private boolean client;
    private String userType;
    private String office;
    private String login;
    private String token;

    public Login(String thirdCode, String country, boolean agent, int tptid, String tpName, List<String> roles, boolean client, String userType, String office, String login, String token) {
        this.thirdCode = thirdCode;
        this.country = country;
        this.agent = agent;
        this.tptid = tptid;
        this.tpName = tpName;
        this.roles = roles;
        this.client = client;
        this.userType = userType;
        this.office = office;
        this.login = login;
        this.token = token;
    }

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAgent() {
        return agent;
    }

    public void setAgent(boolean agent) {
        this.agent = agent;
    }

    public int getTptid() {
        return tptid;
    }

    public void setTptid(int tptid) {
        this.tptid = tptid;
    }

    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
