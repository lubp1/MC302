import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroRepublica {
    private JPanel panel;
    private JCheckBox festa;
    private JCheckBox animal;
    private JTextField pessoas;
    private JTextField pessoas2;
    private JCheckBox banheiro;
    private JTextField lazer;
    private JTextField rateio;
    private JButton terminarCadastroButton;

    public TelaCadastroRepublica(ArrayList<Usuario> usuarios, Usuario usuario, float preco, float dist, String descArredores,
                                  String descImovel, String endereco) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100, 100, 700, 350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        terminarCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getLocatario().adicionarMoradia(new Republica(preco,dist,
                        descArredores,usuario,descImovel,endereco,festa.isSelected(),animal.isSelected(),Integer.parseInt(pessoas.getText()),
                        Integer.parseInt(pessoas2.getText()),banheiro.isSelected(),lazer.getText(),Float.parseFloat(rateio.getText())));
                JOptionPane.showMessageDialog(frame,"República cadastrada com sucesso!");
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
                TelaInicial telaInicial = new TelaInicial(usuarios,usuario);
            }
        });
    }
}
