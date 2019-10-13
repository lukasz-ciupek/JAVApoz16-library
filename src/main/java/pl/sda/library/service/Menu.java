package pl.sda.library.service;

import org.springframework.stereotype.Component;
import pl.sda.library.model.Book;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@Component
public class Menu {

    private final OrderService orderService;

    public Menu(OrderService orderService)
    {
        this.orderService = orderService;
    }

    public int displayMenu()
    {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1 - Wypożycz książkę");
        System.out.println("     2 - Dodaj książkę");
        System.out.println("     3 - Usuń książkę");
        System.out.println("     4 - Oddaj książkę");
        System.out.println("     5 - Wyswietl liste ksiazek");
        System.out.println("     0 - Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public Optional<Book> borrowBook(String title) {
        return orderService.borrowBook(title);
    }

    public Book addBook(String title, String author) {
        return orderService.addBook(title, author);
    }

    public void removeBook(Integer id)
    {
        orderService.removeBook(id);
    }

    public void returnBook(Integer id)
    {
        orderService.returnBook(id);
    }

    public Set<Book> getBooks()
    {
        return orderService.getBooks();
    }

}
