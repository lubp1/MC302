import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Apartamento extends Moradia{
    private final static long serialVersionUID = 32010L;
    private int andar;
    private int quantidaVagasGaragem;
    private float metragem;
    private float areaUtil;
    private int quantidadeSuite;
    private int quantidadeQuartos;
    private int quantidadeBanheiros;
    private boolean deposito;
    private String descricaoAreaLazer;
    private int quantidadeTorres;
    private int apartamentosPorAndar;

    public Apartamento(float preco, float distanciaUniversidade, String descricaoArredores, Usuario dono, String descricaoDoImovel, String endereco,
                       int andar, int quantidaVagasGaragem, float metragem, float areaUtil, int quantidadeSuite, int quantidadeQuartos,
                       int quantidadeBanheiros, boolean deposito, String descricaoAreaLazer, int quantidadeTorres, int apartamentosPorAndar) {
        super(preco,distanciaUniversidade,descricaoArredores,dono,descricaoDoImovel,endereco);
        this.andar = andar;
        this.quantidaVagasGaragem = quantidaVagasGaragem;
        this.metragem = metragem;
        this.areaUtil = areaUtil;
        this.quantidadeSuite = quantidadeSuite;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.deposito = deposito;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.quantidadeTorres = quantidadeTorres;
        this.apartamentosPorAndar = apartamentosPorAndar;
    }

    public Apartamento(float preco, float distanciaUniversidade, String descricaoArredores, String descricaoDoImovel, String endereco,
                       int andar, int quantidaVagasGaragem, float metragem, float areaUtil, int quantidadeSuite, int quantidadeQuartos,
                       int quantidadeBanheiros, boolean deposito, String descricaoAreaLazer, int quantidadeTorres, int apartamentosPorAndar) {
        super(preco,distanciaUniversidade,descricaoArredores,descricaoDoImovel,endereco);
        this.andar = andar;
        this.quantidaVagasGaragem = quantidaVagasGaragem;
        this.metragem = metragem;
        this.areaUtil = areaUtil;
        this.quantidadeSuite = quantidadeSuite;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.deposito = deposito;
        this.descricaoAreaLazer = descricaoAreaLazer;
        this.quantidadeTorres = quantidadeTorres;
        this.apartamentosPorAndar = apartamentosPorAndar;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getQuantidaVagasGaragem() {
        return quantidaVagasGaragem;
    }

    public void setQuantidaVagasGaragem(int quantidaVagasGaragem) {
        this.quantidaVagasGaragem = quantidaVagasGaragem;
    }

    public float getMetragem() {
        return metragem;
    }

    public void setMetragem(float metragem) {
        this.metragem = metragem;
    }

    public float getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(float areaUtil) {
        this.areaUtil = areaUtil;
    }

    public int getQuantidadeSuite() {
        return quantidadeSuite;
    }

    public void setQuantidadeSuite(int quantidadeSuite) {
        this.quantidadeSuite = quantidadeSuite;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public boolean isDeposito() {
        return deposito;
    }

    public void setDeposito(boolean deposito) {
        this.deposito = deposito;
    }

    public String getDescricaoAreaLazer() {
        return descricaoAreaLazer;
    }

    public void setDescricaoAreaLazer(String descricaoAreaLazer) {
        this.descricaoAreaLazer = descricaoAreaLazer;
    }

    public int getQuantidadeTorres() {
        return quantidadeTorres;
    }

    public void setQuantidadeTorres(int quantidadeTorres) {
        this.quantidadeTorres = quantidadeTorres;
    }

    public int getApartamentosPorAndar() {
        return apartamentosPorAndar;
    }

    public void setApartamentosPorAndar(int apartamentosPorAndar) {
        this.apartamentosPorAndar = apartamentosPorAndar;
    }

    @Override
    public String toString() {
        return "\nApartamento{" +
                "\nAndar = " + andar +
                ", \nQuantidade de Vagas de Garagem = " + quantidaVagasGaragem +
                ", \nMetragem = " + metragem +
                ", \nArea Util = " + areaUtil +
                ", \nQuantidade de Suites = " + quantidadeSuite +
                ", \nQuantidade de Quartos = " + quantidadeQuartos +
                ", \nQuantidade de Banheiros = " + quantidadeBanheiros +
                ", \nDeposito = " + deposito +
                ", \nDescricao da Area de Lazer = '" + descricaoAreaLazer + '\'' +
                ", \nQuantidade de Torres = " + quantidadeTorres +
                ", \nApartamentos Por Andar = " + apartamentosPorAndar +
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
        Apartamento saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Apartamento) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
