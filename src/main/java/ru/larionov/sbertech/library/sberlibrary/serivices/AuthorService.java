package ru.larionov.sbertech.library.sberlibrary.serivices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.larionov.sbertech.library.sberlibrary.entities.Author;
import ru.larionov.sbertech.library.sberlibrary.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService implements BaseService<Author> {

    private AuthorRepository authorRepository;

    public Page<Author> getList(int page) {
        return authorRepository.findAll(pageRequest(page));
    }

    public List<Author> getList() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public Author getItem(int id) {
        return authorRepository.findOne(id);
    }

    public void saveList(List<Author> list) {
        authorRepository.save(list);
    }
}
