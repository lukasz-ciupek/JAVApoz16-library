package pl.sda.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.library.service.Menu;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Menu menu = context.getBean(Menu.class);

        Scanner in = new Scanner(System.in);

        int wybor = menu.displayMenu();

        while(wybor!=0)
        {
            switch(wybor)
            {
                case 1:
                    String title;
                    System.out.println("Podaj tytuł książki którą chcesz wypożyczyć");
                    title = in.nextLine();
                    menu.borrowBook(title);
                    break;

                case 2:
                    String title2;
                    String author;
                    System.out.println("Podaj autora oraz tytuł książki którą chcesz dodać");
                    author = in.nextLine();
                    title2 = in.nextLine();
                    menu.addBook(title2,author);
                    break;

                case 3:
                    Integer id;
                    System.out.println("Podaj ID książki którą chcesz usunąć");
                    id = in.nextInt();
                    menu.removeBook(id);
                    break;

                case 4:
                    Integer id2;
                    System.out.println("Podaj ID książki którą chcesz oddać");
                    id2 = in.nextInt();
                    menu.returnBook(id2);
                    break;

                case 5:
                    menu.getBooks().forEach(System.out::println);
                    break;
            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            wybor = menu.displayMenu();
        }


        System.out.println("     ****************************************");
        System.out.println("\n     Koniec programu\n\n");
    }

}

