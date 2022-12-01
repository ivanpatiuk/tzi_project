package yarema.service;

import yarema.applications.Application;
import yarema.applications.PC;
import yarema.applications.Phone;
import yarema.applications.TV;
import yarema.internetDistributors.Distributor;
import yarema.internetDistributors.Provider;
import yarema.internetDistributors.Router;
import yarema.internetDistributors.Switch;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class NetworkService {

    public static List<String> usedBaseIp = new LinkedList<>();

    /**
     * Цей метод використовується для симуляції (ініціалізації) мережі
     * Створює декілька комп'ютерів, телефонів та телевізорів, та підключає їх
     * до роутерів чи комутаторів (у випадку комп'ютерів).
     */
    public Provider initNetwork() {
        try {
            String providerIp = "172.164";
            PC pc1 = new PC("Desktop1", "TP-Link_F0001", "admin");
            PC pc2 = new PC("Desktop2", "TP-Link_F0002", "admin");
            PC pc3 = new PC("Desktop3", "TP-Link_F0003", "admin");
            TV tv1 = new TV("Samsung1");
            TV tv2 = new TV("Lenovo1");
            Phone phone1 = new Phone("Phone1", "email1@gmail.com", "admin");
            Phone phone2 = new Phone("Phone1", "email2@gmail.com", "admin");
            Phone phone3 = new Phone("Phone1", "email3@gmail.com", "admin");

            Switch switch1 = new Switch(providerIp + ".1");
            switch1.connectPC(pc1);
            switch1.connectPC(pc2);

            Router router1 = new Router(providerIp + ".2");
            router1.connectApp(pc3);
            router1.connectApp(tv1);
            router1.connectApp(tv2);
            router1.connectApp(phone1);
            router1.connectApp(phone2);
            router1.connectApp(phone3);

            List<Distributor> distributors = new LinkedList<>();
            distributors.add(switch1);
            distributors.add(router1);

            Provider provider = new Provider("WeNet", providerIp, distributors);
            return provider;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Метод відповідає за виведення на екран логічної структури мережі.
     */
    public static void testPrintNetwork(Provider provider){
        System.out.println(provider.getProviderIp() + " ("+provider.getName()+")");
        for (Distributor distributor : provider.getDistributors()){
            System.out.println("     |");
            System.out.println("     |____" + distributor.getBaseIp() + " ("+distributor.getClass().getSimpleName()+")");
            for (Application application : distributor.getApplications()){
                System.out.println("              |____" + application.getIpAddress() + " ("+application.getAppName()+")");
            }
        }
    }
}
