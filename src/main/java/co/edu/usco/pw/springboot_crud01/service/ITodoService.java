package co.edu.usco.pw.springboot_crud01.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.edu.usco.pw.springboot_crud01.model.Todo;

public interface ITodoService {

	List<Todo> getTodosByUser(String user);

	Optional<Todo> getTodoById(long id);

	void saveTodo(Todo todo);

	void deleteTodo(long id);

	void updateTodo(Todo todo);

	List<Todo> getAllTodos();

	void addTodo(String username, String description, Date date, boolean b);

	void updateTodo();
}
