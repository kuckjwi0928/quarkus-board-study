package com.kuckjwi.board.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public record Board(String title, String content, Optional<LocalDateTime> createdAt, Optional<LocalDateTime> updatedAt) {
  public static Board of(BoardEntity entity) {
    return new Board(entity.title, entity.content, Optional.of(entity.createdAt), Optional.of(entity.updatedAt));
  }

  public static BoardEntity toEntity(Board board) {
    BoardEntity entity = new BoardEntity();
    entity.title = board.title();
    entity.content = board.content();
    return entity;
  }
}
