import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Pensionato extends Moradia{
    private final static long serialVersionUID = 32016L;
    private float rateio;
    private boolean quartoCompartilhado;
    private int quantidadePessoas;
    private boolean suite;
    private boolean limpezaInclusa;
    private boolean alimentacaoInclusa;

    public Pensionato(float preco, float distanciaUniversidade, String descricaoArredores, Usuario dono, String descricaoDoImovel, String endereco,
                      float rateio, int quantidadePessoas, boolean quartoCompartilhado, boolean suite,
                      boolean limpezaInclusa, boolean alimentacaoInclusa) {
        super(preco,distanciaUniversidade,descricaoArredores,dono,descricaoDoImovel,endereco);
        this.rateio = rateio;
        this.quantidadePessoas = quantidadePessoas;
        this.quartoCompartilhado = quartoCompartilhado;
        this.suite = suite;
        this.limpezaInclusa = limpezaInclusa;
        this.alimentacaoInclusa = alimentacaoInclusa;
    }
    public Pensionato(float preco, float distanciaUniversidade, String descricaoArredores,String descricaoDoImovel, String endereco,
                      float rateio, int quantidadePessoas, boolean quartoCompartilhado, boolean suite,
                      boolean limpezaInclusa, boolean alimentacaoInclusa) {
        super(preco,distanciaUniversidade,descricaoArredores,descricaoDoImovel,endereco);
        this.rateio = rateio;
        this.quantidadePessoas = quantidadePessoas;
        this.quartoCompartilhado = quartoCompartilhado;
        this.suite = suite;
        this.limpezaInclusa = limpezaInclusa;
        this.alimentacaoInclusa = alimentacaoInclusa;
    }

    public float getRateio() {
        return rateio;
    }

    public void setRateio(float rateio) {
        this.rateio = rateio;
    }

    public int getQuantidadePessoas() { return quantidadePessoas; }

    public void setQuantidadePessoas(int quantidadePessoas) { this.quantidadePessoas = quantidadePessoas;  }

    public boolean isQuartoCompartilhado() {
        return quartoCompartilhado;
    }

    public void setQuartoCompartilhado(boolean quartoCompartilhado) {
        this.quartoCompartilhado = quartoCompartilhado;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public boolean isLimpezaInclusa() {
        return limpezaInclusa;
    }

    public void setLimpezaInclusa(boolean limpezaInclusa) {
        this.limpezaInclusa = limpezaInclusa;
    }

    public boolean isAlimentacaoInclusa() {
        return alimentacaoInclusa;
    }

    public void setAlimentacaoInclusa(boolean alimentacaoInclusa) {
        this.alimentacaoInclusa = alimentacaoInclusa;
    }

    @Override
    public String toString() {
        return "\nPensionato{" +
                "\nRateio = " + rateio +
                ", \nQuarto Compartilhado = " + quartoCompartilhado +
                ", \nSuite = " + suite +
                ", \nLimpeza Inclusa = " + limpezaInclusa +
                ", \nAlimentacao Inclusa = " + alimentacaoInclusa +
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
        Pensionato saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Pensionato) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
