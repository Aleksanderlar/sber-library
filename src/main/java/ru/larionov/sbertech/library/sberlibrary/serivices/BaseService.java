package ru.larionov.sbertech.library.sberlibrary.serivices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BaseService<T> {
    Page<T> getList(int page);

    T getItem(int id);

    void saveList(List<T> list);

    default PageRequest pageRequest(int page) {
        return new PageRequest(page - 1, 24);
    }
}
