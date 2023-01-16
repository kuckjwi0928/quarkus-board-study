package com.kuckjwi.board.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class BoardService {
  BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public List<Board> getBoards() {
    return boardRepository.findAll()
            .stream()
            .map(Board::of)
            .toList();
  }

  public Board getBoard(long id) {
    return Board.of(boardRepository.findByIdOptional(id)
            .orElseThrow(NotFoundException::new));
  }

  @Transactional
  public Board createBoard(Board board) {
    BoardEntity entity = Board.toEntity(board);
    boardRepository.persistAndFlush(entity);
    return Board.of(entity);
  }
}
