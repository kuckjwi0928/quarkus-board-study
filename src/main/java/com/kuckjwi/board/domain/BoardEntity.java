package com.kuckjwi.board.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
public class BoardEntity extends PanacheEntity {
  public String title;
  public String content;

  @CreationTimestamp
  public LocalDateTime createdAt;

  @UpdateTimestamp
  public LocalDateTime updatedAt;
}
