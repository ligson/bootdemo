package bootdemo.book.service;

import bootdemo.book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

/**
 * Created by trq on 2016/6/17.
 */
public interface BookService {
    Book join(String title, String description, BigDecimal price);

    Page<Book> list(Pageable pageable);
}
