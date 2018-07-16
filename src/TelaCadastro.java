import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastro {
    private JTextField nome;
    private JTextField cpf;
    private JTextField login;
    private JPasswordField senha;
    private JPasswordField confirmar;
    private JTextField email;
    private JPanel panel;
    private JCheckBox onlineCheckBox;
    private JButton cadastrarButton;
    private JCheckBox boletoCheckBox;
    private JCheckBox especieCheckBox;
    private JButton voltar;


    TelaCadastro(ArrayList<Usuario> usuarios) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!senha.getPassword().equals(confirmar.getPassword())) {
                    JOptionPane.showMessageDialog(frame,"Senhas divergentes!");
                } else {
                    usuarios.add(new Usuario(nome.getText(), cpf.getText(), login.getText(), new String(senha.getPassword()), email.getText()));


                    if (onlineCheckBox.isSelected()) {
                        usuarios.get(usuarios.size()-1).adicionarFormasPagamento(Pagamento.Online);
                    }
                    if (boletoCheckBox.isSelected()){
                        usuarios.get(usuarios.size()-1).adicionarFormasPagamento(Pagamento.Boleto);
                    }
                    if (especieCheckBox.isSelected()){
                        usuarios.get(usuarios.size()-1).adicionarFormasPagamento(Pagamento.EmEspecie);
                    }



                    frame.setVisible(false);
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                        for (Usuario usuario : usuarios) {
                            out.writeObject(usuario);
                        }
                        out.flush();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    TelaLogin login = new TelaLogin(usuarios);
                }
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaLogin login = new TelaLogin(usuarios);
            }
        });
    }
}
