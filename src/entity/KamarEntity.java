package entity;

public class KamarEntity {
    private String kodeKamar;
    private String jenisKamar;
    private int hargaPerMalam;
    private boolean Status;

    public KamarEntity(String kodeKamar, String jenisKamar, int hargaPerMalam, boolean Status)
    {
        this.kodeKamar=kodeKamar;
        this.jenisKamar=jenisKamar;
        this.hargaPerMalam=hargaPerMalam;
        this.Status=Status;
    }

    public String getKodeKamar() {
        return kodeKamar;
    }

    public void setKodeKamar(String kodeKamar) {
        this.kodeKamar = kodeKamar;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(int hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }


}
