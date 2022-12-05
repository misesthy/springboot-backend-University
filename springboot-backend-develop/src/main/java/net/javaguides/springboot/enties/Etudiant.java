package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Etudiant {
    @Id
    @Column(
            name = "etudiant_id"
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
            name = "last_name",
            length = 30,
            nullable = false
    )
    private String lastName;
    @Column(
            name = "first_name",
            length = 30,
            nullable = true
    )
    private String firstName;
    @Column(
            length = 1,
            nullable = false
    )
    private String sex;
    @Column(
            nullable = false
    )
    private Date date_of_birth;
    @Column(
            length = 20,
            nullable = false
    )
    private String place_of_birth;
    @Column(
            length = 15,
            nullable = false
    )
    private String academic_year;
    private int level_of_study;
    @Column(
            length = 130,
            nullable = false
    )
    private String faculty;
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
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate_of_birth() {
        return this.date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPlace_of_birth() {
        return this.place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getAcademic_year() {
        return this.academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public int getLevel_of_study() {
        return this.level_of_study;
    }

    public void setLevel_of_study(int level_of_study) {
        this.level_of_study = level_of_study;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getAxe() {
        return this.axe;
    }

    public void setAxe(String axe) {
        this.axe = axe;
    }

    public List<Invoice> getInvoices() {
        return this.invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String toString() {
        return String.format("Etudiant{id=%d, matricule='%s', lastName='%s', firstName='%s', sex='%s', date_of_birth='%s', place_of_birth='%s', academic_year='%s', level_of_study=%d, faculty='%s', axe='%s', invoices=%s}", this.id, this.matricule, this.lastName, this.firstName, this.sex, this.date_of_birth, this.place_of_birth, this.academic_year, this.level_of_study, this.faculty, this.axe, this.invoices);
    }
}

