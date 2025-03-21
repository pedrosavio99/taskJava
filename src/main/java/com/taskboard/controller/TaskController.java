package com.taskboard.controller;

import com.taskboard.model.Task;
import com.taskboard.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/task/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @GetMapping("/task/edit")
    public String editTask(@RequestParam Long id, Model model) {
        Task task = taskService.getAllTasks().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute Task task) {
        if (task.getId() == null) {
            taskService.saveTask(task);
        } else {
            taskService.updateTask(task.getId(), task);
        }
        return "redirect:/";
    }

    @GetMapping("/task/delete")
    public String deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}