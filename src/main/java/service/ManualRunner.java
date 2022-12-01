// Клас, який відповідає за роботу з інтерфейсом ручного режиму
// та ручного архівування даних. Потребує введеня шляху до файлу
// чи директорії а також їх паролей в консолі.

package service;

import entity.CustomDirectory;
import entity.CustomFile;
import entity.UUID;
import enums.Importance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualRunner {

    private final static Scanner scanner = new Scanner(System.in);

    public static void runInterface() {
        while (true) {
            printMenu();
            switch (scanKey()) {
                case 1 -> archieveDirectoriesHandler();
                case 2 -> archieveFilesHandler();
                case 3 -> updateImportance();
                default -> {
                    return;
                }
            }

        }
    }

    private static void printMenu() {
        System.out.println("------------------------------------------");
        System.out.println("| Choose option:                         |");
        System.out.println("| 1) Archieve directories                |");
        System.out.println("| 2) Archieve files                      |");
        System.out.println("| 3) Update severity                     |");
        System.out.println("| 0) Exit                                |");
        System.out.println("------------------------------------------");
    }

    private static int scanKey() {
        int key;
        while (true)
            try {
                System.out.print("Enter option: ");
                key = Integer.parseInt(scanner.nextLine());
                if (0 <= key && key <= 3) {
                    return key;
                }
            } catch (Exception e) {
                System.out.println("Please, type 0,1,2 or 3");
            }
    }

    private static void archieveDirectoriesHandler() {
        final List<CustomDirectory> directoryList = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Enter 'STOP' to stop entering directories");
                System.out.println("Enter 'EXIT' to exit from archieving");
                System.out.print("Enter dir path to archieve: ");

                final String path = scanner.nextLine();
                if (path.equals("EXIT")) {
                    return;
                }
                if (path.equals("STOP")) {
                    break;
                }
                System.out.print("Enter importance (IMPORTANT, UNIMPORTANT): ");
                final Importance importance = Importance.valueOf(scanner.nextLine().toUpperCase());
                final CustomDirectory customDirectory = new CustomDirectory(path, importance);
                directoryList.add(customDirectory);
            } catch (IllegalArgumentException e) {
                System.out.println("Please, try again");
            }
        }
        System.out.print("Enter password: ");
        final UUID password = new UUID(scanner.nextLine());
        if (CustomDirectory.checkPassword(password)) {
            Runner.zipDirectories(directoryList);
        } else {
            System.out.println("Wrong password!");
        }
    }

    private static void archieveFilesHandler() {
        final List<CustomFile> customFiles = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Enter 'STOP' to stop entering files");
                System.out.println("Enter 'EXIT' to exit from archieving");
                System.out.print("Enter file path to archieve: ");

                final String path = scanner.nextLine();
                if (path.equals("EXIT")) {
                    return;
                }
                if (path.equals("STOP")) {
                    break;
                }
                System.out.print("\nEnter importance (IMPORTANT, UNIMPORTANT): ");
                final Importance importance = Importance.valueOf(scanner.nextLine().toUpperCase());
                System.out.print("Enter password: ");
                final String password = scanner.nextLine();
                final CustomFile customFile = new CustomFile(path, importance);
                customFiles.add(customFile);
            } catch (IllegalArgumentException e) {
                System.out.println("Please, try again");
            }
        }
        System.out.print("Enter password: ");
        final UUID password = new UUID(scanner.nextLine());
        if (CustomFile.checkPassword(password)) {
            Runner.zipFiles(customFiles);
        } else {
            System.out.println("Wrong password!");
        }
    }

    private static void updateImportance() {
        while (true) {
            try {
                final String path = scanner.nextLine();
                if (path.equals("EXIT")) {
                    return;
                }
                final Importance importance = Importance.valueOf(scanner.nextLine().toUpperCase());
                SeverityStorage.updateSeverity(path, importance);
            } catch (Exception e) {
                System.out.println("Please, try again");
            }
        }
    }
}
/****************************************/
