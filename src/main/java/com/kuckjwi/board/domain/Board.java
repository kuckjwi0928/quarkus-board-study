package com.kuckjwi.board.domain;

import java.time.LocalDateTime;

public record Board(String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
  public static Board of(BoardEntity entity) {
    return new Board(entity.title, entity.content, entity.createdAt, entity.updatedAt);
  }

  public static BoardEntity toEntity(Board board) {
    BoardEntity entity = new BoardEntity();
    entity.title = board.title();
    entity.content = board.content();
    return entity;
  }
}
