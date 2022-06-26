package com.company;

import com.company.model.Gender;
import com.company.model.User;
import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /** 1) Жаны проект тузунуз.
        2) company деген пакеттин ичине 3 жаны пакет тузунуз - model, service, dao.
        3) model пакеттин ичине User деген класс тузунуз, свойствалары - id, name, age, Gender, Genderди enum кылып башка пакетке тузуп койсонуз болот. id бул жон эле userдин уникалдуу свойствасы болот.
        4) dao пакеттин ичине UserDao деген класс тузунуз, ичинде бир эле свойствасы болот - userлер, бул класс биздин база данныхыбыз болот.
        5) service пакеттин ичине UserService деген interface тузунуз жана impl деген пакет тузуп коюнуз.
        6) UserServiceтин ичинде 4 метод болот, userди кошуу, id менен табуу, id менен очуруу жана баардык userлерди алуу.
        7) impl пакеттин ичине UserServiceImpl деген класс тузунуз, бул класс UserService интерфейсин ишке ашырат жана бул класста свойства катары биздин база данныхыбыз болот(UserDao).
        8) UserServiceImpl класста UserService интерфейсинин бардык методдорун ишке ашырыныз.
        9) Main методдо 3 user тузунуз idлери 1,2,3 болсун.
        10) Аларды биздин базага кошунуз.
        11) 1 деген id менен userди таап консольго чыгарыныз.
        12) Эгер ал id жок болсо анда RunTimeException кармасын.
        13) Exception ди озунуздор тузунуздорю
        14) Баардык userлерди консольго чыгарыныз.
        15) 2 деген id менен userди очурунуз.
        16) Баардык userлерди консольго чыгарыныз. */

        Scanner scanner = new Scanner(System.in);

        User user1 = new User(1, "Datka", 21, Gender.FEMALE);
        User user2 = new User(2, "Nursultanka", 25, Gender.MALE);
        User user3 = new User(3, "Aziza", 25, Gender.MALE);

       UserService userService = new UserServiceImpl();

       userService.addUser(user1);
       userService.addUser(user2);
       userService.addUser(user3);

       while (true) {
           System.out.println("""
                   1 - user id menen tabu
                   2 - delete user id
                   3 - shou all Users""");
           int num = scanner.nextInt();
           if (num == 1) {
               System.out.println("Write user id");
               int id = scanner.nextInt();
               userService.idMenenTabu(id);
           }else if (num == 2) {
               System.out.println("Write user id");
               int id = scanner.nextInt();
               userService.deleteIdUser(id);
           }else if (num == 3) {
               System.out.println("Users: ");
               userService.shouAllUser();
           }

           System.out.println();
           System.out.println("* * * * * * * * * * * * * * *");
       }
    }
}