package models;

import javax.persistence.*;

/**
 * Created by Andrey_pers on 21.11.2016.
 */
@Entity
@Table(name = "points")
@SequenceGenerator(sequenceName = "points_id_seq", name="pointGen")
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pointGen")
	@Column(name="id")
	private int id;
	private String lesson;
	private int point_of_lesson;


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getPoint_of_lesson() {
		return point_of_lesson;
	}

	public void setPoint_of_lesson(int point_of_lesson) {
		this.point_of_lesson = point_of_lesson;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}
