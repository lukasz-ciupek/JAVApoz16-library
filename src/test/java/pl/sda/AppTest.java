package pl.sda;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.library.repository.BookRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
