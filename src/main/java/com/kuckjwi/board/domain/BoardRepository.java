package com.kuckjwi.board.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoardRepository implements PanacheRepository<BoardEntity> {
}
