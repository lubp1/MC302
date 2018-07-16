import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroMoradia {
    private JPanel panel;
    private JTextField preco;
    private JTextField dist;
    private JTextField descArredores;
    private JTextField descImovel;
    private JTextField endereco;
    private JComboBox comboBox1;
    private JButton proximaPaginaButton;


    public TelaCadastroMoradia(ArrayList<Usuario> usuarios, Usuario usuario) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);



        proximaPaginaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().equals("Apartamento")) {
                    frame.setVisible(false);
                    TelaCadastroApartamento apartamento = new TelaCadastroApartamento(usuarios,usuario,Float.parseFloat(preco.getText()),Float.
                            parseFloat(dist.getText()),descArredores.getText(),descImovel.getText(),endereco.getText());
                } else if (comboBox1.getSelectedItem().equals("Casa")) {
                    frame.setVisible(false);
                    TelaCadastroCasa casa = new TelaCadastroCasa(usuarios,usuario,Float.parseFloat(preco.getText()),Float.
                            parseFloat(dist.getText()),descArredores.getText(),descImovel.getText(),endereco.getText());
                } else if (comboBox1.getSelectedItem().equals("Kitnet")) {
                    frame.setVisible(false);
                    TelaCadastroKitnet kitnet = new TelaCadastroKitnet(usuarios,usuario,Float.parseFloat(preco.getText()),Float.
                            parseFloat(dist.getText()),descArredores.getText(),descImovel.getText(),endereco.getText());
                }  else if (comboBox1.getSelectedItem().equals("Pensionato")) {
                    frame.setVisible(false);
                    TelaCadastroPensionato pensionato = new TelaCadastroPensionato(usuarios,usuario,Float.parseFloat(preco.getText()),Float.
                            parseFloat(dist.getText()),descArredores.getText(),descImovel.getText(),endereco.getText());
                }  else if (comboBox1.getSelectedItem().equals("República")) {
                    frame.setVisible(false);
                    TelaCadastroRepublica republica = new TelaCadastroRepublica(usuarios,usuario,Float.parseFloat(preco.getText()),Float.
                            parseFloat(dist.getText()),descArredores.getText(),descImovel.getText(),endereco.getText());
                }
            }
        });
    }
}
