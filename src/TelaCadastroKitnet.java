import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroKitnet {

    private JPanel panel;
    private JCheckBox vaga;
    private JCheckBox luz;
    private JCheckBox agua;
    private JCheckBox internet;
    private JCheckBox mobiliada;
    private JCheckBox animais;
    private JButton terminarCadastroButton;

    public TelaCadastroKitnet(ArrayList<Usuario> usuarios, Usuario usuario, float preco, float dist, String descArredores,
                              String descImovel, String endereco) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100, 100, 700, 350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        terminarCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getLocatario().adicionarMoradia(new Kitnet(preco,dist,
                descArredores,usuario,descImovel,endereco,vaga.isSelected(),luz.isSelected(),agua.isSelected(),
                internet.isSelected(),mobiliada.isSelected(),animais.isSelected()));
                JOptionPane.showMessageDialog(frame,"Kitnet cadastrada com sucesso!");
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
