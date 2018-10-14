package ma.fouad.spingjwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.fouad.spingjwt.dao.TaskRepository;
import ma.fouad.spingjwt.entities.Task;

@RestController
public class TaskRestController {
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> listTasks()
	{
		return taskRepository.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t)
	{	
		System.out.println();
		return taskRepository.save(t);
	}

}
