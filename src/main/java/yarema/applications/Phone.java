package yarema.applications;

import java.util.Objects;

/**
 * Клас телефон, успадковує клас "пристрій". Має email телефона,
 * та пароль.
 */
public class Phone extends Application{
    private String email;
    private String password;

    public Phone() {
    }

    public Phone(String appName, String email, String password) {
        super(appName);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(email, phone.email) && Objects.equals(password, phone.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
