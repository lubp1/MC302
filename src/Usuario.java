import java.io.*;
import java.util.ArrayList;

public class Usuario implements Arquivo, Serializable {
    private static final long serialVersionUID = 3202L;
    private final String nome;
    private final String cpf;
    private String login;
    private String senha;
    private String email;
    private ArrayList<Pagamento> formasPagamento;
    private Locatario locatario;
    private Locador locador;

    public Usuario(String nome, String cpf, String login,
                   String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.email = email;
        formasPagamento = new ArrayList<Pagamento>();
        locatario = new Locatario();
        locador = new Locador();
    }
    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        formasPagamento = new ArrayList<Pagamento>();
        locatario = new Locatario();
    }
    public Usuario() {
        this.nome = "";
        this.cpf = "";
        this.login = "";
        this.senha = "";
        this.email = "";
        formasPagamento = new ArrayList<Pagamento>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nUsuario{" +
                "\nNome = '" + nome + '\'' +
                ", \nCPF = '" + cpf + '\'' +
                ", \nLogin = '" + login + '\'' +
                ", \nSenha = '" + senha + '\'' +
                ", \nEmail = '" + email + '\'' +
                '}';
    }

    public void adicionarFormasPagamento(Pagamento pg) {
        formasPagamento.add(pg);
    }
    public void removerFormasPagamento(Pagamento pg){
        formasPagamento.remove(pg);
    }
    public Locatario getLocatario() { return locatario; }
    public void setLocatario(Locatario locatario) { this.locatario = locatario; }
    public Locador getLocador() { return locador; }
    public void setLocador(Locador locador) { this.locador = locador; }

    public void salvarEmArquivo(String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename, true));
            out.writeObject(this);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Arquivo carregarDoArquivo(String filename) {
        Usuario saida = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            saida = (Usuario) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saida;
    }
}
