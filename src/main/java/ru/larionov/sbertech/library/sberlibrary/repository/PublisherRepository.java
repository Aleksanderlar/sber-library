package ru.larionov.sbertech.library.sberlibrary.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.larionov.sbertech.library.sberlibrary.entities.Publisher;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Integer> {

}
