package net.javaguides.springboot.enties;

public class CreditFieldresponse {
    private String annee;
    private int niveau;
    private Double credits;
    private Double moyennne;

    public CreditFieldresponse(String annee, int niveau, Double credits, Double moyennne) {
        this.annee = annee;
        this.niveau = niveau;
        this.credits = credits;
        this.moyennne = moyennne;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Double getMoyennne() {
        return moyennne;
    }

    public void setMoyennne(Double moyennne) {
        this.moyennne = moyennne;
    }
}
