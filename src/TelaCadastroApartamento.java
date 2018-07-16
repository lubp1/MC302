import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroApartamento {
    private JPanel panel;
    private JTextField andar;
    private JTextField vagas;
    private JTextField areaI;
    private JTextField areaU;
    private JTextField suites;
    private JTextField quartos;
    private JTextField banheiros;
    private JCheckBox simCheckBox;
    private JTextField lazer;
    private JTextField torres;
    private JTextField apAndar;
    private JButton terminarCadastroButton;


    public TelaCadastroApartamento(ArrayList<Usuario> usuarios, Usuario usuario, float preco, float dist, String descArredores,
                                    String descImovel, String endereco) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        terminarCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getLocatario().adicionarMoradia(new Apartamento(preco,dist,descArredores,usuario,descImovel,endereco,
                Integer.parseInt(andar.getText()),Integer.parseInt(vagas.getText()),Float.parseFloat(areaI.getText()),Float.parseFloat(areaU.getText()),
                        Integer.parseInt(suites.getText()),Integer.parseInt(quartos.getText()),Integer.parseInt(banheiros.getText()),
                        simCheckBox.isSelected(),lazer.getText(),Integer.parseInt(torres.getText()),Integer.parseInt(apAndar.getText())));
                JOptionPane.showMessageDialog(frame,"Apartamento cadastrado com sucesso!");
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
