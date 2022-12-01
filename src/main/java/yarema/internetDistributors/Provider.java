package yarema.internetDistributors;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Клас постачальник інтернету (провайдер). Має назву (компанії),
 * базовий айпі провайдера, та список користувачів (пристроїв, якими
 * я комутатори та маршуризатори).
 */
public class Provider {
    private String name;
    private String providerIp;
    private List<Distributor> distributors = new LinkedList<>();

    public Provider() {
    }

    public Provider(String name, String providerIp, List<Distributor> distributors) {
        this.name = name;
        this.providerIp = providerIp;
        this.distributors = distributors;
    }

    /**
     * Цей метод використовується для додавання поширювача до
     * списку поширювачів (користувачів)
     */
    public boolean addDistributor(final Distributor distributor){
        if(distributors.contains(distributor)){
            System.out.println("This distributor is already connected!");
            return false;
        } else {
            distributors.add(distributor);
            return true;
        }
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(LinkedList<Distributor> distributors) {
        this.distributors = distributors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderIp() {
        return providerIp;
    }

    public void setProviderIp(String providerIp) {
        this.providerIp = providerIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(distributors, provider.distributors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributors);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", distributors=" + distributors +
                '}';
    }


}
