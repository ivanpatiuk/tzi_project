package yarema.applications;

import java.util.Objects;

/**
 * Асбраткний клас пристроїв. Має айпі адресу та назву пристрою.
 */
public abstract class Application {
    private String ipAddress;
    private String appName;

    public Application() {
    }

    public Application(String appName) {
        this.appName = appName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(ipAddress, that.ipAddress) && Objects.equals(appName, that.appName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, appName);
    }

    @Override
    public String toString() {
        return "Application{" +
                "ipAddress='" + ipAddress + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
