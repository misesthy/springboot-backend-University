package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import static java.lang.String.format;


@Entity
public class Etudiant {
    @Id
    @Column(
            name = "N°"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "etudiant_matricule",
            length = 15,
            nullable = false
    )
    private String matricule;
    @Column(
            name = "Noms_&_Prenoms",
            length = 60,
            nullable = false
    )
    private String noms_prenoms;
    @Column(
            length = 1,
            nullable = false
    )
    private String sexe;
    @Column(
            nullable = false
    )
    private Date date_de_naissance;
    @Column(
            nullable = false
    )
    private String lieu_de_naissance;
    @Column(
            length = 15,
            nullable = false
    )
    private String annee_academique;
    private int niveau_etude;
    @Column(
            length = 130,
            nullable = false
    )
    private String filiere;
    @Column(
            length = 130,
            nullable = false
    )
    private String axe;
    @ManyToMany(
            cascade = {CascadeType.ALL}
    )
    @JoinTable(
            name = "Etudiant_Semestre"
    )
    private List<Invoice> invoices;

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

    public String getNoms_prenoms() {
        return noms_prenoms;
    }

    public void setNoms_prenoms(String noms_prenoms) {
        this.noms_prenoms = noms_prenoms;
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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return String.format("Etudiant{id=%d, matricule='%s', noms_prenoms='%s', sexe='%s', date_de_naissance=%s, lieu_de_naissance='%s', annee_academique='%s', niveau_etude=%d, filiere='%s', axe='%s', invoices=%s}",id, matricule, noms_prenoms, sexe, date_de_naissance, lieu_de_naissance, annee_academique, niveau_etude, filiere, axe, invoices);
    }
}

