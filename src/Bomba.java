import javax.swing.JOptionPane;

public class Bomba extends ElementoBasico {

    private Tabuleiro tabuleiro;
    private boolean fechada;
    private int nroPista;

    public Bomba(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "tnt.jpg", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
        this.tabuleiro = tabuleiro;
    }

    public int getNroPista() {
        return nroPista;
    }


    @Override
    public void acao(ElementoBasico outro) {

        getTabuleiro().atualizaVisualizacao();
        JOptionPane.showMessageDialog(getRootPane(),"BOOOOOOM!");
        System.exit(0);
        Tabuleiro.removeElemento(outro);
        System.exit(0);
        getTabuleiro().atualizaVisualizacao();
    }

}
