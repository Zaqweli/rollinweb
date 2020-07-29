package com.rollin.rollinweb.dao;

import com.rollin.rollinweb.model.Game;

import java.util.List;

public interface GameDao {

    public List<Game> FindByIdTag(Long idTag);

    public void addArticleTag(Long idArticle, Long idTag);

    public void delAllArticleTag(Long idArticle);

}
