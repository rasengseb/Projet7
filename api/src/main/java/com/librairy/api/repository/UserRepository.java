package com.librairy.api.repository;

import com.librairy.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

     /**
      * Trouve un utilisateur avec son pseudo
      * @param pseudo utilisateur cherché
      * @return Utilisateur
      */
     User findByPseudo(String pseudo);

     /**
      * Trouve un utilisateur avc son mail
      * @param mail utilisateur cherché
      * @return Utilisateur
      */
     User findByMail(String mail);
}
