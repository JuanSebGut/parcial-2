package co.edu.usco.pw.springboot_crud01.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usco.pw.springboot_crud01.model.Todo;
import co.edu.usco.pw.springboot_crud01.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> getTodosByUser(String username) {
        return todoRepository.findBysetSubjectName(username);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

	@Override
	public void addTodo(String username, String description, Date date, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTodo() {
		// TODO Auto-generated method stub
		
	}

}
