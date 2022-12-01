// Клас, який відповідає за запуск архівації в ручному чи автоматичному
// режимі. У разі автоматичного запуску не вимагає від користувача ніяких
// додаткових дій. При ручному вимагає взаємодії з консоллю середовища

package service;

import entity.CustomDirectory;
import entity.CustomFile;
import entity.UUID;
import enums.RunMode;
import enums.Importance;
import java.io.File;
import java.util.List;

public class Runner {

    private final static ZipArchiever zipArchiever = new ZipArchiever();

    private static void runAutoMode(final UUID filesPassword, final UUID directoriesPassword) {
        final List<CustomDirectory> customDirectories = SeverityStorage.getDirectoriesStorage();
        final List<CustomFile> customFiles = SeverityStorage.getFilesStorage();

        if(CustomFile.checkPassword(filesPassword) && CustomDirectory.checkPassword(directoriesPassword)) {
            try {
                zipDirectories(customDirectories);
                zipFiles(customFiles);
            } catch (Exception e) {
                System.out.println("Unexpected exception");
                e.printStackTrace();
            }
            System.out.println("Successfull archieving data");
        } else {
            System.out.println("Wrong password!");
        }
    }

    private static void runManualMode() {
        ManualRunner.runInterface();
    }

    public static void run(final RunMode runMode, final String files, final String directories) {
        switch (runMode) {
            case AUTO -> {
                final UUID filesPassword = files.equals("default") ? new UUID("admin") : new UUID(files);
                final UUID directoriesPassword = directories.equals("default") ? new UUID("admin") : new UUID(directories);
                runAutoMode(filesPassword, directoriesPassword);
            }
            case MANUAL -> runManualMode();
            default -> throw new RuntimeException();
        }
    }

    public static void zipDirectories(final List<CustomDirectory> customDirectories) {
        customDirectories.stream().filter(dir -> dir.getImportance() == Importance.IMPORTANT).forEach(dir -> {
            final File file = new File(dir.getPath());
            final String zipDirPath = SeverityStorage.getDefaultStoragePath() + file.getName() + ".zip";
            zipArchiever.zipDirectory(file, zipDirPath);
        });
    }

    public static void zipFiles(final List<CustomFile> customFiles) {
        customFiles.stream().filter(cFile -> cFile.getImportance() == Importance.IMPORTANT).forEach(cFile -> {
            final File file = new File(cFile.getPath());
            final String zipFilePath = SeverityStorage.getDefaultStoragePath() + file.getName() + ".zip";
            zipArchiever.zipSingleFile(file, zipFilePath);
        });
    }
}
/****************************************/

