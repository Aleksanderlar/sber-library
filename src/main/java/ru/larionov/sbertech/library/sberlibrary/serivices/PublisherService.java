package ru.larionov.sbertech.library.sberlibrary.serivices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.larionov.sbertech.library.sberlibrary.entities.Publisher;
import ru.larionov.sbertech.library.sberlibrary.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService implements BaseService<Publisher> {

    private PublisherRepository publisherRepository;

    public Page<Publisher> getList(int page) {
        return publisherRepository.findAll(pageRequest(page));
    }

    public List<Publisher> getList() {
        List<Publisher> publishers = new ArrayList<>();
        publisherRepository.findAll().forEach(publishers::add);
        return publishers;
    }

    public Publisher getItem(int id) {
        return publisherRepository.findOne(id);
    }

    public void saveList(List<Publisher> list) {
        publisherRepository.save(list);
    }
}
