package net.javaguides.springboot.repository;

import net.javaguides.springboot.enties.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
