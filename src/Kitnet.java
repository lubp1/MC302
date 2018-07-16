import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Kitnet extends Moradia{
    private final static long serialVersionUID = 32014L;
    private boolean vagaCarro;
    private boolean contaLuz;
    private boolean contaAgua;
    private boolean contaInternet;
    private boolean mobiliado;
    private boolean aceitaAnimal;

    public Kitnet(float preco, float distanciaUniversidade, String descricaoArredores, Usuario dono, String descricaoDoImovel, String endereco,
                  boolean vagaCarro, boolean contaLuz, boolean contaAgua,
                  boolean contaInternet, boolean mobiliado, boolean aceitaAnimal) {
        super(preco,distanciaUniversidade,descricaoArredores,dono,descricaoDoImovel,endereco);
        this.vagaCarro = vagaCarro;
        this.contaLuz = contaLuz;
        this.contaAgua = contaAgua;
        this.contaInternet = contaInternet;
        this.mobiliado = mobiliado;
        this.aceitaAnimal = aceitaAnimal;
    }
    public Kitnet(float preco, float distanciaUniversidade, String descricaoArredores, String descricaoDoImovel, String endereco,
                  boolean vagaCarro, boolean contaLuz, boolean contaAgua,
                  boolean contaInternet, boolean mobiliado, boolean aceitaAnimal) {
        super(preco,distanciaUniversidade,descricaoArredores,descricaoDoImovel,endereco);
        this.vagaCarro = vagaCarro;
        this.contaLuz = contaLuz;
        this.contaAgua = contaAgua;
        this.contaInternet = contaInternet;
        this.mobiliado = mobiliado;
        this.aceitaAnimal = aceitaAnimal;
    }


    public boolean isVagaCarro() {
        return vagaCarro;
    }

    public void setVagaCarro(boolean vagaCarro) {
        this.vagaCarro = vagaCarro;
    }

    public boolean isContaLuz() {
        return contaLuz;
    }

    public void setContaLuz(boolean contaLuz) {
        this.contaLuz = contaLuz;
    }

    public boolean isContaAgua() {
        return contaAgua;
    }

    public void setContaAgua(boolean contaAgua) {
        this.contaAgua = contaAgua;
    }

    public boolean isContaInternet() {
        return contaInternet;
    }

    public void setContaInternet(boolean contaInternet) {
        this.contaInternet = contaInternet;
    }

    public boolean isMobiliado() {
        return mobiliado;
    }

    public void setMobiliado(boolean mobiliado) {
        this.mobiliado = mobiliado;
    }

    public boolean isAceitaAnimal() {
        return aceitaAnimal;
    }

    public void setAceitaAnimal(boolean aceitaAnimal) {
        this.aceitaAnimal = aceitaAnimal;
    }

    @Override
    public String toString() {
        return "\nKitnet{" +
                "\nVagas de Carro = " + vagaCarro +
                ", \nConta de Luz = " + contaLuz +
                ", \nConta de Agua = " + contaAgua +
                ", \nConta de Internet = " + contaInternet +
                ", \nMobiliado = " + mobiliado +
                ", \nAceita Animal = " + aceitaAnimal +
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
        Kitnet saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Kitnet) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
