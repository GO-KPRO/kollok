package bar.hse.kollok.controllers;

import bar.hse.kollok.exceptions.BadRequestException;
import bar.hse.kollok.exceptions.NotFoundException;
import bar.hse.kollok.objects.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TasksController {
    private final List<String> statuses = new ArrayList<String>() {{
        add("waiting");
        add("in progress");
        add("done");
    }};
    private int currentId = 4;
    private final List<Task> tasks = new ArrayList<Task>() {{
        add(new Task(1, "wash dishes", "wash plates, forks and cups", new Date().toString(), "waiting"));
        add(new Task(2, "do homework", "solve math problems, write essay", new Date().toString(), "in progress"));
        add(new Task(3, "go for a walk", "go to the park with friends", new Date().toString(), "done"));
    }};

    @GetMapping
    public List<Task> list() {
        return tasks;
    }

    @GetMapping("{id}")
    public Task getOne(@PathVariable String id) {
        return getTaskByID(id);
    }

    private Task getTaskByID(String id) {
        return tasks.stream()
                .filter(task -> task.getId().toString().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        task.setId(currentId++);
        task.setDate(new Date().toString());
        task.setStatus("waiting");
        tasks.add(task);
        return task;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        Task pointTask = getTaskByID(id);
        statuses.stream()
                .filter(str -> str.equals(task.getStatus()))
                .findFirst()
                .orElseThrow(BadRequestException::new);
        pointTask.putAll(
                Integer.parseInt(id),
                task.getName(),
                task.getDescription(),
                pointTask.getDate(),
                task.getStatus());
        return pointTask;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Task task = getTaskByID(id);
        tasks.remove(task);
    }

}
