package com.rollin.rollinweb.dao;


import com.rollin.rollinweb.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BaseDao<T extends BaseModel> extends JpaRepository<T, UUID> {
}
