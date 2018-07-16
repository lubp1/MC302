import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaProcurarMoradia {


    private JPanel panel;
    private JCheckBox quarto;
    private JTextField precMin;
    private JTextField precMax;
    private JTextField distMin;
    private JTextField distMax;
    private JCheckBox animal;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private JButton inicio;

    TelaProcurarMoradia(ArrayList<Usuario> usuarios, Usuario usuario) {
        JFrame frame = new JFrame("Imobiliária");
        frame.setBounds(100,100,700,350);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ArrayList<Moradia> moradias = new ArrayList<Moradia>();





        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Usuario user:usuarios) {
                    for(Moradia moradia:user.getLocatario().getMoradias()) {
                        if(comboBox1.getSelectedItem().equals("Apartamento")) {
                            if(moradia instanceof Apartamento && moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())) {
                                moradias.add(moradia);
                            }
                        } else if(comboBox1.getSelectedItem().equals("Casa")) {
                            if(moradia instanceof Casa && moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())) {
                                moradias.add(moradia);
                            }
                        } else if(comboBox1.getSelectedItem().equals("Kitnet")) {
                            if(moradia instanceof Kitnet && moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())
                                    && (((Kitnet) moradia).isAceitaAnimal() || !animal.isSelected())) {
                                moradias.add(moradia);
                            }
                        } else if(comboBox1.getSelectedItem().equals("Pensionato")) {
                            if (moradia instanceof Pensionato && moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())
                                    && (((Pensionato) moradia).isQuartoCompartilhado() || !quarto.isSelected())) {
                                moradias.add(moradia);
                            }
                        } else if(comboBox1.getSelectedItem().equals("República")) {
                            if(moradia instanceof Republica && moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())
                                    && ((((Republica) moradia).isAceitaAnimal() || !animal.isSelected()))) {
                                moradias.add(moradia);
                            }
                        } else {
                            if(moradia.getDistanciaUniversidade() < Float.parseFloat(distMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(distMin.getText())
                                    && moradia.getPreco() < Float.parseFloat(precMax.getText())
                                    && moradia.getDistanciaUniversidade() > Float.parseFloat(precMin.getText())) {
                                moradias.add(moradia);
                            }
                        }
                    }
                }
                frame.setVisible(false);
                TelaMostrarMoradias mostrar = new TelaMostrarMoradias(usuarios,usuario,moradias);
            }
        });
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TelaInicial inicio = new TelaInicial(usuarios,usuario);
            }
        });
    }
}
