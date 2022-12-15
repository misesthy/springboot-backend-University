package net.javaguides.springboot.repository;

import net.javaguides.springboot.enties.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findMoyenneOrderByDecision(String value);


    
}
