import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorCites gestor = new GestorCites("cites.txt");
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n--- GESTOR DE CITES ---");
            System.out.println("1. Afegir cita");
            System.out.println("2. Llistar cites");
            System.out.println("3. Cancel·lar cita");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();



            switch (opcio) {
                case 1:
                    System.out.print("Nom del client: ");
                    String client = scanner.nextLine();
                    System.out.print("Data i hora (DD/MM/AAAA HH:MM): ");
                    String dataHora = scanner.nextLine();
                    System.out.print("Servei contractat: ");
                    String servei = scanner.nextLine();
                    gestor.afegirCita(new Cita(client, dataHora, servei));
                    break;
                case 2:
                    gestor.llistarCites();
                    break;
                case 3:
                    gestor.llistarCites();
                    System.out.print("Número de cita a cancel·lar: ");
                    int index = scanner.nextInt() - 1;
                    gestor.cancelarCita(index);
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);
        scanner.close();
    }
}