package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import static java.lang.String.format;

@Entity
public class niveauIV {

        @Id
        @Column(
                name = "id_nivau_4"
        )
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long idN4;

        @Column(
                name = "matricule_nivau_4",
                length = 15,
                nullable = false,
                unique = true
        )
        private String matriculeN4;

        @Column(
                name = "noms_nivau_4",
                length = 60,
                nullable = false
        )
        private String nomsN4;

        @Column(
                length = 1
        )
        private String sexeN4;


        private Date date_de_naissanceN4;


        private String lieu_de_naissanceN4;

        @Column(
                length = 15,
                nullable = false
        )
        private String annee_academiqueN4;

        private int niveau_etudeN4;

        @Column(
                length = 130
        )
        private String filiereN4;

        @Column(
                length = 130,
                nullable = false
        )
        private String axeN4;

        private Double moyenneN4;

        private Double credit_acquisN4;

        private String decisionN4;

    public niveauIV() {
    }

    public Long getIdN4() {
        return idN4;
    }

    public void setIdN4(Long idN4) {
        this.idN4 = idN4;
    }

    public String getMatriculeN4() {
        return matriculeN4;
    }

    public void setMatriculeN4(String matriculeN4) {
        this.matriculeN4 = matriculeN4;
    }

    public String getNomsN4() {
        return nomsN4;
    }

    public void setNomsN4(String nomsN4) {
        this.nomsN4 = nomsN4;
    }

    public String getSexeN4() {
        return sexeN4;
    }

    public void setSexeN4(String sexeN4) {
        this.sexeN4 = sexeN4;
    }

    public Date getDate_de_naissanceN4() {
        return date_de_naissanceN4;
    }

    public void setDate_de_naissanceN4(Date date_de_naissanceN4) {
        this.date_de_naissanceN4 = date_de_naissanceN4;
    }

    public String getLieu_de_naissanceN4() {
        return lieu_de_naissanceN4;
    }

    public void setLieu_de_naissanceN4(String lieu_de_naissanceN4) {
        this.lieu_de_naissanceN4 = lieu_de_naissanceN4;
    }

    public String getAnnee_academiqueN4() {
        return annee_academiqueN4;
    }

    public void setAnnee_academiqueN4(String annee_academiqueN4) {
        this.annee_academiqueN4 = annee_academiqueN4;
    }

    public int getNiveau_etudeN4() {
        return niveau_etudeN4;
    }

    public void setNiveau_etudeN4(int niveau_etudeN4) {
        this.niveau_etudeN4 = niveau_etudeN4;
    }

    public String getFiliereN4() {
        return filiereN4;
    }

    public void setFiliereN4(String filiereN4) {
        this.filiereN4 = filiereN4;
    }

    public String getAxeN4() {
        return axeN4;
    }

    public void setAxeN4(String axeN4) {
        this.axeN4 = axeN4;
    }

    public Double getMoyenneN4() {
        return moyenneN4;
    }

    public void setMoyenneN4(Double moyenneN4) {
        this.moyenneN4 = moyenneN4;
    }

    public Double getCredit_acquisN4() {
        return credit_acquisN4;
    }

    public void setCredit_acquisN4(Double credit_acquisN4) {
        this.credit_acquisN4 = credit_acquisN4;
    }

    public String getDecisionN4() {
        return decisionN4;
    }

    public void setDecisionN4(String decisionN4) {
        this.decisionN4 = decisionN4;
    }
}
