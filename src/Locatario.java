import java.io.*;
import java.util.ArrayList;

public class Locatario implements Arquivo, Serializable{
    private final static long serialVersionUID = 3206L;
    private ArrayList<Moradia> moradias;

    public Locatario() {
        this.moradias = new ArrayList<Moradia>();
    }

    public void adicionarMoradia(Moradia moradia) {
        moradias.add(moradia);
    }
    public void removerMoradia(Moradia moradia) throws ExcecaoImobiliaria {
        if(!moradias.contains(moradia)){
            throw new ExcecaoImobiliaria("ERRO NA REMOCAO",new ExcecaoImobiliaria("NAO ACHOU NO VETOR A MORADIA PARA A REMOCAO   "));

        }
        else
        moradias.remove(moradia);
    }

    public void removerMoradia(int i) {
        moradias.remove(i);
    }

    public ArrayList<Moradia> getMoradias() {
        return moradias;
    }

    public int getNumMoradias() {
        return moradias.size();
    }

    @Override
    public String toString() {
        return "\nLocatario{" +
                "\nMoradia = " + moradias.toString() +
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
        Locatario saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Locatario) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
