// Головний клас, який запускає програму

import service.Runner;
import service.SeverityStorage;

import static enums.RunMode.AUTO;
import static enums.RunMode.MANUAL;

public class Application {
    public static void main(String[] args) {
        SeverityStorage.simulateStorage();
        Runner.run(MANUAL, null, null);
    }
}
/****************************************/