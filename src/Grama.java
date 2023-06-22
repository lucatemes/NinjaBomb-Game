public class Grama extends ElementoBasico {

    private String conteudo;

    public Grama(String id, String conteudo, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grass.jfif", linInicial, colInicial, tabuleiro);
        this.conteudo = conteudo;
       
    }

    @Override
    public void acao(ElementoBasico outro) {
        
    }
    
}
