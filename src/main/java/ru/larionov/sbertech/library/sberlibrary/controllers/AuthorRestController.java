package ru.larionov.sbertech.library.sberlibrary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.larionov.sbertech.library.sberlibrary.entities.Author;
import ru.larionov.sbertech.library.sberlibrary.serivices.AuthorService;
import ru.larionov.sbertech.library.sberlibrary.serivices.R;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorRestController {

    private AuthorService authorService;

    @GetMapping(R.route.API_V1_AUTHORS_LIST)
    public Page<Author> getList(@RequestParam(required = false, defaultValue = "1") int page) {
        return authorService.getList(page);
    }

    @GetMapping(R.route.API_V1_AUTHORS_LIST_FULL)
    public List<Author> getFullList() {
        return authorService.getList();
    }

    @GetMapping(R.route.API_V1_AUTHORS_ID)
    public Author getItem(@PathVariable int id) {
        return authorService.getItem(id);
    }
}
