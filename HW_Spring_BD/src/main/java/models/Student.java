package models;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey_pers on 20.11.2016.
 */
@Entity
@Table(name="students")
@SequenceGenerator(sequenceName = "students_id_seq", name="seqGen")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
	@Column(name = "id")
	private int id;

	private String name;
	private String surname;
	private String othername;
	private String number;

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Point> points;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
