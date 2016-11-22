package repository;

import models.Point;
import models.Student;

import java.util.List;

/**
 * Created by Andrey_pers on 21.11.2016.
 */
public interface pointRepository {
	List<Point> getAll();
	int pointForLesson(Student student, int lesson_id);
}
