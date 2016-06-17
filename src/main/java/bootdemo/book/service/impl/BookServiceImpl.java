package bootdemo.book.service.impl;

import bootdemo.book.dao.BookRepository;
import bootdemo.book.domain.Book;
import bootdemo.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by trq on 2016/6/17.
 */
@Component("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book join(String title, String description, BigDecimal price) {
        Book book = new Book();
        book.setCreateDate(new Date());
        book.setJoinDate(new Date());
        book.setTitle(title);
        book.setDescription(description);
        book.setPrice(price);
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> list(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
