package inno.repository;

import inno.model.User;

/**
 * Created by Andrey_pers on 27.11.2016.
 */
public interface UserRepository {

	boolean userAdd(User user);
	boolean userCheck(String login, String password);
	Long idByLogin(String login);

}
