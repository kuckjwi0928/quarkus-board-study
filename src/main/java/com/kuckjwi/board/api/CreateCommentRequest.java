package com.kuckjwi.board.api;

import com.kuckjwi.board.domain.Comment;

import javax.validation.constraints.NotBlank;

public record CreateCommentRequest(@NotBlank String content) {
  public Comment toComment() {
    return new Comment(content);
  }
}
