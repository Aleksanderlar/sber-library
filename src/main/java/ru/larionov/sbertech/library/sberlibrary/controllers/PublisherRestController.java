package ru.larionov.sbertech.library.sberlibrary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.larionov.sbertech.library.sberlibrary.entities.Publisher;
import ru.larionov.sbertech.library.sberlibrary.serivices.PublisherService;
import ru.larionov.sbertech.library.sberlibrary.serivices.R;

import java.util.List;

@RestController
@AllArgsConstructor
public class PublisherRestController {

    private PublisherService publisherService;

    @GetMapping(R.route.API_V1_PUBLISHERS_LIST)
    public Page<Publisher> getList(@RequestParam(required = false, defaultValue = "1") int page) {
        return publisherService.getList(page);
    }

    @GetMapping(R.route.API_V1_PUBLISHERS_LIST_FULL)
    public List<Publisher> getFullList() {
        return publisherService.getList();
    }

    @GetMapping(R.route.API_V1_PUBLISHERS_ID)
    public Publisher getItem(@PathVariable int id) {
        return publisherService.getItem(id);
    }
}
