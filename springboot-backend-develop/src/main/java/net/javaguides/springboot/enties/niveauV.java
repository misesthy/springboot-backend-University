package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;

import java.util.List;

import static java.lang.String.format;

@Entity
public class niveauV {

        @Id
        @Column(
                name = "id_niveau_5"
        )
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long idN5;

        @Column(
                name = "matricule_niveau_5",
                length = 15,
                nullable = false,
                unique = true
        )
        private String matriculeN5;

        @Column(
                name = "noms_niveau_5",
                length = 60,
                nullable = false
        )
        private String nomsN5;

        @Column(
                length = 1
        )
        private String sexeN5;


        private Date date_de_naissanceN5;


        private String lieu_de_naissanceN5;

        @Column(
                length = 15,
                nullable = false
        )
        private String annee_academiqueN5;

        private int niveau_etudeN5;

        @Column(
                length = 130
        )
        private String filiereN5;

        @Column(
                length = 130,
                nullable = false
        )
        private String axeN5;

        private Double moyenneN5;

        private Double credit_acquisN5;

        private String decisionN5;

    public niveauV() {
    }

    public Long getIdN5() {
        return idN5;
    }

    public void setIdN5(Long idN5) {
        this.idN5 = idN5;
    }

    public String getMatriculeN5() {
        return matriculeN5;
    }

    public void setMatriculeN5(String matriculeN5) {
        this.matriculeN5 = matriculeN5;
    }

    public String getNomsN5() {
        return nomsN5;
    }

    public void setNomsN5(String nomsN5) {
        this.nomsN5 = nomsN5;
    }

    public String getSexeN5() {
        return sexeN5;
    }

    public void setSexeN5(String sexeN5) {
        this.sexeN5 = sexeN5;
    }

    public Date getDate_de_naissanceN5() {
        return date_de_naissanceN5;
    }

    public void setDate_de_naissanceN5(Date date_de_naissanceN5) {
        this.date_de_naissanceN5 = date_de_naissanceN5;
    }

    public String getLieu_de_naissanceN5() {
        return lieu_de_naissanceN5;
    }

    public void setLieu_de_naissanceN5(String lieu_de_naissanceN5) {
        this.lieu_de_naissanceN5 = lieu_de_naissanceN5;
    }

    public String getAnnee_academiqueN5() {
        return annee_academiqueN5;
    }

    public void setAnnee_academiqueN5(String annee_academiqueN5) {
        this.annee_academiqueN5 = annee_academiqueN5;
    }

    public int getNiveau_etudeN5() {
        return niveau_etudeN5;
    }

    public void setNiveau_etudeN5(int niveau_etudeN5) {
        this.niveau_etudeN5 = niveau_etudeN5;
    }

    public String getFiliereN5() {
        return filiereN5;
    }

    public void setFiliereN5(String filiereN5) {
        this.filiereN5 = filiereN5;
    }

    public String getAxeN5() {
        return axeN5;
    }

    public void setAxeN5(String axeN5) {
        this.axeN5 = axeN5;
    }

    public Double getMoyenneN5() {
        return moyenneN5;
    }

    public void setMoyenneN5(Double moyenneN5) {
        this.moyenneN5 = moyenneN5;
    }

    public Double getCredit_acquisN5() {
        return credit_acquisN5;
    }

    public void setCredit_acquisN5(Double credit_acquisN5) {
        this.credit_acquisN5 = credit_acquisN5;
    }

    public String getDecisionN5() {
        return decisionN5;
    }

    public void setDecisionN5(String decisionN5) {
        this.decisionN5 = decisionN5;
    }
}
