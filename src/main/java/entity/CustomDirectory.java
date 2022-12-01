// Клас, який успадковує BaseCustom та відповідає за реалізацію
// роботи з директоріями. Містить статичну змінну directoriesPassword
// яка є спільним паролем на всі директорії

package entity;

import enums.Importance;


public class CustomDirectory extends BaseCustom {
    private static UUID directoriesPassword = new UUID("admin");

    public CustomDirectory(String path, Importance importance) {
        super(path, importance);

    }

    public static boolean checkPassword(UUID filesPassword) {
        return filesPassword.getPassword().equals(directoriesPassword.getPassword());
    }

}
/****************************************/
