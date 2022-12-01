// Абстрактний клас, який успадковують  класи CustomDirectory
// та CustomFile для симуляції роботи з реєстром файлів та
// директорій за рівнем важливості

package entity;

import enums.Importance;

public abstract class BaseCustom {
    private String path;
    private Importance importance;

    protected BaseCustom(String path, Importance importance) {
        this.path = path;
        this.importance = importance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }
}
/****************************************/