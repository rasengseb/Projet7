package com.librairy.api.service;

import com.librairy.api.model.User;
import com.librairy.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Récupère les informations d'un utilisateur
     *
     * @param pseudo de l'utilisateur cherché
     * @return utilisateur
     */
    public User getUser(String pseudo) {
        return userRepository.findByPseudo(pseudo);
    }

    /**
     * Récupère les informations d'un utilisateur
     *
     * @param id utilisateur cherché
     * @return utilisateur
     */
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Recherche tous les utilisateurs enregistrés
     *
     * @return List des utilisateurs enregistrés
     */
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Supprime un utilisateur
     *
     * @param id utilisateur à supprimer
     */
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Enregistre l'utilisateur
     * @param user utilisateur à enregistrer
     * @return utilisateur enregistré
     */
    public User saveUser(User user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    /**
     * Vérifie que le pseudo ou le mail n'est pas déjà utilisé
     * @param user utilisateur à tester
     * @return présence ou non en BDD
     */
    public boolean doublonCheck(User user) {
        if (userRepository.findByPseudo(user.getPseudo()) == null) {
            return true;
        } else if (userRepository.findByMail(user.getMail()) == null) {
            return true;
        } else {
            return false;
        }
    }
}
