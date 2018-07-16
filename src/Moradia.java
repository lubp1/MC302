import java.io.Serializable;

public abstract class Moradia implements Arquivo, Serializable {
    private final static long serialVersionUID = 3208L;
    private int id;
    private float preco;
    private float distanciaUniversidade;
    private String descricaoArredores;
    private Usuario dono;
    private String DescricaoDoImovel;
    private String endereco;
    private static int geradorId = 0;

    public Moradia(float preco, float distanciaUniversidade, String descricaoArredores,
                   Usuario dono, String descricaoDoImovel, String endereco) {
        this.id = geradorId++;
        this.preco = preco;
        this.distanciaUniversidade = distanciaUniversidade;
        this.descricaoArredores = descricaoArredores;
        this.dono = dono;
        DescricaoDoImovel = descricaoDoImovel;
        this.endereco = endereco;
    }

    public Moradia(float preco, float distanciaUniversidade, String descricaoArredores,
                    String descricaoDoImovel, String endereco) {
        this.id = geradorId++;
        this.preco = preco;
        this.distanciaUniversidade = distanciaUniversidade;
        this.descricaoArredores = descricaoArredores;
        DescricaoDoImovel = descricaoDoImovel;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getLocatario() {
        return dono;
    }

    public void setLocatario(Usuario dono) {
        this.dono = dono;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getDistanciaUniversidade() {
        return distanciaUniversidade;
    }

    public void setDistanciaUniversidade(float distanciaUniversidade) {
        this.distanciaUniversidade = distanciaUniversidade;
    }

    public String getDescricaoArredores() {
        return descricaoArredores;
    }

    public void setDescricaoArredores(String descricaoArredores) {
        this.descricaoArredores = descricaoArredores;
    }

    public String getDescricaoDOImovel() {
        return DescricaoDoImovel;
    }

    public void setDescricaoDOImovel(String descricaoDOImovel) {
        DescricaoDoImovel = descricaoDOImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nMoradia{" +
                "\nPreco = " + preco +
                ", \nDistancia da Universidade = " + distanciaUniversidade +
                ", \nDescricao dos Arredores = '" + descricaoArredores + '\'' +
                ", \nDono = " + dono +
                ", \nDescricao do Imovel = '" + DescricaoDoImovel + '\'' +
                ", \nEndereco = '" + endereco + '\'' +
                '}';
    }


    public abstract void salvarEmArquivo(String filename);
}

