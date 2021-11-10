package com.airi.education.domain.todo.controller;

import static com.airi.education.domain.todo.dto.TodoDto.TodoGetResDto;
import static com.airi.education.domain.todo.dto.TodoDto.TodoPostReqDto;
import static com.airi.education.domain.todo.dto.TodoDto.TodoPutReqDto;
import com.airi.education.domain.todo.entity.Todo;
import com.airi.education.domain.todo.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@Api(value = "Todo")
public class TodoController {
  private final TodoService todoService;

  @GetMapping
  @ApiOperation(value = "모든 Todo Item 가져오기")
  public ResponseEntity<List<TodoGetResDto>> getAll() {
    return ResponseEntity.ok(todoService.getAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<TodoGetResDto> get(@PathVariable Long id) {
    return ResponseEntity.ok(todoService.get(id));
  }

  @PostMapping
  public ResponseEntity<TodoGetResDto> create(@RequestBody TodoPostReqDto dto) {
    return ResponseEntity.ok(todoService.create(dto));
  }

  @PutMapping
  public ResponseEntity<TodoGetResDto> update(@RequestBody TodoPutReqDto dto) {


    return ResponseEntity.ok(todoService.update(dto));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<TodoGetResDto> updateFavorite(@PathVariable Long id) {
    return ResponseEntity.ok(todoService.updateFavorite(id));
  }

  @DeleteMapping(value = "/{id}")
  public Long delete(@PathVariable Long id) { return todoService.delete(id); }
}
