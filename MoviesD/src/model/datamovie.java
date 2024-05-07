package model;

public class datamovie {
    public String judul;
    public double alur;
    public double penokohan;
    public double akting;
    public double nilai;
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public void setAlur(double alur) {
        this.alur = alur;
    }
    
    public void setPenokohan(double penokohan) {
        this.penokohan = penokohan;
    }
    
    public void setAkting(double akting) {
        this.akting = akting;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public double getAlur() {
        return alur;
    }
    
    // Perhatikan bahwa tidak ada parameter yang diperlukan di sini
    public double getAkting() {
        return akting;
    }
    
    public double getPenokohan() {
        return penokohan;
    }
    
    public double getRating() {
        // Hitung nilai rata-rata, asumsikan semua atribut memiliki rentang nilai yang sama
        nilai = (alur + penokohan + akting) / 3;
        return nilai;
    }
}
