package com.airi.education.domain.todo.entity;

import static com.airi.education.domain.todo.dto.TodoDto.*;

import com.airi.education.domain.todo.dto.TodoDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 450, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @Column
  private boolean isFavorite = false;

  @Builder
  public Todo(String title, String content, Boolean isFavorite) {
    this.title = title;
    this.content = content;
    this.isFavorite = isFavorite;
  }

  public void update(final TodoDto.TodoPutReqDto todoPutReqDto) {
    if (todoPutReqDto.getContent() != null) {
      this.content = todoPutReqDto.getContent();
    }
  }
  public void updateFavorite() {
      this.isFavorite = !this.isFavorite;
  }
}
