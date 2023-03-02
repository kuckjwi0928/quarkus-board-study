package com.kuckjwi.board.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends PanacheEntity {
  public String content;

  @ManyToOne
  public BoardEntity board;

  @CreationTimestamp
  public LocalDateTime createdAt;

  @UpdateTimestamp
  public LocalDateTime updatedAt;
}
