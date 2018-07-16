import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaListarSuasMoradias {


    private JPanel panel;

    TelaListarSuasMoradias(ArrayList<Usuario> usuarios, Usuario usuario) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        JEditorPane aux = new JEditorPane("text/plain","");
        aux.setEditable(false);
        aux.setBounds(100,100,600,100);
        for(Moradia moradia: usuario.getLocatario().getMoradias()) {
            aux.setText(aux.getText()+"\n"+moradia.toString());
        }
        if(usuario.getLocatario().getMoradias().size()==0) {
            aux.setText("Você ainda não cadastrou moradias");
        }
        panel.add(new JScrollPane(aux));
        JPanel panelaux = new JPanel(new GridLayout(2,6));
        for(int i=0;i<7;i++) {
            panelaux.add(new JPanel());
        }
        JButton sairButton = new JButton("Voltar");
        sairButton.setPreferredSize(new Dimension(40,5));
        panelaux.add(sairButton);
        panel.add(panelaux);
        for(int i=0;i<6;i++) {
            panelaux.add(new JPanel());
        }
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaInicial inicio = new TelaInicial(usuarios,usuario);
            }
        });
    }
}
