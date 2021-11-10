package com.airi.education.domain.todo.service;

import static com.airi.education.domain.todo.dto.TodoDto.TodoGetResDto;
import static com.airi.education.domain.todo.dto.TodoDto.TodoPostReqDto;
import static com.airi.education.domain.todo.dto.TodoDto.TodoPutReqDto;

import com.airi.education.domain.todo.entity.Todo;
import com.airi.education.domain.todo.repository.TodoRepository;
import com.airi.education.domain.todo.repository.TodoRepositorySupport;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final ModelMapper modelMapper;

  @Autowired
  private TodoRepositorySupport todoRepositorySupport;

  @Transactional(readOnly = true)
  public List<TodoGetResDto> getAll() {
    List<Todo> todoList = todoRepository.findAll();

    return todoList.stream().map((x) -> modelMapper.map(x, TodoGetResDto.class))
        .collect(
            Collectors.toList());
  }

  @Transactional(readOnly = true)
  public TodoGetResDto get(Long id) {
//    Todo todo = todoRepository.findById(id)
//        .orElseThrow(() -> new EntityNotFoundException(id.toString()));

    TodoGetResDto todoGetResDto = todoRepositorySupport.findById(id);
    return todoGetResDto;
  }

  @Transactional
  public TodoGetResDto create(TodoPostReqDto todoPostReqDto) {
    Todo todo = Todo.builder()
        .title(todoPostReqDto.getTitle())
        .content(todoPostReqDto.getContent())
        .isFavorite(false)
        .build();
    todoRepository.save(todo);
    return modelMapper.map(todo, TodoGetResDto.class);
  }

  @Transactional
  public TodoGetResDto update(TodoPutReqDto todoPutReqDto) {
    Todo todo = todoRepository.findById(todoPutReqDto.getId())
        .orElseThrow(() -> new EntityNotFoundException(todoPutReqDto.getId().toString()));
    todo.update(todoPutReqDto);
    return modelMapper.map(todo, TodoGetResDto.class);
  }

  @Transactional
  public TodoGetResDto updateFavorite(Long id) {
    Todo todo = todoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    todo.updateFavorite();
    return modelMapper.map(todo, TodoGetResDto.class);
  }

  public Long delete(Long id) {
    todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    todoRepository.deleteById(id);
    return id;
  }
}
