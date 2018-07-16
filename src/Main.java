import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Main{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        /*Salvando usuarios em usuarios.dat
        ArrayList<Moradia> moradias = new ArrayList<Moradia>();
        usuarios.add(new Usuario("Julio Kiyoshi", "378.457.598-64", "JulioK",
                     "JulioKY", "juliokiyoshi@unicamp.br"));
        usuarios.add(new Usuario("Lucas Bertoloto", "402.798.725-21", "LucasB",
                    "LucasBT", "lucasbertoloto@unicamp.br"));
        usuarios.add(new Usuario("Hugo Navarro", "564.211.629-84", "HugoN",
                    "HugoNV", "hugonavarro@unicamp.br"));
        usuarios.add(new Usuario("Danilo Miranda", "210.654.753-26", "DaniloM",
                    "DaniloMR", "danilomiranda@unicamp.br"));
        usuarios.add(new Usuario("Danilo Braz", "013.548.984.51", "DaniloB",
                    "DaniloBZ", "danilobraz@unicamp.br"));
        usuarios.add(new Usuario("Caio Dias", "159.219.256.78", "CaioD",
                    "CaioDS", "caiodias@unicamp.br"));

        moradias.add(new Casa(2100f, 1200.5f, "Perto de dois supermercados e uma academia", usuarios.get(0),
                    "Casa com duas suites, um lavabo e quintal grande", "Rua Dr Ricardo Qualquer", 2, 2, 2, 4, "Quintal espacoso com piscina",
                    110.70f));
        moradias.add(new Casa(1500f, 2000f, "Comercio ativo nas redondezas de negocios locais", usuarios.get(0),
                    "Casa com uma suite e um quarto, um lavabo", "Rua Unicamp 1", 2, 1, 2, 2, "Area de lazer nao tao grande, possui espaco verde mas sem piscina",
                    89.40f));
        moradias.add(new Casa(2700f, 300f, "Muito proximo da entrada da universidade e longe de republicas com muitas festas por ano", usuarios.get(0),
                    "Casa grande com tres quartos e quatro banheiros", "Rua Unicamp 2", 3, 0, 4, 4, "A casa eh muito espacosa tanto nos comodos internos quanto no quintal",
                    126.30f));

        moradias.add(new Apartamento(1200f, 1450f, "Area calma sem muito trafego de carros", usuarios.get(1),
                    "Apartamento que pega sol da manha e em andar alto", "Rua Unicamp 3", 16, 1, 87.80f, 67.90f, 2, 1,
                    3, true, "O predio oferece uma piscina para os moradores e varanda espacosa em cada apartamento", 2, 3));
        moradias.add(new Apartamento(870f, 2100f, "Torre proxima a supermercados e restaurantes", usuarios.get(1),
                    "Sala e cozinha espacosos", "Rua Unicamp 4", 3, 1, 71.80f, 64.50f, 1, 1,
                    2, false, "O predio possui um playground com mesa de bilhar e ping-pong", 1, 4));
        moradias.add(new Apartamento(1200f, 665f, "Proximo a universidade e a fast foods", usuarios.get(1),
                    "Apartamento confortavel ja mobiliado", "Rua Unicamo 5", 7, 2, 50.60f, 43.20f, 1, 1,
                    2, false, "Area para caminhar ao redor das duas torres", 3, 4));

        moradias.add(new Pensionato(1100f, 615f, "Rua calma e casa proxima a supermercados", usuarios.get(2),
                    "Casa grande com areas comuns muito espacosas", "Rua Unicamp 6", 130f, 8, false,
                    true, true, true));
        moradias.add(new Pensionato(650f, 420f, "Muito proximo da universidade, fora das avenidas principais", usuarios.get(2),
                    "Casa com poucos moradores e nova", "Rua Unicamp 7", 100f, 5, false,
                    false, true, false));
        moradias.add(new Pensionato(730f, 1000f, "Proximo a todo tipo de comercio de comida", usuarios.get(2),
                    "Casa conservada, quartos grandes e quintal espacoso", "Rua Unicamp 8", 145f, 6, true,
                    true, false, false));

        moradias.add(new Kitnet(1400f, 740f, "Lugar calmo com area verde proxima", usuarios.get(3),
                    "Kitnet ampla mobiliada com eletrodomesticos modernos", "Rua Unicamp 9", false, true, false, false,
                    true, true));
        moradias.add(new Kitnet(2000f, 200f, "Condominio fechado de kitnets bem localizado com muitos resturantes ao redor", usuarios.get(3)
                    , "Kitnet recem construida, pronta para o primeiro uso, possui ampla area e bonito design interior", "Rua Unicamp 9", true,
                    false, false, false, true, false));
        moradias.add(new Kitnet(800f, 560f, "Proximo a academia e fast foods", usuarios.get(3),
                    "Espaco medio, local coberto para o carro e area de servico em cada kitnet", "Rua Unicamp 10", true, false, true,
                    true, false, true));

        moradias.add(new Republica(500f, 250f, "Proximo ao centro de comercio local", usuarios.get(4),
                    "Casa grande, area de lazer ampla", "Rua Unicamp 11", true, true, 10, 1, true,
                    "A republica conta com mesa de bilhar, mesa pra beer-pong e ping-pong, e quintal grande com piscina", 120f));
        moradias.add(new Republica(620f, 430f, "Area grande so de casas, mas proximo a supermercados", usuarios.get(4),
                    "Casa com muitos quartos e banheiros para cada quarto", "Rua Unicamp 12", true, false, 8, 1, false,
                    "A casa conta com uma area de churrasqueira e piscina", 160f));
        moradias.add(new Republica(840f, 600f, "Proxima a academia e area verde", usuarios.get(4),
                    "Suites grandes compartilhados, sala de jantar e comodos grandes", "Rua Unicamp 13", false, true, 12, 1, true,
                    "Comodo grande separado para integracao dos moradores da casa e quinatl espacoso", 120f));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            for (Usuario usuario : usuarios) {
                out.writeObject(usuario);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


        //Carregando os usuarios
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            while (true) {
                usuarios.add((Usuario) in.readObject());
            }
        } catch (EOFException e) {
            try {
                in.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TelaLogin tela = new TelaLogin(usuarios);


        sc.close();
    }


}
