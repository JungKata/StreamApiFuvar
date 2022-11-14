import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fuvar {

    private List<FuvarPerformat> fuvarLista;

    public Fuvar(String fajlNev){
        fuvarLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null){
                fuvarLista.add(new FuvarPerformat(sor));
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
