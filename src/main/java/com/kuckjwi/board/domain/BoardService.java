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
    return Board.of(this.getBoardEntity(id));
  }

  @Transactional
  public Board createBoard(Board board) {
    BoardEntity entity = board.toEntity();
    boardRepository.persistAndFlush(entity);
    return Board.of(entity);
  }

  @Transactional
  public Comment createComment(long id, Comment comment) {
    BoardEntity boardEntity = this.getBoardEntity(id);
    CommentEntity commentEntity = comment.toEntity();
    boardEntity.comments.add(commentEntity);
    commentEntity.board = boardEntity;
    boardRepository.persistAndFlush(boardEntity);
    return Comment.of(commentEntity);
  }

  private BoardEntity getBoardEntity(long id) {
    return boardRepository.findByIdOptional(id)
            .orElseThrow(NotFoundException::new);
  }
}
