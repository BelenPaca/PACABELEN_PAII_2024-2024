package game_package;

import static java.awt.Font.PLAIN;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelGame extends JPanel {

	private Hero player;
    private Villain enemies;
    private final int GAME_OVER_LINE_Y = 400;

    public PanelGame() {
        setBackground(Color.BLACK);
        setFocusable(true);
        
        String name = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
        player = new Hero(390, 440, 200, name);
        enemies = new Villain(8, 800, 600);
        
    
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        player.movements("UP");
                        break;
                    case KeyEvent.VK_DOWN:
                        player.movements("DOWN");
                        break;
                    case KeyEvent.VK_LEFT:
                        player.movements("LEFT");
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.movements("RIGHT");
                        break;
                    case KeyEvent.VK_SPACE:
                        player.shoot(); // El jugador dispara cuando se presiona la tecla de espacio
                        break;
                }
            }
        });

        // Agregar un temporizador para actualizar el juego
        Timer timer = new Timer(1000 / 60, e -> {
            updateGame(); // Actualizar el estado del juego
            repaint(); // Volver a dibujar el panel
        });
        timer.start();
    }

    private void updateGame() {
        player.updateBullets(); // Actualizar las balas del jugador
        enemies.movements("LEFT"); // Mover a los enemigos

        // Verificar las colisiones entre las balas del jugador y los enemigos
        Iterator<Bullet> bulletIterator = player.getBullets().iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            if (enemies.checkCollision(bullet)) {
                bulletIterator.remove(); // Eliminar la bala
            }
        }

     // Verificar si el jugador ha perdido todas las vidas
        if (!player.isAlive() || player.getY() < GAME_OVER_LINE_Y) {
            JOptionPane.showMessageDialog(null, "GAME OVER");
            System.exit(0);
        }

        // Verificar si todos los enemigos han sido eliminados
        if (enemies.noMoreEnemies()) {
            JOptionPane.showMessageDialog(null, "YOU WIN!");
            System.exit(0);
        }
        
       
    }
    
    private void drawScoreAndHealth(Graphics g) {
        // Dibujar puntaje
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("Score: " + enemies.getScore(), 670, 20);
        g.drawString(player.getName(), 0, 20);

        // Dibujar la barra de vida
        g.setColor(Color.RED);
        g.fillRect(2, 30, player.getHealth(), 15); // Dibuja la barra de vida en la esquina superior izquierda

        // Dibujar la línea divisoria
        int yLinea = (int) (getHeight() * 0.66);
        g.setColor(Color.RED);
        g.drawLine(0, yLinea, getWidth(), yLinea);

        // Dibujar las balas del jugador
        for (Bullet bullet : player.getBullets()) {
            bullet.draw(g); // Dibuja cada bala en la lista de balas del jugador
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        player.draw(g); // Dibujar al jugador
        enemies.draw(g); // Dibujar a los enemigos
        drawScoreAndHealth(g); // Dibujar puntaje, nombre del jugador, barra de vida y línea divisoria

        


     // Dibujar la línea de "Game Over"
        g.setColor(Color.RED);
       
    }
}
        
        


