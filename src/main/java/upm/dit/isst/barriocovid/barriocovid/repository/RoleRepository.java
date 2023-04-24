package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    List<Role> findByRoleId(Long roleId);

    @Query("select r from Role r where r.roleId=?1")
    Role findOneRole(Long roleId);

    Role findByNombre(String nombre);
    
}
