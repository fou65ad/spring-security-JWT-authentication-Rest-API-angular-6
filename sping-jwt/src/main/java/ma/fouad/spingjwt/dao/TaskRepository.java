package ma.fouad.spingjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fouad.spingjwt.entities.Task;

public interface TaskRepository extends JpaRepository<Task ,Long>{

}
