package models;


import models.ebean.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Draft on 29.04.2017.
 */

public interface RoleDao extends JpaRepository<Role, Long>{
}
