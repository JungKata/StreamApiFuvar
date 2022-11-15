public class FuvarPerformat {
    private int taxiAzonosito;
    private String indulasiIdo;
    private int utazasiIdo;
    private int megtettTavolsag;
    private int vetelDij;
    private int borravalo;
    private String fizetesModja;

    public FuvarPerformat(String sor) {
        String[] s = sor.split(";");
        this.taxiAzonosito = Integer.parseInt(s[0]);
        this.indulasiIdo = s[1];
        this.utazasiIdo = Integer.parseInt(s[2]);
        this.megtettTavolsag = Integer.parseInt(s[3]);
        this.vetelDij = Integer.parseInt(s[4]);
        this.borravalo = Integer.parseInt(s[5]);
        this.fizetesModja = s[6];
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

    public int getMegtettTavolsag() {
        return megtettTavolsag;
    }

    public int getVetelDij() {
        return vetelDij;
    }

    public int getBorravalo() {
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



