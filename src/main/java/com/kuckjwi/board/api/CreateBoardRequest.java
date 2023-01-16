package com.kuckjwi.board.api;

import com.kuckjwi.board.domain.Board;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public record CreateBoardRequest(@NotBlank String title, @NotBlank String content) {
  public Board toBoard() {
    return new Board(title, content, Optional.empty(), Optional.empty());
  }
}
