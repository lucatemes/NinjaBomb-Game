import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class App extends JFrame implements ActionListener {
    private Tabuleiro tabuleiro;
    private Personagem personagem;

    public App() {
        super();
        // Define os componentes da tela
        tabuleiro = new Tabuleiro();

        JPanel botoesDirecao = new JPanel(new FlowLayout());
        JButton butDir = new JButton("Direita");
        butDir.addActionListener(this);
        JButton butEsq = new JButton("Esquerda");
        butEsq.addActionListener(this);
        JButton butCima = new JButton("Acima");
        butCima.addActionListener(this);
        JButton butBaixo = new JButton("Abaixo");
        butBaixo.addActionListener(this);
        botoesDirecao.add(butEsq);
        botoesDirecao.add(butDir);
        botoesDirecao.add(butCima);
        botoesDirecao.add(butBaixo);

        JPanel painelGeral = new JPanel();
        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);
        painelGeral.add(botoesDirecao);

        personagem = new Personagem("Ninja", "ninja.jpg", 2, 2, tabuleiro);
        ElementoBasico anterior = tabuleiro.insereElemento(personagem);
        personagem.setAnterior(anterior);
        Chao[][] chao = new Chao[43][43];
        Parede[][] paredes = new Parede[17][17];
        Bomba[][] bombas= new Bomba[10][10];

        Saida saida = new Saida("saida", "obsidian.jpg",0 ,8,tabuleiro);
        Pergunta pergunta1 = new Pergunta("pergunta", 0, 4, 3, tabuleiro);
        Pergunta pergunta2= new Pergunta("pergunta 2", 1, 6, 6, tabuleiro);
        Pergunta pergunta3= new Pergunta("pergunta 3", 2, 7, 9, tabuleiro);
        Pergaminho pergaminho1= new Pergaminho("pergaminho", 0, 9, 1, tabuleiro);
        Pergaminho pergaminho2= new Pergaminho("pergaminho", 1, 0, 5, tabuleiro);
        Pergaminho pergaminho3= new Pergaminho("pergaminho", 2, 8, 7, tabuleiro);
        Bomba bomba = new Bomba("Bomba", 0,8 , 8,  tabuleiro);
        


        int[] posicaoXchao = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 2, 2, 3, 4, 3, 4, 5, 6, 7, 9, 9, 9, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 1, 1, 1, 2, 2, 3, 3, 3};
        int[] posicaoYchao = { 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 5, 6, 7, 6, 6, 7, 7, 7, 7, 7, 8, 7, 6, 2, 3, 0, 1, 2, 3, 4, 1, 2, 3, 4, 0, 1, 3, 4, 1, 2, 3, 4, 1, 2, 3, 1, 3, 1, 2, 3};    
        //coloca o chao
        for (int i = 0; i < posicaoXchao.length; i++) {
            int x = posicaoXchao[i];
            int y = posicaoYchao[i];
            chao[x][y] = new Chao("chao", "grass.jfif", x, y, tabuleiro);
            tabuleiro.insereElemento(chao[x][y]);

        }

        int[] posicaoXparede = { 3,3,3,3,3,3,3,3,3,6,6,6,6,6,6,6,6,6,7,8};
        int[] posicaoYparede = { 0,1,2,3,5,6,7,8,9,0,1,2,3,4,5,7,8,9,7 ,7 };
        //posiciona as paredes do mapa
        for (int i = 0; i < posicaoYparede.length; i++) {
            int x = posicaoYparede[i];
            int y = posicaoXparede[i];
            paredes[x][y] = new Parede("parede", "wall.jpg", x, y, tabuleiro);
            tabuleiro.insereElemento(paredes[x][y]);
        }

        int[] posicoesXbomb = { 1,5,8,3,1};
        int[] posicoesYbomb = { 1,2,1,5,4};
        //posiciona as bombas
        for (int i = 0; i < posicoesYbomb.length; i++) {
            int x = posicoesXbomb[i];
            int y = posicoesYbomb[i];
            bombas[x][y] = new Bomba("bomba", 0, x, y, tabuleiro);
            tabuleiro.insereElemento(bombas[x][y]);
        }
        //insere os elementos
        tabuleiro.insereElemento(saida);
        tabuleiro.insereElemento(pergunta1);
        tabuleiro.insereElemento(pergunta2);
        tabuleiro.insereElemento(pergunta3);
        tabuleiro.insereElemento(bomba);
        tabuleiro.insereElemento(personagem);
        tabuleiro.insereElemento(pergaminho1);
        tabuleiro.insereElemento(pergaminho2);
        tabuleiro.insereElemento(pergaminho3);
        
        this.add(painelGeral);

        this.setSize(680, 700);
        this.setTitle("MineBomb");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        tabuleiro.atualizaVisualizacao();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton but = (JButton) arg0.getSource();
        if (but.getText().equals("Direita")) {
            personagem.moveDireita();
        }
        if (but.getText().equals("Esquerda")) {
            personagem.moveEsquerda();
        }
        if (but.getText().equals("Acima")) {
            personagem.moveCima();
        }
        if (but.getText().equals("Abaixo")) {
            personagem.moveBaixo();
        }
        tabuleiro.atualizaVisualizacao();
    }

    public void actionSelectClick(ActionEvent arg0) {
        JButton but = (JButton) arg0.getSource();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}