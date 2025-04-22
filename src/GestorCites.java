import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCites {
    private List<Cita> cites;
    private String fitxerCites;

    public GestorCites(String fitxerCites) {
        this.fitxerCites = fitxerCites;
        this.cites = new ArrayList<>();
        carregarCites();
    }

    public void afegirCita(Cita cita) {
        cites.add(cita);
        guardarCites();
    }

    public void cancelarCita(int index) {
        if (index >= 0 && index < cites.size()) {
            cites.remove(index);
            guardarCites();
        }
    }

    public void llistarCites() {
        int i = 0;
        if (cites.isEmpty()) {
            System.out.println("No hi ha cites registrades.");
            return;
        }
        while (i < cites.size()) {
            System.out.println((i + 1) + ". " + cites.get(i));
            i++;
        }
    }

    private void carregarCites() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("cites.txt"))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                if (parts.length == 3) {
                    cites.add(new Cita(parts[0], parts[1], parts[2]));
                }

            }
        } catch (IOException e) {
            System.out.println("No s'ha trobat el fitxer de cites. Es crearà un de nou.");
        }
    }

    private void guardarCites() {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(fitxerCites))) {
            for (Cita cita : cites) {
                pw.println(cita.getClient() + ";" +
                        cita.getDataHora() + ";" +
                        cita.getServei());
            }
        } catch (IOException e) {
            System.out.println(
                    "Error en desar les cites: " + e.getMessage());
        }
    }
}