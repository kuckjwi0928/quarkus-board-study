package com.kuckjwi.board.api;

import com.kuckjwi.board.domain.Board;

import javax.validation.constraints.NotBlank;

public record CreateBoardRequest(@NotBlank String title, @NotBlank String content) {
  public Board toBoard() {
    return new Board(title, content, null, null);
  }
}
