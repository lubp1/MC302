import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaMostrarMoradias {
    private JPanel panel;

    TelaMostrarMoradias(ArrayList<Usuario> usuarios, Usuario usuario, ArrayList<Moradia> moradias) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100, 100, 700, 350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        JEditorPane aux = new JEditorPane("text/plain","");
        aux.setEditable(false);
        aux.setBounds(100,100,600,100);
        for(Moradia moradia: moradias) {
            aux.setText(aux.getText()+"\n"+moradia.toString());
        }
        if(moradias.size()==0) {
            aux.setText("Não há moradias com essas características");
        }
        panel.add(new JScrollPane(aux));
        JPanel panelaux = new JPanel(new GridLayout(2,6));
        JButton inicioButton = new JButton("Início");
        inicioButton.setPreferredSize(new Dimension(40,5));
        panelaux.add(inicioButton);
        panel.add(panelaux);
        for(int i=0;i<6;i++) {
            panelaux.add(new JPanel());
        }
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaInicial procurar = new TelaInicial(usuarios,usuario);
            }
        });
        for(int i=0;i<1;i++) {
            panelaux.add(new JPanel());
        }
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(40,5));
        panelaux.add(voltarButton);
        panel.add(panelaux);
        for(int i=0;i<6;i++) {
            panelaux.add(new JPanel());
        }
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaProcurarMoradia procurar = new TelaProcurarMoradia(usuarios,usuario);
            }
        });
    }
}
