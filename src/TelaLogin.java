import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TelaLogin {
    private JPasswordField password;
    private JTextField username;
    private JPanel panel;
    private JButton loginButton;
    private JButton cadastroButton;

    public TelaLogin(ArrayList<Usuario> usuarios) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);




        username.setColumns(10);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = username.getText();
                char[] pass = password.getPassword();
                String senha = new String(pass);
                boolean aux = true;
                for(Usuario i: usuarios) {
                    if(i.getLogin().equals(usuario)&&i.getSenha().equals(senha)) {
                        frame.setVisible(false);
                        aux = false;
                        TelaInicial inicio = new TelaInicial(usuarios, i);
                    }
                }
                if(aux) {
                    JOptionPane.showMessageDialog(frame, "Usuario ou senha incorreto");
                }
            }
        });
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaCadastro cadastro = new TelaCadastro(usuarios);
            }
        });
    }


}
