package com.rollin.rollinweb.service;

import com.rollin.rollinweb.dao.BaseDao;
import com.rollin.rollinweb.dao.GameDao;
import com.rollin.rollinweb.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GameService extends AbstractBaseService<Game> {

    @Autowired
    private GameDao gameDao;

    @Override
    public BaseDao<Game> getDao() {
        return gameDao;
    }


}
