package net.javaguides.springboot.repository;

import net.javaguides.springboot.enties.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findMoyenneOrderByDecision(String value);

    @Query("SELECT e FROM Etudiant e WHERE e.credit_acquis = ?1 AND e.annee_academique = ?2  AND e.niveau_etude = ?3")
    List<Etudiant> findByCredit(int credit,String annee_etude, int niveau_etude );

    @Query("SELECT p FROM Etudiant p WHERE p.credit_acquis BETWEEN 26 AND 30")
    List<Etudiant> findByCreditSup(Integer credit_acquis);

    @Query("SELECT DISTINCT annee_academique FROM Etudiant")
    List findByAnnee();

    @Query("SELECT DISTINCT niveau_etude FROM Etudiant")
    List findByNiveau();
}
