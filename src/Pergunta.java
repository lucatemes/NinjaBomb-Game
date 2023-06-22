import javax.swing.JOptionPane;

public class Pergunta extends ElementoBasico {
    private boolean fechada;
    private int nroPista;
    private String pergunta;
    private int resposta;
    

    public Pergunta(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "pergunta.png", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
    }

    public int getNroPista() {
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        
        if (nroPista== 0){
            pergunta= "Quantas peças existem em um tabuleiro de xadrez.";
            resposta= 32;
            boolean respostaCorretaFornecida = false;

        while (!respostaCorretaFornecida) {
            // Exibe o box de pergunta e obtém a resposta do usuário
            String respostao = JOptionPane.showInputDialog(null, pergunta);

            // Verifica se a resposta é um número válido
            try {
                int respostaUsuario = Integer.parseInt(respostao);

                // Verifica se a resposta fornecida está correta
                if (respostaUsuario == resposta) {
                    JOptionPane.showMessageDialog(null, "Resposta correta!");
                    getTabuleiro().atualizaVisualizacao();
                    Tabuleiro.removeElemento(outro);
                    respostaCorretaFornecida = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        }

        } else if(nroPista == 1) {
            pergunta= "10 / 5 + 7";
            resposta= 9;
            boolean respostaCorretaFornecida = false;

        while (!respostaCorretaFornecida) {
            // Exibe o box de pergunta e obtém a resposta do usuário
            String respostao = JOptionPane.showInputDialog(null, pergunta);

            // Verifica se a resposta é um número válido
            try {
                int respostaUsuario = Integer.parseInt(respostao);

                // Verifica se a resposta fornecida está correta
                if (respostaUsuario == resposta) {
                    JOptionPane.showMessageDialog(null, "Resposta correta!");
                    getTabuleiro().atualizaVisualizacao();
                    Tabuleiro.removeElemento(outro);
                    respostaCorretaFornecida = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        }
        }else if(nroPista == 2){
            pergunta= "Resposta da primeira pergunta multiplicado por 3... :";
            resposta= 96;
            boolean respostaCorretaFornecida = false;

        while (!respostaCorretaFornecida) {
            // Exibe o box de pergunta e obtém a resposta do usuário
            String respostao = JOptionPane.showInputDialog(null, pergunta);

            // Verifica se a resposta é um número válido
            try {
                int respostaUsuario = Integer.parseInt(respostao);

                // Verifica se a resposta fornecida está correta
                if (respostaUsuario == resposta) {
                    JOptionPane.showMessageDialog(null, "Resposta correta!");
                    getTabuleiro().atualizaVisualizacao();
                    Tabuleiro.removeElemento(outro);
                    respostaCorretaFornecida = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        }

            
    }

    }
}
