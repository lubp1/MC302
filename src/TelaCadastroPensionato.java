import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TelaCadastroPensionato {
    private JPanel panel;
    private JButton terminarCadastroButton;
    private JTextField rateio;
    private JCheckBox quartoComp;
    private JTextField pessoas;
    private JCheckBox suite;
    private JCheckBox limpeza;
    private JCheckBox alimentacao;

    public TelaCadastroPensionato(ArrayList<Usuario> usuarios, Usuario usuario, float preco, float dist, String descArredores,
                              String descImovel, String endereco) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100, 100, 700, 350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        terminarCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getLocatario().adicionarMoradia(new Pensionato(preco,dist,
                        descArredores,usuario,descImovel,endereco,Float.parseFloat(rateio.getText()),Integer.parseInt(pessoas.getText()),
                        quartoComp.isSelected(),suite.isSelected(),limpeza.isSelected(),alimentacao.isSelected()));
                JOptionPane.showMessageDialog(frame,"Pensionato cadastrado com sucesso!");
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
