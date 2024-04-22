public class ForsalgBilletter implements Billet {
    private String billetId;
    private double pris;
    private int dageTilEvent;

    public ForsalgBilletter (String billetId, int dageTilEvent) {
        this.billetId = billetId;
        this.dageTilEvent = dageTilEvent;
        if (dageTilEvent >= 10) {
            pris = 120 * 0.85; // 15% rabat hvis købt tidligere end 10 dage før event
        } else {
            pris = 120;
        }
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
        return "BilletIForsalg - ID: " + billetId + ", Pris: " + pris + " kr";
    }
}
