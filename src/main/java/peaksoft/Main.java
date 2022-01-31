package peaksoft;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static UserService user = new UserServiceImpl();
    static UserServiceImpl userService = new UserServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            sout();
            int ifNum = scanner.nextInt();
            switch (ifNum) {
                case 1:
                    user.createUsersTable();
                    break;
                case 2:
                    user.dropUsersTable();
                    break;
                case 3:
                    try {
                        scanner.nextLine();
                        System.out.println("Напишите имя пользователя:");
                        String name = scanner.nextLine();
                        System.out.println("Напишите фамилию пользователя:");
                        String lastName = scanner.nextLine();
                        System.out.println("Напишите возраст пользователя:");
                        byte age = scanner.nextByte();
                        user.saveUser(name, lastName, age);
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Напишите идентификатор пользователя:");
                    int id = scanner.nextInt();
                    user.removeUserById(id);
                    break;
                case 5:
                    user.getAllUsers().forEach(System.out::println);
                    break;
                case 6:
                    user.cleanUsersTable();
            }
        }
    }

    public static void sout() {
        System.out.println(" 1 басып таблица тузунуз ");
        System.out.println(" 2 басып таблицаны очурунуз ");
        System.out.println(" 3 басып таблицаны сактаныз ");
        System.out.println(" 4 басып таблицанын ичинен id менне очурунуз ");
        System.out.println(" 5 басып таблицанын корсотунуз ");
        System.out.println(" 6 басып таблицанын ичнин тазаланыз ");
    }
}

