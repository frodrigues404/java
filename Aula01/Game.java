package Aula01;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        // Player player = new Player();

        ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>(); // Cria Array
        inimigos.add(new Elfo(80, "Elfo Wood", 25)); // Adiciona inimigo do tipo elfo
        inimigos.add(new Elfo(80, "Elfo Dark", 25)); // Adiciona inimigo do tipo elfo
        inimigos.add(new Elfo(80, "Elfo Mage", 25)); // Adiciona inimigo do tipo elfo

        inimigos.get(0).receberDano(5);

        System.out.println("Vida do " + inimigos.get(0).tipo + ": " + inimigos.get(0).getVida());

        for(int i = 0; i < inimigos.size(); i++){
            Inimigo inimigoAtual = inimigos.get(i);
            
            if(i == 2) {
                inimigoAtual.receberDano(10);
                System.out.println("Vida do " + inimigoAtual.tipo + ": " + inimigoAtual.getVida());
            }
        }

        
    }
}
