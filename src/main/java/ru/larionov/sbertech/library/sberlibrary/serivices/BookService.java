package ru.larionov.sbertech.library.sberlibrary.serivices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.larionov.sbertech.library.sberlibrary.entities.Book;
import ru.larionov.sbertech.library.sberlibrary.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements BaseService<Book> {

    private BookRepository bookRepository;

    public Page<Book> getList(int page) {
        return bookRepository.findAll(pageRequest(page));
    }

    public Page<Book> getListByPublisherId(int publisherId, int page) {
        return bookRepository.findAllByPublisherId(publisherId, pageRequest(page));
    }

    public Page<Book> getListByAuthorId(int authorId, int page) {
        return bookRepository.findAllByAuthorId(authorId, pageRequest(page));
    }

    public Book getItem(int id) {
        return bookRepository.findOne(id);
    }

    public void saveList(List<Book> list) {
        bookRepository.save(list);
    }

    public Page<Book> searchBooks(String name, String author, String publisher, int dateStart, int dateEnd, int page) {
        return bookRepository.findAllByNameContainingAndAuthorFioContainingAndPublisherNameContainingAndYearBetween(name, author, publisher, dateStart, dateEnd, pageRequest(page));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(int bookId) {
        bookRepository.delete(bookId);
    }
}
