package net.javaguides.springboot.enties;


import jakarta.persistence.*;

@Entity
public class Semestre {
    @Id
    @Column(
            name = "semestre_id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "numero_semestre"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int numero;
    private float moyenne;
    private int credit_acquis;
    private String decision;

    public Semestre() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getMoyenne() {
        return this.moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public int getCredit_acquis() {
        return this.credit_acquis;
    }

    public void setCredit_acquis(int credit_acquis) {
        this.credit_acquis = credit_acquis;
    }

    public String getDecision() {
        return this.decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String toString() {
        return String.format("Invoice{id=%d, numero=%d, moyenne=%s, credit_acquis=%d, decision='%s'}", this.id, this.numero, this.moyenne, this.credit_acquis, this.decision);
    }
}