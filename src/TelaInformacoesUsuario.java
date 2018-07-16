import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaInformacoesUsuario {


    private JPanel panel;
    private JLabel nome;
    private JLabel email;
    private JLabel cpf;
    private JLabel login;
    private JLabel numImoveis;
    private JButton voltarParaPáginaInicialButton;

    public TelaInformacoesUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        nome.setText(usuario.getNome());
        email.setText(usuario.getEmail());
        cpf.setText(usuario.getCpf());
        login.setText(usuario.getLogin());
        numImoveis.setText(""+usuario.getLocatario().getNumMoradias());
        voltarParaPáginaInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaInicial inicio = new TelaInicial(usuarios,usuario);
            }
        });
    }
}
