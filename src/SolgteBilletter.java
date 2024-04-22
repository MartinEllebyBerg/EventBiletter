import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolgteBilletter {
    private List<Billet> solgteBilleter;

    public SolgteBilletter() {
        solgteBilleter = new ArrayList<>();
    }

    public void tilføjBillet(Billet billet) {
        solgteBilleter.add(billet);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Solgte Billeter:\n");
        for (Billet billet : solgteBilleter) {
            builder.append(billet.toString()).append("\n");
        }
        return builder.toString();
    }

    public int getAntalBilleterIDøren() {
        int count = 0;
        for (Billet billet : solgteBilleter) {
            if (billet instanceof DørsalgBilletter) {
                count++;
            }
        }
        return count;
    }

    public int getAntalBilleterForsalg() {
        int count = 0;
        for (Billet billet : solgteBilleter) {
            if (billet instanceof ForsalgBilletter) {
                count++;
            }
        }
        return count;
    }

    public int getAntalBilleterStudierabatForsalg() {
        int count = 0;
        for (Billet billet : solgteBilleter) {
            if (billet instanceof ForsalgStudieBilletter) {
                count++;
            }
        }
        return count;
    }

    public String hentAlleStudiekortID() {
        List<String> studiekortIDList = new ArrayList<>();
        for (Billet billet : solgteBilleter) {
            if (billet instanceof ForsalgStudieBilletter) {
                studiekortIDList.add(((ForsalgStudieBilletter) billet).getStudiekortID());
            }
        }
        Collections.sort(studiekortIDList);
        return String.join(",", studiekortIDList);
    }

    public boolean hentAlleStudiekortId() {
        return hentAlleStudiekortId();
    }
}
