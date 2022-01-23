package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static UserServiceImpl userService = new UserServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            sout();
            int num = scanner.nextInt();
            if (num==1) {
                userService.createUsersTable();
            }
                 if (num==2) {
                     userService.dropUsersTable();
                 }
                 if (num==3){
                     System.out.println("Маалымат киргизиниз:");
                     System.out.println("name");
                     String name = sc.nextLine();
                     System.out.println("last_name");
                     String last_name = sc.nextLine();
                     System.out.println("age");
                     byte age = sc.nextByte();
                     userService.saveUser(name, last_name, age);
                }
                 if (num==4){
                    long j = sc.nextLong();
                    userService.removeUserById(j);
                }
                 if (num==5) {
                     System.out.println(userService.getAllUsers());
                 }
                 if (num==6){
                     userService.cleanUsersTable();
            }
                 else {
                     System.out.println("");
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
