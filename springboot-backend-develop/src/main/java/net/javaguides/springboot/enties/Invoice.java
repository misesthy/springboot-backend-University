package net.javaguides.springboot.enties;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
public class Invoice {
    @Id
    @Column(
            name = "invoice_id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private LocalDate date = LocalDate.now();
    @ElementCollection
    private Map<Semestre, String> semestreGroup;
    private int total;

    public Invoice() {
        //generer une date lorsque l'on creait la facture
        //this.date = LocalDate.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<Semestre, String> getSemestreGroup() {
        return this.semestreGroup;
    }

    public void setSemestreGroup(Map<Semestre, String> semestreGroup) {
        this.semestreGroup = semestreGroup;
        semestreGroup.forEach((semestre, string) -> {
            this.total += semestre.getCredit_acquis();
        });
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String toString() {
        return String.format("\n\nInvoice{id=%d, date=%s, \nsemestreGroup=%s, \ntotal=%d'}", this.id, this.date, this.semestreGroup, this.total);
    }
}
