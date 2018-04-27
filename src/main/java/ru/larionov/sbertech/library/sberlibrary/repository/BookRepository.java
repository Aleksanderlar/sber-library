package ru.larionov.sbertech.library.sberlibrary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.larionov.sbertech.library.sberlibrary.entities.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

    Page<Book> findAllByPublisherId(int publisher, Pageable page);

    Page<Book> findAllByAuthorId(int author, Pageable page);

    Page<Book> findAllByNameContainingAndAuthorFioContainingAndPublisherNameContainingAndYearBetween(String name, String fio, String publisher, int yearStart, int yearEnd, Pageable page);
}
