package com.kuckjwi.board.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class BoardEntity extends PanacheEntity {
  public String title;
  public String content;

  @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
  public List<CommentEntity> comments = new ArrayList<>();

  @CreationTimestamp
  public LocalDateTime createdAt;

  @UpdateTimestamp
  public LocalDateTime updatedAt;
}
