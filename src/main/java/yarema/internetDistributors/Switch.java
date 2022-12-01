package yarema.internetDistributors;

import yarema.applications.PC;

/**
 * Клас комутатор. Успадковує абстрактний клас поширювач. На відміну
 * від роутера дозволяє роботу лише з комп'ютерами
 */
public class Switch extends Distributor{

    public Switch(String baseIp) {
        super(baseIp);
    }

    /**
     * Метод дозволяє під'єднувати до комутатора лише комп'ютери
     */
    public boolean connectPC(final PC pc){
        return addApp(pc);
    }
}
