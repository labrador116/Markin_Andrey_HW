package inno.model;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@SequenceGenerator(sequenceName = "users_id_seq", name = "userSeq")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
	private  Long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String othername;
	private final String priority ="ROLE_USER";
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Post> posts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public String getPriority() {
		return priority;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		this.password =bCryptPasswordEncoder.encode(password);
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
