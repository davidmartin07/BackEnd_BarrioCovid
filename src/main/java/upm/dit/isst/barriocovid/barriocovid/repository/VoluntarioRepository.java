package upm.dit.isst.barriocovid.barriocovid.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import upm.dit.isst.barriocovid.barriocovid.model.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    
}
