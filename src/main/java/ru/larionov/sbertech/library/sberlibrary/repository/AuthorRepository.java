package ru.larionov.sbertech.library.sberlibrary.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.larionov.sbertech.library.sberlibrary.entities.Author;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {

}
