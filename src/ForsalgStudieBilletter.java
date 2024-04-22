public class ForsalgStudieBilletter implements Billet {
    private String billetId;
    private double pris;
    private String studiekortId;

    public ForsalgStudieBilletter(String billetId, String studiekortId, int dageTilEvent) {
        this.billetId = billetId;
        this.studiekortId = studiekortId;
        if (dageTilEvent >= 10) {
            pris = 90 * 0.85; // 15% rabat hvis købt tidligere end 10 dage før event
        } else {
            pris = 90;
        }
    }

    public String getBilletId() {
        return billetId;
    }

    public double getPris() {
        return pris;
    }

    public String getStudiekortId() {
        return studiekortId;
    }

    @Override
    public double beregnPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "BilletIForsalgMedStudierabat - ID: " + billetId + ", Pris: " + pris + " kr (Husk studiekort: " + studiekortId + ")";
    }

    public String getStudiekortID() {
        return studiekortId;
    }
}
