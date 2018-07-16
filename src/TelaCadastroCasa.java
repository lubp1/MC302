import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroCasa {


    private JPanel panel;
    private JTextField quartos;
    private JTextField suites;
    private JTextField banheiros;
    private JTextField garagem;
    private JTextField lazer;
    private JTextField areaU;
    private JButton terminarCadastroButton;

    public TelaCadastroCasa(ArrayList<Usuario> usuarios, Usuario usuario, float preco, float dist, String descArredores,
                            String descImovel, String endereco) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100, 100, 700, 350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        terminarCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getLocatario().adicionarMoradia(new Casa(preco,dist,descArredores,usuario,descImovel,endereco,
                        Integer.parseInt(quartos.getText()),Integer.parseInt(suites.getText()),
                        Integer.parseInt(banheiros.getText()),Integer.parseInt(garagem.getText()),lazer.getText(),Float.parseFloat(areaU.getText())));
                JOptionPane.showMessageDialog(frame,"Casa cadastrada com sucesso!");
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
