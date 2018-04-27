package ru.larionov.sbertech.library.sberlibrary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.larionov.sbertech.library.sberlibrary.entities.Location;
import ru.larionov.sbertech.library.sberlibrary.serivices.LocationService;
import ru.larionov.sbertech.library.sberlibrary.serivices.R;

@RestController
@AllArgsConstructor
public class LocationRestController {

    private LocationService locationService;

    @GetMapping(R.route.API_V1_LOCATION_BOOK_ID)
    public Location getList(@PathVariable int bookId) {
        return locationService.getItem(bookId);
    }
}
