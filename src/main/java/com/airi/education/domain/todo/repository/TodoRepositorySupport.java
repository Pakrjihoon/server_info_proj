package com.airi.education.domain.todo.repository;

import static com.airi.education.domain.todo.entity.QTodo.todo;
import static com.airi.education.domain.todo.dto.TodoDto.TodoGetResDto;

import com.airi.education.domain.todo.dto.TodoDto;
import com.airi.education.domain.todo.entity.Todo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositorySupport extends QuerydslRepositorySupport {
  private final JPAQueryFactory queryFactory;

  public TodoRepositorySupport(JPAQueryFactory queryFactory){
    super(Todo.class);
    this.queryFactory = queryFactory;
  }

  public TodoGetResDto findById(Long id) {
    return queryFactory
        .select(Projections.bean(TodoGetResDto.class, todo.id, todo.title, todo.content, todo.isFavorite)).from(todo)
        .where(todo.id.eq(id))
        .fetchOne();
  }
}
