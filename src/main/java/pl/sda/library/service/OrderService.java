package pl.sda.library.service;

import org.springframework.stereotype.Service;
import pl.sda.library.model.Book;
import pl.sda.library.repository.BookRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final BookRepository bookRepository;

    public OrderService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> borrowBook(String title) {
        return bookRepository.borrowBook(title, LocalDate.now().plusDays(30));
    }

    public Book addBook(String title, String author) {
        return bookRepository.addBook(title, author);
    }

    public void removeBook(Integer id)
    {
        bookRepository.removeBook(id);
    }

    public void returnBook(Integer id)
    {
        bookRepository.returnBook(id);
    }

    public Set<Book> getBooks()
    {
        return bookRepository.getBooks();
    }
}
