package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import static java.lang.String.format;


@Entity
public class Etudiant {

    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            name = "etudiant_matricule",
            length = 15,
            nullable = false,
            unique = true
    )
    private String matricule;

    @Column(
            name = "noms",
            length = 60,
            nullable = false
    )
    private String noms;

    @Column(
            length = 1
    )
    private String sexe;


    private Date date_de_naissance;


    private String lieu_de_naissance;

    @Column(
            length = 15,
            nullable = false
    )
    private String annee_academique;

    private int niveau_etude;

    @Column(
            length = 130
    )
    private String filiere;

    @Column(
            length = 130,
            nullable = false
    )
    private String axe;

    private Double moyenne;

    private Double credit_acquis;

    private String decision;

    public Etudiant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public void setLieu_de_naissance(String lieu_de_naissance) {
        this.lieu_de_naissance = lieu_de_naissance;
    }

    public String getAnnee_academique() {
        return annee_academique;
    }

    public void setAnnee_academique(String annee_academique) {
        this.annee_academique = annee_academique;
    }

    public int getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(int niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getAxe() {
        return axe;
    }

    public void setAxe(String axe) {
        this.axe = axe;
    }

    public Double getMoyenne() {
        return this.moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public Double getCredit_acquis() {
        return this.credit_acquis;
    }

    public void setCredit_acquis(Double credit_acquis) {
        this.credit_acquis = credit_acquis;
    }

    public String getDecision() {
        return this.decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

}

