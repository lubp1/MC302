import java.io.*;

public class Locador implements Arquivo, Serializable {
    private static final long serialVersionUID = 3204L;
    private int anoGraduacao;
    private boolean dividirQuarto;
    private float precoMin;
    private float precoMax;
    private float distMin;
    private float distMax;
    private boolean temAnimais;

    public Locador(int anoGraduacao, boolean dividirQuarto,
                   float precoMin, float precoMax, float distMin, float distMax, boolean temAnimais) {
        this.anoGraduacao = anoGraduacao;
        this.dividirQuarto = dividirQuarto;
        this.precoMin = precoMin;
        this.precoMax = precoMax;
        this.distMin = distMin;
        this.distMax = distMax;
        this.temAnimais = temAnimais;
    }
    public Locador() {
        this.anoGraduacao = 2;
        this.dividirQuarto = true;
        this.precoMin = 0;
        this.precoMax = 10000000;
        this.distMin = 0;
        this.distMax = 10000000;
        this.temAnimais = false;
    }

    public int getAnoGraduacao() { return anoGraduacao; }
    public void setAnoGraduacao(int anoGraduacao) { this.anoGraduacao = anoGraduacao; }
    public boolean isDividirQuarto() { return dividirQuarto; }
    public void setDividirQuarto(boolean dividirQuarto) { this.dividirQuarto = dividirQuarto; }
    public float getPrecoMin() { return precoMin; }
    public void setPrecoMin(float precoMin) { this.precoMin = precoMin; }
    public float getPrecoMax() { return precoMax; }
    public void setPrecoMax(float precoMax) { this.precoMax = precoMax; }
    public float getDistMin() { return distMin; }
    public void setDistMin(float distMin) { this.distMin = distMin; }
    public float getDistMax() { return distMax; }
    public void setDistMax(float distMax) { this.distMax = distMax; }
    public boolean getTemAnimais() { return temAnimais; }
    public void setTemAnimais(boolean temAnimais) { this.temAnimais = temAnimais; }


    public String toString() {
        return "\nLocador{" +
                "\nAno de Graduacao = " + anoGraduacao +
                ", \nDividir Quarto = " + dividirQuarto +
                ", \nPreco Minimo = " + precoMin +
                ", \nPreco Maximo = " + precoMax +
                ", \nDistancia Minima = " + distMin +
                ", \nDistancia Maxima = " + distMax +
                ", \nTem Animais = " + temAnimais +
                '}';
    }

    public void salvarEmArquivo(String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename,true));
            out.writeObject(this);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Arquivo carregarDoArquivo(String filename) {
        Locador saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Locador) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
