package bootdemo.book.controller;

import bootdemo.book.domain.Book;
import bootdemo.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by trq on 2016/6/17.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    @ResponseBody
    public Book join(@RequestParam String title, @RequestParam String description, @RequestParam String price) {
        BigDecimal decimal = new BigDecimal(price);
        return bookService.join(title, description, decimal);
    }
}
