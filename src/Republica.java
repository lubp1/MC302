import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Republica extends Moradia{
    private final static long serialVersionUID = 32018L;
    private boolean aceitaFesta;
    private boolean aceitaAnimal;
    private int quantidadePessoas;
    private int hospedePorPessoa;
    private boolean banheiroCompartilhado;
    private String descricaoAreaLazer;
    private float rateio;

    public Republica(float preco, float distanciaUniversidade, String descricaoArredores, Usuario dono, String descricaoDoImovel, String endereco,
                     boolean aceitaFesta, boolean aceitaAnimal, int quantidadePessoas, int hospedePorPessoa,
                     boolean banheiroCompartilhado, String descricaoAreaLazer, float rateio) {
        super(preco,distanciaUniversidade,descricaoArredores,dono,descricaoDoImovel,endereco);
        this.aceitaFesta = aceitaFesta;
        this.aceitaAnimal = aceitaAnimal;
        this.quantidadePessoas = quantidadePessoas;
        this.hospedePorPessoa = hospedePorPessoa;
        this.banheiroCompartilhado = banheiroCompartilhado;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.rateio = rateio;
    }
    public Republica(float preco, float distanciaUniversidade, String descricaoArredores, String descricaoDoImovel, String endereco,
                     boolean aceitaFesta, boolean aceitaAnimal, int quantidadePessoas, int hospedePorPessoa,
                     boolean banheiroCompartilhado, String descricaoAreaLazer, float rateio) {
        super(preco,distanciaUniversidade,descricaoArredores,descricaoDoImovel,endereco);
        this.aceitaFesta = aceitaFesta;
        this.aceitaAnimal = aceitaAnimal;
        this.quantidadePessoas = quantidadePessoas;
        this.hospedePorPessoa = hospedePorPessoa;
        this.banheiroCompartilhado = banheiroCompartilhado;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.rateio = rateio;
    }

    public boolean isAceitaFesta() {
        return aceitaFesta;
    }

    public void setAceitaFesta(boolean aceitaFesta) {
        this.aceitaFesta = aceitaFesta;
    }

    public boolean isAceitaAnimal() {
        return aceitaAnimal;
    }

    public void setAceitaAnimal(boolean aceitaAnimal) {
        this.aceitaAnimal = aceitaAnimal;
    }

    public int getQuantidadePessoas() { return quantidadePessoas; }

    public void setQuantidadePessoas(int quantidadePessoas) { this.quantidadePessoas = quantidadePessoas; }

    public int getHospedePorPessoa() {
        return hospedePorPessoa;
    }

    public void setHospedePorPessoa(int hospedePorPessoa) {
        this.hospedePorPessoa = hospedePorPessoa;
    }

    public boolean isBanheiroCompartilhado() {
        return banheiroCompartilhado;
    }

    public void setBanheiroCompartilhado(boolean banheiroCompartilhado) {
        this.banheiroCompartilhado = banheiroCompartilhado;
    }

    public String getDescricaoAreaLazer() {
        return descricaoAreaLazer;
    }

    public void setDescricaoAreaLazer(String descricaoAreaLazer) {
        this.descricaoAreaLazer = descricaoAreaLazer;
    }

    public float getRateio() {
        return rateio;
    }

    public void setRateio(float rateio) {
        this.rateio = rateio;
    }

    @Override
    public String toString() {
        return "\nRepublica{" +
                "\nAceita Festa = " + aceitaFesta +
                ", \nAceita Animal = " + aceitaAnimal +
                ", \nHospede Por Pessoa = " + hospedePorPessoa +
                ", \nBanheiro Compartilhado = " + banheiroCompartilhado +
                ", \nDescricao da Area de Lazer = '" + descricaoAreaLazer + '\'' +
                ", \nRateio = " + rateio +
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
        Republica saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Republica) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
