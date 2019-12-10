package pressf.domain;

public class User {

    private String username;
    private String pwrd;

    /**
     * Creates an instance of User with given parameters.
     * @param username username
     * @param pwrd password
     */
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
