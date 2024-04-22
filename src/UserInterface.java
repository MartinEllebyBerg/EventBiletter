import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void KørProgram() {
        while (true) {
            System.out.println("Velkommen til billetsystemet!");
            System.out.println("1. Opret ny billet");
            System.out.println("2. Udskriv alle solgte billetter");
            System.out.println("3. Vis antal af hver slags billetter solgt");
            System.out.println("4. Vis studiekortnumre på alle solgte billetter med studierabat");
            System.out.println("5. Afslut programmet");

            int valg = scanner.nextInt();
            scanner.nextLine();
            SolgteBilletter solgteBilletter = new SolgteBilletter();

            switch (valg) {
                case 1:
                    opretBillet(solgteBilletter);
                    break;
                case 2:
                    System.out.println(solgteBilletter);
                    break;
                case 3:
                    visAntalAfHverSlagsBilletter(solgteBilletter);
                    break;
                case 4:
                    System.out.println(solgteBilletter.hentAlleStudiekortId());
                    break;
                case 5:
                    System.out.println("Farvel!");
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private static void opretBillet(SolgteBilletter solgteBilletter) {
        System.out.println("Indtast billettype (1 for døren, 2 for forsalg, 3 for forsalg med studierabat):");
        int billetType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Indtast billet-id:");
        String billetId = scanner.nextLine();

        switch (billetType) {
            case 1:
                solgteBilletter.tilføjBillet(new DørsalgBilletter(billetId));
                break;
            case 2:
                System.out.println("Indtast antal dage til event:");
                int dageTilEvent = scanner.nextInt();
                solgteBilletter.tilføjBillet(new ForsalgBilletter(billetId, dageTilEvent));
                break;
            case 3:
                System.out.println("Indtast studiekort-id:");
                String studiekortId = scanner.nextLine();
                System.out.println("Indtast antal dage til event:");
                int dageTilEventMedStudierabat = scanner.nextInt();
                solgteBilletter.tilføjBillet(new ForsalgStudieBilletter(billetId, studiekortId, dageTilEventMedStudierabat));
                break;
            default:
                System.out.println("Ugyldig billettype.");
        }
    }

    private static void visAntalAfHverSlagsBilletter(SolgteBilletter solgteBilletter) {
        System.out.println("Antal solgte billetter:");
        System.out.println("Billetter i døren: " + solgteBilletter.getAntalBilleterIDøren());
        System.out.println("Billetter i forsalg: " + solgteBilletter.getAntalBilleterForsalg());
        System.out.println("Billetter i forsalg med studierabat: " + solgteBilletter.getAntalBilleterStudierabatForsalg());
    }
}
