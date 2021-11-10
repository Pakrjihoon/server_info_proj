package com.airi.education.domain.todo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TodoDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class TodoGetResDto {
    private Long id;
    private String title;
    private String content;
    private boolean isFavorite;

    @Builder
    public TodoGetResDto(Long id, String title, String content, boolean isFavorite) {
      this.id = id;
      this.title = title;
      this.content = content;
      this.isFavorite = isFavorite;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class TodoPostReqDto {
    private String title;
    private String content;

    @Builder
    public TodoPostReqDto(String title, String content) {
      this.title = title;
      this.content = content;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class TodoPutReqDto {
    private Long id;
    private String content;

    @Builder
    public TodoPutReqDto(Long id, String content) {
      this.id = id;
      this.content = content;
    }
  }

}
