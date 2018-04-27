package ru.larionov.sbertech.library.sberlibrary.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.larionov.sbertech.library.sberlibrary.entities.Author;
import ru.larionov.sbertech.library.sberlibrary.entities.Book;
import ru.larionov.sbertech.library.sberlibrary.entities.Location;
import ru.larionov.sbertech.library.sberlibrary.entities.Publisher;
import ru.larionov.sbertech.library.sberlibrary.serivices.AuthorService;
import ru.larionov.sbertech.library.sberlibrary.serivices.BookService;
import ru.larionov.sbertech.library.sberlibrary.serivices.LocationService;
import ru.larionov.sbertech.library.sberlibrary.serivices.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class InitialConfig {

    @Bean
    InitializingBean initDataBase(AuthorService authorService, PublisherService publisherService, BookService bookService, LocationService locationService) {

        if (true) {
            List<Author> authors = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Author author = new Author();
                author.setId(i);
                author.setFio("Автор №" + i);
                authors.add(author);
            }
            authorService.saveList(authors);

            List<Publisher> publishers = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Publisher publisher = new Publisher();
                publisher.setId(i);
                publisher.setName("Издательство №" + i);
                publishers.add(publisher);
            }
            publisherService.saveList(publishers);

            Random random = new Random();

            List<Location> locations = new ArrayList<>();
            List<Book> books = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                Book book = new Book();
                book.setId(i);
                book.setName("Название книги №" + i);
                book.setPublisher(publishers.get(random.nextInt(10)));
                book.setAuthor(authors.get(random.nextInt(10)));
                book.setYear(2018 - random.nextInt(50));
                book.setInStock(random.nextBoolean());
                books.add(book);
                Location location = new Location();
                location.setBook(book);
                location.setId(i);
                location.setRow(i % 2 + 1);
                location.setShelf(i % 5 + 1);
                location.setNumber(i % 10 + 1);
                locations.add(location);
            }
            bookService.saveList(books);
            locationService.saveList(locations);
        }
        return () -> {
        };
    }
}
