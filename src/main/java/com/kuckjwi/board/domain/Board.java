package com.kuckjwi.board.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public record Board(String title, String content, Optional<LocalDateTime> createdAt, Optional<LocalDateTime> updatedAt) implements ConvertibleEntity<BoardEntity> {
  public static Board of(BoardEntity entity) {
    return new Board(entity.title, entity.content, Optional.of(entity.createdAt), Optional.of(entity.updatedAt));
  }

  @Override
  public BoardEntity toEntity() {
    BoardEntity entity = new BoardEntity();
    entity.title = this.title;
    entity.content = this.content;
    return entity;
  }
}
