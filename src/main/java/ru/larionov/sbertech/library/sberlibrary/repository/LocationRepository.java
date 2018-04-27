package ru.larionov.sbertech.library.sberlibrary.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.larionov.sbertech.library.sberlibrary.entities.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, Integer> {

    Location findByBookId(int bookId);
}
