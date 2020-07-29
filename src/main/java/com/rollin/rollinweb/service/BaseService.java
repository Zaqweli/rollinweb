package com.rollin.rollinweb.service;

import com.rollin.rollinweb.model.BaseModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<T extends BaseModel> {

    public Optional<T> find(UUID uuid);
    public List<T> list();
    public T create(T model);
    public T update(T model);
    public boolean delete(UUID uuid);

}
