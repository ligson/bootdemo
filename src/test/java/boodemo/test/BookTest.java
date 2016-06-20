package boodemo.test;

import bootdemo.book.domain.Book;
import bootdemo.main.Bootstrap;
import bootdemo.book.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * Created by trq on 2016/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Bootstrap.class})
public class BookTest {
    @Autowired
    private BookService bookService;

    @Test
    public void joinTest() {
        for (int i = 0; i < 100; i++) {
            Book book = bookService.join("title" + i, "descripton" + i, new BigDecimal(Math.random() * 100));
        }
    }

    @Test
    public void find(){
        Pageable pageable = new PageRequest(1,10);
        Page<Book> books = bookService.list(pageable);
        System.out.println(books);
    }
}
