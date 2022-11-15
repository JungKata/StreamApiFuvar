public class FuvarPerformat {
    private int taxiAzonosito;
    private String indulasiIdo;
    private int utazasiIdo;
    private double megtettTavolsag;
    private double vetelDij;
    private double borravalo;
    private String fizetesModja;

    public FuvarPerformat(String sor) {
        String[] s = sor.replace(",", ".").split(";");
        this.taxiAzonosito = Integer.parseInt(s[0]);
        this.indulasiIdo = s[1];
        this.utazasiIdo = Integer.parseInt(s[2]);
        this.megtettTavolsag = Double.parseDouble(s[3]);
        this.vetelDij = Double.parseDouble(s[4]);
        this.borravalo = Double.parseDouble(s[5]);
        this.fizetesModja = s[6];
    }

    public FuvarPerformat(int taxiAzonosito, String indulasiIdo, int utazasiIdo, double megtettTavolsag, double vetelDij, double borravalo, String fizetesModja) {
        this.taxiAzonosito = taxiAzonosito;
        this.indulasiIdo = indulasiIdo;
        this.utazasiIdo = utazasiIdo;
        this.megtettTavolsag = megtettTavolsag;
        this.vetelDij = vetelDij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public int getTaxiAzonosito() {
        return taxiAzonosito;
    }

    public String getIndulasiIdo() {
        return indulasiIdo;
    }

    public int getUtazasiIdo() {
        return utazasiIdo;
    }

    public double getMegtettTavolsag() {
        return megtettTavolsag;
    }

    public double getVetelDij() {
        return vetelDij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }


    @Override
    public String toString() {
        return "FuvarPerformat: " + "taxiAzonosito= " + taxiAzonosito +
                                    ", indulasiIdo= " + indulasiIdo +
                                    ", utazasiIdo= " + utazasiIdo +
                                    ", megtettTavolsag= " + megtettTavolsag +
                                    ", vetelDij= " + vetelDij +
                                    ", borravalo= " + borravalo +
                                    ", fizetesModja= " + fizetesModja;
    }
}



