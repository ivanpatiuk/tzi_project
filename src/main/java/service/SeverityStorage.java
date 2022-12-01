// Клас, який симулює реєстр доступних файлів та директорій для відстеження.
// Зберігає список типів CustomDirectory та CustomFile для відстеження
// важливості файлів чи директорій. За замовчуванням, ініціалізується однією
// важливою та неважливою папками, а також трьома важливими файлами та одним неважливим.

package service;

import entity.CustomDirectory;
import entity.CustomFile;
import enums.Importance;
import java.util.ArrayList;
import java.util.List;

public class SeverityStorage {
    private static final String defaultStoragePath = "/Patiuk/Storage/";
    private static List<CustomDirectory> directoriesStorage = new ArrayList<>();
    private static List<CustomFile> filesStorage = new ArrayList<>();

    private SeverityStorage() {
    }

    private static void initDirectoriesStorage() {
        addDirectory(new CustomDirectory("/Patiuk/TestFolder/Directory1", Importance.IMPORTANT));
        addDirectory(new CustomDirectory("/Patiuk/TestFolder/Directory2", Importance.UNIMPORTANT));
    }

    private static void initFilesStorage() {
        addFile(new CustomFile("/Patiuk/TestFolder/file1.txt", Importance.IMPORTANT));
        addFile(new CustomFile("/Patiuk/TestFolder/file2.txt", Importance.IMPORTANT));
        addFile(new CustomFile("/Patiuk/TestFolder/file3.txt", Importance.UNIMPORTANT));
        addFile(new CustomFile("/Patiuk/TestFolder/file4.txt", Importance.IMPORTANT));
    }

    public static void simulateStorage() {
        initDirectoriesStorage();
        initFilesStorage();
    }

    public static void addDirectory(final CustomDirectory customDirectory) {
        if (directoriesStorage.stream().noneMatch(dir -> dir.getPath().equals(customDirectory.getPath()))) {
            directoriesStorage.add(customDirectory);
        } else {
            System.out.println("Warning! Such a direcotry currently is in SeverityStorage." +
                    "Please, use method \"updateSeverity\" to change the severity");
        }
    }

    public static void addFile(final CustomFile customFile) {
        if (filesStorage.stream().noneMatch(file -> file.getPath().equals(customFile.getPath()))) {
            filesStorage.add(customFile);
        } else {
            System.out.println("Warning! Such a file currently is in SeverityStorage." +
                    "Please, use method \"updateSeverity\" to change the severity");
        }
    }

    public static void updateSeverity(final String path, final Importance importance) {
        try {
            directoriesStorage.stream().filter(baseCustom -> baseCustom.getPath().equals(path)).findFirst().ifPresent(baseCustom -> baseCustom.setImportance(importance));
            filesStorage.stream().filter(baseCustom -> baseCustom.getPath().equals(path)).findFirst().ifPresent(baseCustom -> baseCustom.setImportance(importance));
        } catch (Exception e) {
            System.out.println("Unexpected exception");
            e.printStackTrace();
        }
    }

    public static List<CustomDirectory> getDirectoriesStorage() {
        return directoriesStorage;
    }

    public static List<CustomFile> getFilesStorage() {
        return filesStorage;
    }

    public static String getDefaultStoragePath() {
        return defaultStoragePath;
    }
}
/****************************************/

