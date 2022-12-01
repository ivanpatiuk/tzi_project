package entity;

public class UUID {
    private String password;

    public UUID(String password) {
        this.password =
                password.substring(0, password.length()/2)
                + password.hashCode()
                + password.substring(password.length()/2);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
