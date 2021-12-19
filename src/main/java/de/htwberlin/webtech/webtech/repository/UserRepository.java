package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.RoleEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {


    List<UserEntity> findAllByFirstName(String firstName);
    //UserEntity findUserEntityByLogin(String login);


//    public default UserEntity findUserEntityBy(Long id) {
//        return (new UserEntity("da","aswd","Kolya", "AUE", "Kiev", RoleEntity.ADMIN, null));
//    };


}
