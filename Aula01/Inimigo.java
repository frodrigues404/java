package Aula01;
public class Inimigo {

    public int vida;
    public int danoAtaque;
    public String tipo;

    public Inimigo(int vida, String tipo, int danoAtaque) {
        this.vida = vida;
        this.danoAtaque = danoAtaque;
        this.tipo = tipo;
    }

    public void receberDano(int quantidade) {
        vida -= quantidade;
    }

    public int getVida() {
        return vida;
    }
}