package Jogo01;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
    public static int WIDTH = 480, HEIGHT = 480;
    public Player player;
    public World world;

    public Game(){
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        player = new Player(32, 32);
        world = new World();
    }

    public void tick() {
        player.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        player.render(g);
        world.render(g);

        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game);
        frame.setTitle("First game");
        frame.setLocationRelativeTo(null);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(game).start();
        
    }

    public void run() {
        while(true) {
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = false;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true;
        }    }
}
