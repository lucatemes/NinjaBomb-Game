import javax.swing.JOptionPane;

public class Pergaminho extends ElementoBasico{
    private boolean fechada;
    private int nroPista;

    public Pergaminho(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "pergaminho.png", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
    }

    public int getNroPista(){
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if(nroPista == 0){
            JOptionPane.showMessageDialog(getRootPane(), "Aqui lhe entrego seu primeiro pergaminho! Ninja lvl 1.");
            Personagem.setNivel(1);
            Tabuleiro.removeElemento(outro);
        }else if(nroPista == 1){
            JOptionPane.showMessageDialog(getRootPane(), "Lá vai mais um! Ninja lvl 2.");
            Personagem.setNivel(2);
            Tabuleiro.removeElemento(outro);
        }else if(nroPista == 2){
            JOptionPane.showMessageDialog(getRootPane(), "Seu último pergaminho! Ninja lvl 3.");
            Personagem.setNivel(3);
            Tabuleiro.removeElemento(outro);
        }
    }    
}
