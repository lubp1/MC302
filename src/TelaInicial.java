import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaInicial {


    private JButton informaçõesDoUsuárioButton;
    private JButton cadastrarMoradiaButton;
    private JButton listarSuasMoradiasButton;
    private JPanel panel;
    private JLabel label;
    private JButton sairButton;
    private JButton procurarMoradias;
    private JButton logout;
    private JTextPane textPane1;
    private JTextArea textArea1;

    public TelaInicial(ArrayList<Usuario> usuarios, Usuario usuario) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        label.setText("Seja Bem-Vindo, " + usuario.getNome());

        informaçõesDoUsuárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaInformacoesUsuario info = new TelaInformacoesUsuario(usuarios,usuario);
            }
        });
        cadastrarMoradiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaCadastroMoradia cadMora = new TelaCadastroMoradia(usuarios,usuario);
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        listarSuasMoradiasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaListarSuasMoradias listar = new TelaListarSuasMoradias(usuarios,usuario);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaLogin login = new TelaLogin(usuarios);
            }
        });
        procurarMoradias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaProcurarMoradia procurar = new TelaProcurarMoradia(usuarios,usuario);
            }
        });
    }
}
