package com.kuckjwi.board.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class BoardService {
  @Inject
  BoardRepository boardRepository;

  public List<Board> getBoards() {
    return boardRepository.findAll()
            .stream()
            .map(Board::from)
            .toList();
  }

  public Board getBoard(long id) {
    return Board.from(boardRepository.findByIdOptional(id)
            .orElseThrow(NotFoundException::new));
  }

  @Transactional
  public Board createBoard(Board board) {
    // TODO(kuckjwi): createdAt, updatedAt
    BoardEntity entity = Board.toEntity(board);
    boardRepository.persist(entity);
    return Board.from(entity);
  }
}
