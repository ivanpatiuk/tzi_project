package yarema.internetDistributors;

import yarema.applications.Application;

import java.util.*;

/**
 * Асбраткний клас "поширювач", який є спільним класом для комутатора
 * та роутера. Має базову айпі адресу пристроя та доступні айпі адреси
 * для пристроїв. Такоє має список підключених пристроїв.
 **/
public abstract class Distributor {
    private String baseIp;
    private Map<String, Boolean> availableIpMap;
    private List<Application> applications = new LinkedList<>();

    protected Distributor(String baseIp) {
        this.baseIp = baseIp;
        this.availableIpMap = initIpPool(baseIp);
    }

    /**
     * Цей метод потрібен для додавання (підключення) пристрою до поширювача
     * (роутера чи комутатора). Якщо пристрій підключений, на екран буде
     * виведене попередження.
     */
    protected boolean addApp(Application application){
        if(applications.contains(application)){
            System.out.println("This application is already connected!");
            return false;
        } else {
            application.setIpAddress(getAvailableIp());
            applications.add(application);
            return true;
        }
    }

    /**
     * Метод для симуляції пулу (доступних) IP-адресів. Створює 64 доступні
     * адреси для поточного поширювача.
     */
    protected Map<String, Boolean> initIpPool(String baseIp){
        Map<String, Boolean> map = new TreeMap<>();
        for(int i = 0; i < 64; ++i){
            map.put(baseIp+'.'+i, true);
        }
        return map;
    }

    /**
     * Цей метод відповідає за отримання доступної айпі адреси. Якщо
     * доступного IP нема, виводиться попередження та повертається
     * null.
     */
    protected String getAvailableIp(){
        for(var entry : availableIpMap.entrySet()){
            if(entry.getValue()){
                availableIpMap.put(entry.getKey(), false);
                return entry.getKey();
            }
        }
        System.out.println("No available IP addresses!");
        return null;
    }

    /**
     * Цей метод використовується для звільнення IP адреси.
     */
    protected boolean freeIpAddress(Application application){
        for(var entry : availableIpMap.entrySet()){
            if(entry.getKey().equals(application.getIpAddress())){
                availableIpMap.put(entry.getKey(), true);
            }
            return true;
        }
        System.out.println("IP address is already free!");
        return false;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public String getBaseIp() {
        return baseIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distributor that = (Distributor) o;
        return Objects.equals(availableIpMap, that.availableIpMap) && Objects.equals(applications, that.applications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableIpMap, applications);
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "availableIpMap=" + availableIpMap +
                ", applications=" + applications +
                '}';
    }
}
