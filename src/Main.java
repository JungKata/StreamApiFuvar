import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<FuvarPerformat> fuvarLista;

    public static void main(String[] args) {

        String fajlNev = "fuvar.csv";
        try {
            Beolvasas(fajlNev);
            UtazsokSzáma();
            TaxisoforBevetel();
            Merfold();
            LegHosszabbFuvar();
            BokezuBorravalo();
            Kilometer();
            HibasAdataok();
            SzerepelE();
            LegrovidebbUtazas();
            Karacsony();
            Szilveszter();


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
        System.out.println("1.Feladat:\n" + "Utazások száma: " + (long) fuvarLista.size() + "db volt");
    }

    private static void Merfold(){
        System.out.println("3.Feladat: \n" + "Taxisok összesen megtett mérföldje: " + fuvarLista.stream().mapToDouble(FuvarPerformat::getMegtettTavolsag).sum() + " mérföld");
    }

    private static void LegHosszabbFuvar(){
        System.out.println("4.Feladat: \n" + "Leghoszabb fuvar (időben) mért adatai: " + fuvarLista.stream().max(Comparator.comparing(FuvarPerformat :: getUtazasiIdo)).get());
    }

    private static void BokezuBorravalo(){
        System.out.println("5.Feladat: \n" + "Legbőkezűbb borravaló fuvar adatai: " + fuvarLista.stream().max(Comparator.comparingDouble(FuvarPerformat::getBorravalo)).get());
    }

    private static void Kilometer(){

        System.out.println("6.Feladat: \n" + "4261-es azonosítójú taxis összesen megtett útja kilométerben: " + fuvarLista.stream().filter(fuvarLista -> fuvarLista.getTaxiAzonosito() == 4261).mapToDouble(FuvarPerformat:: KilometerSzamitas).sum() +  " km");
    }

    private static void HibasAdataok(){
        List<FuvarPerformat> filter = fuvarLista.stream().filter(fuvarLista -> fuvarLista.getMegtettTavolsag() == 0).collect(Collectors.toList()).stream().filter(fNull -> fNull.getVetelDij() >0.0 || fNull.getBorravalo()>0.0).collect(Collectors.toList());


        System.out.println("7.Feladat: \n" + "Hibás sorok adatai:"+filter ) ;
    }

    private static void SzerepelE(){
        System.out.println("8.Feladat: \n" + "Az 1452 taxi: " +
                (fuvarLista.stream().anyMatch(fuvarLista -> fuvarLista.getTaxiAzonosito() == 1452)? "igen" : "nem"));
    }

    private static void LegrovidebbUtazas(){
        System.out.println("9.Feladat: \n" + "A 3 legrövidebb utazás: " + fuvarLista.stream().filter(fuvarLista -> fuvarLista.getUtazasiIdo() > 0).sorted(Comparator.comparingDouble(FuvarPerformat :: getUtazasiIdo)).limit(3).collect(Collectors.toList()));
    }

    private static void Karacsony(){
        System.out.println("10.Feladat: \n" + "December 24.-i fuvarok száma: " + fuvarLista.stream().filter(fuvarLista -> fuvarLista.getIndulasiIdo().contains("2016-12-24")).count() + " db");
    }

    private static void Szilveszter(){
        double kapottBorravalot = fuvarLista.stream().filter(fuvarLista -> fuvarLista.getIndulasiIdo().contains("2016-12-31")).collect(Collectors.toList()).stream().filter(fuvarLista -> fuvarLista.getBorravalo() > 0).collect(Collectors.toList()).size();
        double sum = fuvarLista.stream().filter(fuvarLista -> fuvarLista.getIndulasiIdo().contains("2016-12-31")).collect(Collectors.toList()).size();
        double szam = (kapottBorravalot/sum)*100;
        System.out.printf("Kapott borravalo: %f, Fuvarok száma:  %f, Aranya: %f", kapottBorravalot, sum, szam);
        System.out.println("11.Feladat: \n" + "Borravalók aranya:" + szam + " %");


    }
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
