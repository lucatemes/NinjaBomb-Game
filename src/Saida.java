import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Saida extends ElementoBasico {

    public Saida(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        if(Personagem.getNivel() == 3){
            JOptionPane.showMessageDialog(null, "Game Finalizado. Parabéns... :)");
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Você deve estar no nível 3 para completar.");
        }
    }
}
