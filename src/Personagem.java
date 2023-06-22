import javax.swing.JOptionPane;

public class Personagem extends ElementoBasico {
    private ElementoBasico anterior;
    private int linInicial, colInicial;
    private static int nivel;

    public Personagem(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.nivel= 0;
    }

    public void setAnterior(ElementoBasico anterior) {
        this.anterior = anterior;
    }

    public static void setLin(int linInicial) {
        linInicial = linInicial;

    }

    public static void setCol(int colInicial) {
        colInicial = colInicial;

    }

    public void moveDireita() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.incCol();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grass.jfif")){
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
                if (elemento.getConteudo().equals("saida.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);

                } else {
                elemento.acao(this);
                this.decCol();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }

    }

    public void moveEsquerda() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.decCol();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grass.jfif")
                || elemento.getConteudo().equals("obsidian.png")
                || (elemento instanceof Saida || elemento.getConteudo().equals("saida.png"))) {
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
                elemento.acao(this);
                this.incCol();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }


    public void moveCima() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.decLin();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grass.jfif")){
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
                elemento.acao(this);
                this.decLin();
                this.anterior = getTabuleiro().insereElemento(this);
            }   
        }

    public void moveBaixo() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.incLin();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grass.jfif")){
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
                elemento.acao(this);
                this.decLin();
                this.anterior = getTabuleiro().insereElemento(this);
            }   
    }

    public static void spawn(){
        setPosX(2);
        setPosY(2);
    }



    public int getPosX() {
        int posx = getLin();
        return posx;

    }

    public int getPosY() {
        int posy = getCol();
        return posy;

    }

    public static void setPosX(int posX) {
        setLin(posX);
    }

    public static void setPosY(int posY) {
        setCol(posY);
    }

    @Override
    public void acao(ElementoBasico outro) {

    }

    public static int getNivel(){
        return nivel;
    }

    public static void setNivel(int nivell){
        nivel = nivell;
    }
}

