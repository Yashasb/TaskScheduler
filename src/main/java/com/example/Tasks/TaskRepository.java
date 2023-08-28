package com.example.Tasks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("UPDATE Task SET userId= :userid where taskId= :taskid")
	int assignTask(int taskid, int userid); 
	
	List<Task> findByuserId(int userid);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("UPDATE Task SET progress= :progress where taskId= :taskid")
	int setProgress(int progress, int taskid);

	List<Task> findBystatus(String status);
	
	
	List<Task> findBydueDateLessThan(String date);

	List<Task> findBydueDateBetween(String startDate, String toDate);
	
}
