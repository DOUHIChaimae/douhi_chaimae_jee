package ma.enset.ebankingbackend.security.repositories;


import ma.enset.ebankingbackend.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {

    AppRole findByRoleName(String rolename);


}
