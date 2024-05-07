package co.edu.usco.pw.springboot_crud01.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.usco.pw.springboot_crud01.model.Todo;
import co.edu.usco.pw.springboot_crud01.service.ITodoService;

@Controller
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping("/list-todos")
    public String showTodos(Model model) {
        String username = getLoggedInUserName();
        model.addAttribute("todos", todoService.getTodosByUser(username));
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String showAddTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUserName();
        todoService.addTodo(username, todo.getDescription(), new Date(), false);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo/{id}")
    public String showUpdateTodoForm(@PathVariable("id") long id, Model model) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
        } else {
            model.addAttribute("errorMessage", "Todo not found");
        }
        return "todo";
    }

    @PostMapping("/update-todo/{id}")
    public String updateTodo(@PathVariable("id") long id, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @GetMapping("/delete-todo/{id}")
    public String deleteTodo(@PathVariable("id") long id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}

