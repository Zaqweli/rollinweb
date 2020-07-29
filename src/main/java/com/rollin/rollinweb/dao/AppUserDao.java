package com.rollin.rollinweb.dao;

import com.rollin.rollinweb.model.AppUser;

import java.util.Optional;

public interface AppUserDao extends BaseDao<AppUser> {

    Optional<AppUser> findByUsername(String username);

}