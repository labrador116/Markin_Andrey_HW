package inno.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@SequenceGenerator(sequenceName = "post_seq", name = "postSequence")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSequence")
    @Column(name = "id")
    private Long id;

    @Column
    private String title;
    @Column
    private String text;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

  //  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   // private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Transient
    @Enumerated(EnumType.STRING)
    private PostType type;

    public Post() {
        this.date = new Date();
    }

    public Post(String title, String text) {
        this();
        this.title = title;
        this.text = text;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   /* public List<Comment> getComments() {
        return comments;
    }*/

   /* public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/
}
