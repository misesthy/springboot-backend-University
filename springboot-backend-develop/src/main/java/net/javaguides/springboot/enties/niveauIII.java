package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;

import java.util.List;

import static java.lang.String.format;

@Entity
public class niveauIII {

        @Id
        @Column(
                name = "id_niveau_3"
        )
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long id_n3;

        @Column(
                name = "matricule_niveau_3",
                length = 15,
                nullable = false,
                unique = true
        )
        private String matriculeN3;

        @Column(
                name = "noms_niveau_3",
                length = 60,
                nullable = false
        )
        private String nomsN3;

        @Column(
                length = 1
        )
        private String sexeN3;


        private Date date_de_naissanceN3;


        private String lieu_de_naissanceN3;

        @Column(
                length = 15,
                nullable = false
        )
        private String annee_academiqueN3;

        private int niveau_etudeN3;

        @Column(
                length = 130
        )
        private String filiereN3;

        @Column(
                length = 130,
                nullable = false
        )
        private String axeN3;

        private Double moyenneN3;

        private Double credit_acquisN3;

        private String decisionN3;

    public niveauIII() {
    }

    public Long getId_n3() {
            return id_n3;
        }

        public void setId_n3(Long id_n3) {
            this.id_n3 = id_n3;
        }

        public String getMatriculeN3() {
            return matriculeN3;
        }

        public void setMatriculeN3(String matriculeN3) {
            this.matriculeN3 = matriculeN3;
        }

        public String getNomsN3() {
            return nomsN3;
        }

        public void setNomsN3(String nomsN3) {
            this.nomsN3 = nomsN3;
        }

        public String getSexeN3() {
            return sexeN3;
        }

        public void setSexeN3(String sexeN3) {
            this.sexeN3 = sexeN3;
        }

        public Date getDate_de_naissanceN3() {
            return date_de_naissanceN3;
        }

        public void setDate_de_naissanceN3(Date date_de_naissanceN3) {
            this.date_de_naissanceN3 = date_de_naissanceN3;
        }

        public String getLieu_de_naissanceN3() {
            return lieu_de_naissanceN3;
        }

        public void setLieu_de_naissanceN3(String lieu_de_naissanceN3) {
            this.lieu_de_naissanceN3 = lieu_de_naissanceN3;
        }

        public String getAnnee_academiqueN3() {
            return annee_academiqueN3;
        }

        public void setAnnee_academiqueN3(String annee_academiqueN3) {
            this.annee_academiqueN3 = annee_academiqueN3;
        }

        public int getNiveau_etudeN3() {
            return niveau_etudeN3;
        }

        public void setNiveau_etudeN3(int niveau_etudeN3) {
            this.niveau_etudeN3 = niveau_etudeN3;
        }

        public String getFiliereN3() {
            return filiereN3;
        }

        public void setFiliereN3(String filiereN3) {
            this.filiereN3 = filiereN3;
        }

        public String getAxeN3() {
            return axeN3;
        }

        public void setAxeN3(String axeN3) {
            this.axeN3 = axeN3;
        }

        public Double getMoyenneN3() {
            return moyenneN3;
        }

        public void setMoyenneN3(Double moyenneN3) {
            this.moyenneN3 = moyenneN3;
        }

        public Double getCredit_acquisN3() {
            return credit_acquisN3;
        }

        public void setCredit_acquisN3(Double credit_acquisN3) {
            this.credit_acquisN3 = credit_acquisN3;
        }

        public String getDecisionN3() {
            return decisionN3;
        }

        public void setDecisionN3(String decisionN3) {
            this.decisionN3 = decisionN3;
        }


}
