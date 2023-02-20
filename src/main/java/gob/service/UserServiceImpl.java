package gob.service;

import gob.modele.User;
import gob.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{ //Implemente toutes les methodes contenus dans UserService (méthodes à paramétrer)

    private final UserRepository userRepository; // Ici, on injecte notre repository qui va recuperer les valeurs de notre constructeur

    @Override
    public User creer(User user){
        return userRepository.save(user); // "save" pour enregistrer dans la Bdd
    }
    @Override
    public List<User> lire() {
        return userRepository.findAll(); // "findAll" pour récupérer tos les utilisateurs
    }
    @Override
    public String supprimer(String user_id){
        userRepository.deleteById(user_id);
        return "Utilisateur effacé!";
    }
    @Override
    public User modifier(String user_id, User user){
        return userRepository.findById(user_id) // On récupère toutes les infos de l'utilisateur avec l'id donné
                .map(p->{
                    p.setUsername(user.getUsername()); // Les attributs a modifier
                    p.setActive(user.getActive());
                    p.setPassword(user.getPassword());
                    p.setCreationDate(user.getCreationDate());
                    p.setLastConnexion(user.getLastConnexion());
                    p.setLoggedIn(user.getLoggedIn());

                    return userRepository.save(p); // Avant d'enregistrer avec le "save" dans notre Bdd
                }).orElseThrow(()-> new RuntimeException("Utilisateur non trouvé !")); // Erreur personnalisée, si pas d'utilisateur avec ce ID
    }
}
