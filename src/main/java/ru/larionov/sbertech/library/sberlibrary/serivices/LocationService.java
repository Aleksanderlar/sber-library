package ru.larionov.sbertech.library.sberlibrary.serivices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.larionov.sbertech.library.sberlibrary.entities.Location;
import ru.larionov.sbertech.library.sberlibrary.repository.LocationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService implements BaseService<Location> {

    private LocationRepository locationRepository;

    public Page<Location> getList(int page) {
        return locationRepository.findAll(pageRequest(page));
    }

    public Location getItem(int id) {
        return locationRepository.findOne(id);
    }

    public void saveList(List<Location> list) {
        locationRepository.save(list);
    }

    public Location getItemByBook(int bookId) {
        return locationRepository.findByBookId(bookId);
    }

    public void deleteByBook(int bookId) {
        locationRepository.delete(locationRepository.findByBookId(bookId));
    }
}
