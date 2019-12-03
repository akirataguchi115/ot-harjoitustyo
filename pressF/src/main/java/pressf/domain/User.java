package pressf.domain;

public class User {

    private String username;
    private String pwrd;

    public User(String username, String pwrd) {
        this.username = username;
        this.pwrd = pwrd;
    }

    public String getUsername() {
        return username;
    }

    public String getPwrd() {
        return pwrd;
    }

}
