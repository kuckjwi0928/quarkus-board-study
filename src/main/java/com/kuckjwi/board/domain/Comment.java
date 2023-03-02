package com.kuckjwi.board.domain;

public record Comment(String content) implements ConvertibleEntity<CommentEntity> {
  public static Comment of(CommentEntity entity) {
    return new Comment(entity.content);
  }

  @Override
  public CommentEntity toEntity() {
    CommentEntity entity = new CommentEntity();
    entity.content = this.content;
    return entity;
  }
}
