// Клас, який успадковує BaseCustom та відповідає за реалізацію
// роботи з файлом. Містить статичну змінну filesPassword
// яка є спільним паролем на всі файли

package entity;

import enums.Importance;

public class CustomFile extends BaseCustom {
    private static UUID filesPassword = new UUID("admin");

    public CustomFile(String path, Importance importance) {
        super(path, importance);

    }

    public static boolean checkPassword(UUID filesPassword) {
        if(filesPassword.getPassword().equals(filesPassword.getPassword())){
            return true;
        }
        else {
            return false;
        }
    }
}
/****************************************/
