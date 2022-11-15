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

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static void Beolvasas(String fajlnev) throws IOException{
        fuvarLista = new ArrayList<>();

            FileReader fr = new FileReader(fajlnev);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null){
                FuvarPerformat egy = new FuvarPerformat(sor);
                fuvarLista.add(egy);
                sor = br.readLine();
            }
            br.close();
            fr.close();
    }
}