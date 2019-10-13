package pl.sda;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.library.AppConfig;
import pl.sda.library.model.Book;
import pl.sda.library.repository.BookRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldReturnTrueAfterAddBook()
    {
        //given
        String title = "test";
        String author = "ja";

        //when
        bookRepository.addBook(title,author);
        Integer actualSize = bookRepository.getBooks().size();

        String titleFromRepository = bookRepository.getBooks().stream()
                .reduce((first, second) -> second).get().getTitle();
        String authorFromRepository = bookRepository.getBooks().stream()
                .reduce((first, second) -> second).get().getAuthor();
        Integer idFromRepository = bookRepository.getBooks().stream()
                .reduce((first, second) -> second).get().getId();
        LocalDate borrowedTillFromRepository = bookRepository.getBooks().stream()
                .reduce((first, second) -> second).get().getBorrowedTill();

        //then
        Assert.assertEquals(actualSize,11,0.0000001);
        Assert.assertEquals(titleFromRepository,"test");
        Assert.assertEquals(authorFromRepository,"ja");
        Assert.assertEquals(idFromRepository,11,0.0000001);
        Assert.assertNull(borrowedTillFromRepository);

    }

 
}
