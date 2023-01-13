package com.kuckjwi.board.api;

import com.kuckjwi.board.domain.Board;
import com.kuckjwi.board.domain.BoardService;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/boards")
public class BoardController {
  @Inject
  BoardService boardService;

  @Inject
  Validator validator;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Board> getBoards() {
    return boardService.getBoards();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Board getBoard(long id) {
    return boardService.getBoard(id);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Board createBoard(CreateBoardRequest request) {
    final var violations = validator.validate(request);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
    return boardService.createBoard(request.toBoard());
  }
}
