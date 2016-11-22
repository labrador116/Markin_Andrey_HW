package repository;

import models.Student;

import java.util.List;

public interface studentRepository {

	List<Student> getAll();
	Student findStudent(int id);
	Long getSumPoints(int id);
	Long averagePoint(int id);
	Integer pointForLesson(int id, String lesson);
}
