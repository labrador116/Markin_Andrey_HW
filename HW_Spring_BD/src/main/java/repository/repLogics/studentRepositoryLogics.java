package repository.repLogics;
import models.Point;
import models.Student;
import org.springframework.stereotype.Repository;
import repository.studentRepository ;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class studentRepositoryLogics implements studentRepository {

	@PersistenceContext
	EntityManager em;

	public List<Student> getAll() {
		TypedQuery<Student> studentTypedQuery = em.createQuery("SELECT student FROM Student student", Student.class);
		return studentTypedQuery.getResultList();
	}

	public Student findStudent(int id) {
		return null;
	}

	public Long getSumPoints(int id) {
		Query query = em.createQuery("SELECT  SUM (point.point_of_lesson) FROM Point point  JOIN point.student p WHERE p.id=:id");
		query.setParameter("id",id);
		Long sum = (Long) query.getSingleResult();
		return sum;
	}

	public Long averagePoint(int id) {
		Query query = em.createQuery("SELECT  count(point.lesson) FROM Point point  JOIN point.student p WHERE p.id=:id");
		query.setParameter("id",id);
		Long result = (Long) query.getSingleResult();
		result=getSumPoints(id)/result;
		return  result;
	}

	public Integer pointForLesson(int id, String lesson) {
		Query query = em.createQuery("SELECT point.point_of_lesson FROM Point point  JOIN point.student p WHERE p.id=:id AND point.lesson =:lesson");
		query.setParameter("id",id);
		query.setParameter("lesson",lesson);
		Integer result = (Integer) query.getSingleResult();
		return result;
	}

}
