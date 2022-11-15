import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<FuvarPerformat> fuvarLista;

    public static void main(String[] args) {

        String fajlNev = "fuvar.csv";
        try {
            Beolvasas(fajlNev);
            UtazsokSzáma();
            TaxisoforBevetel();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    private static void TaxisoforBevetel() {
        System.out.println("2.Feladat:\n" + "6185-ös azonosítójú taxisnak a fuvarainak száma: "
                + fuvarLista.stream().filter(fuvarLista -> fuvarLista.getTaxiAzonosito() == 6185).count() + "db\n" +
                " bevétele:  " + fuvarLista.stream().filter(fuvarLista -> fuvarLista.getTaxiAzonosito() == 6185).mapToDouble(FuvarPerformat::getBevetel).sum() + "$" );
    }

    private static void UtazsokSzáma() {
        System.out.println("1.Feladat:\n" + "Utazások száma: " +  fuvarLista.stream().count() + "db volt");
    }

    //private static void

    public static void Beolvasas (String fajlnev) throws IOException {
            fuvarLista = new ArrayList<>();

            FileReader fr = new FileReader(fajlnev);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                FuvarPerformat egy = new FuvarPerformat(sor);
                fuvarLista.add(egy);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        }


    }
