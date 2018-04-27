package ru.larionov.sbertech.library.sberlibrary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.larionov.sbertech.library.sberlibrary.entities.Book;
import ru.larionov.sbertech.library.sberlibrary.entities.Location;
import ru.larionov.sbertech.library.sberlibrary.serivices.BookService;
import ru.larionov.sbertech.library.sberlibrary.serivices.LocationService;
import ru.larionov.sbertech.library.sberlibrary.serivices.R;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookRestController {

    private BookService bookService;
    private LocationService locationService;

    @GetMapping(R.route.API_V1_BOOKS_LIST)
    public Page<Book> getList(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "0") int publisherId, @RequestParam(required = false, defaultValue = "0") int authorId) {
        Page<Book> books;
        if (publisherId > 0) {
            books = bookService.getListByPublisherId(publisherId, page);
        } else if (authorId > 0) {
            books = bookService.getListByAuthorId(authorId, page);
        } else {
            books = bookService.getList(page);
        }
        return books;
    }

    @GetMapping(R.route.API_V1_BOOKS_SEARCH)
    public Page<Book> search(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String author,
            @RequestParam(required = false, defaultValue = "") String publisher,
            @RequestParam(required = false, defaultValue = "0") int dateStart,
            @RequestParam(required = false, defaultValue = "3000") int dateEnd
    ) {
        Page<Book> books;
        books = bookService.searchBooks(name, author, publisher, dateStart, dateEnd, page);
        return books;
    }

    @GetMapping(R.route.API_V1_BOOKS_ID)
    public Map<String, Object> getBook(@PathVariable int id) {
        Book book = bookService.getItem(id);
        Location location = locationService.getItemByBook(id);
        location.setBook(null);
        Map<String, Object> map = new HashMap<>();
        map.put("book", book);
        map.put("location", location);
        return map;
    }


    @PostMapping(R.route.API_V1_BOOKS_SAVE)
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }


    @PostMapping(R.route.API_V1_BOOKS_DELETE)
    public void deleteBook(@RequestBody Book book) {
        locationService.deleteByBook(book.getId());
        bookService.delete(book.getId());
    }
}
