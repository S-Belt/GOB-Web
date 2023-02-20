package gob.service;

import gob.modele.User;

import java.util.List;

public interface UserService {

    User creer(User user);
    List<User> lire();
    User modifier(String user_id, User user);
    String supprimer(String user_id);

}
