package inno.repository;

import inno.model.Post;
import inno.model.User;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();

    Post find(Long id);

    boolean add(Post post);

    void update(Post post);

    boolean remove(Long id);

    List<Post> findByText(String text);

    User userByLogin(String login);

}
