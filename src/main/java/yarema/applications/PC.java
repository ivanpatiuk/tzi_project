package yarema.applications;

import java.util.Objects;

/**
 * Клас комп'ютер, успадковує клас "пристрій". Має SSID (назву комп'ютера),
 * та пароль.
 */
public class PC extends  Application{
    private String SSID;
    private String password;

    public PC() {
    }

    public PC(String appName, String SSID, String password) {
        super(appName);
        this.SSID = SSID;
        this.password = password;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
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
        PC pc = (PC) o;
        return Objects.equals(SSID, pc.SSID) && Objects.equals(password, pc.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSID, password);
    }

    @Override
    public String toString() {
        return "PC{" +
                "SSID='" + SSID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
