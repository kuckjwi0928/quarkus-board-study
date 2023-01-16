package com.kuckjwi.board.api;

import com.kuckjwi.board.domain.Board;
import com.kuckjwi.board.domain.BoardService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/boards")
public class BoardController {
  BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }
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
  public Board createBoard(@Valid CreateBoardRequest request) {
    return boardService.createBoard(request.toBoard());
  }
}
