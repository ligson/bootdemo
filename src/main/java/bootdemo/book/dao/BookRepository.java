package bootdemo.book.dao;

import bootdemo.book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by trq on 2016/6/17.
 */
@Repository("bookRepository")
public interface BookRepository extends CrudRepository<Book, String> {
    Page<Book> findAll(Pageable pageable);
}
