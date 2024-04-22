public class DørsalgBilletter implements Billet {

    private String billetId;
    private double pris = 150;

    public DørsalgBilletter(String billetId) {
        this.billetId = billetId;
    }

    public String getBilletId() {
        return billetId;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public double beregnPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "BilletIDøren - ID: " + billetId + ", Pris: " + pris + " kr";
    }
}

