import java.io.*;

public class Casa extends Moradia {
    private final static long serialVersionUID = 32012L;
    private int quantidadeQuartos;
    private int quantidadeSuites;
    private int quantidadeBanheiros;
    private int quantidadeVagasCarro;
    private String descricaoAreaLazer;
    private float metragem;

    public Casa(float preco, float distanciaUniversidade, String descricaoArredores,
                Usuario dono, String descricaoDoImovel, String endereco, int quantidadeQuartos, int quantidadeSuites,
                int quantidadeBanheiros, int quantidadeVagasCarro, String descricaoAreaLazer, float metragem) {
        super(preco,distanciaUniversidade,descricaoArredores,dono, descricaoDoImovel,endereco);
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeVagasCarro = quantidadeVagasCarro;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.metragem = metragem;
    }
    public Casa(float preco, float distanciaUniversidade, String descricaoArredores,
                String descricaoDoImovel, String endereco, int quantidadeQuartos, int quantidadeSuites,
                int quantidadeBanheiros, int quantidadeVagasCarro, String descricaoAreaLazer, float metragem) {
        super(preco,distanciaUniversidade,descricaoArredores,descricaoDoImovel,endereco);
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeVagasCarro = quantidadeVagasCarro;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.metragem = metragem;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(int quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public int getQuantidadeVagasCarro() {
        return quantidadeVagasCarro;
    }

    public void setQuantidadeVagasCarro(int quantidadeVagasCarro) {
        this.quantidadeVagasCarro = quantidadeVagasCarro;
    }

    public String getDescricaoAreaLazer() {
        return descricaoAreaLazer;
    }

    public void setDescricaoAreaLazer(String descricaoAreaLazer) {
        this.descricaoAreaLazer = descricaoAreaLazer;
    }

    public float getMetragem() {
        return metragem;
    }

    public void setMetragem(float metragem) {
        this.metragem = metragem;
    }

    @Override
    public String toString() {
        return "\nCasa{" +
                "\nQuantidade de Quartos = " + quantidadeQuartos +
                ", \nQuantidade de Suites = " + quantidadeSuites +
                ", \nQuantidade de Banheiros = " + quantidadeBanheiros +
                ", \nQuantidade de Vagas de Carro = " + quantidadeVagasCarro +
                ", \nDescricao da Area de Lazer = '" + descricaoAreaLazer + '\'' +
                ", \nMetragem = " + metragem +
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
        Casa saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Casa) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
