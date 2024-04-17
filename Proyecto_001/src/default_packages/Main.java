package default_packages;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Belen Anahis Paca Silva
 * Tema: Utlizacion del JFrame en las Figuras Geometricas
 */

public class Main extends JFrame {

	public static void main(String[] args) {
	
	        Main ventana = new Main();
	        ventana.setVisible(true);
	    }
		// TODO Auto-generated method stub
		

		    private JPanel panel;
		    private JButton botonCirculo;
		    private JButton botonTriangulo;
		    private JButton botonCuadrado;
		    private Image imagenFondo;
		    private int figuraActual; // 0: Ninguna, 1: Círculo, 2: Triángulo, 3: Cuadrado


		        public Main() {
		            setTitle("Dibujar Figuras Geometricas");
		            setSize(500, 500);
		            setDefaultCloseOperation(EXIT_ON_CLOSE);
		            
		            // Cargar la imagen de fondo
		            ImageIcon iconoFondo = new ImageIcon("resources/universidad.jpg");
		            imagenFondo = iconoFondo.getImage();
		            
		            panel = new JPanel() {
		                @Override
		                protected void paintComponent(Graphics grafico) {
		                    super.paintComponent(grafico);
		                    
		                 // Dibujar la imagen de fondo
		                    grafico.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		                    
		                    //circulo
		                    if (figuraActual == 1) {
		                    	int x = (getWidth() - 100) / 2; // Centrar horizontalmente
		                        int y = (getHeight() - 100) / 2; // Centrar verticalmente
		                        grafico.setColor(Color.BLUE);
		                        grafico.fillOval(x, y, 100, 100);
		                        
		                        //triangulo
		                    } else if (figuraActual == 2) {
		                    	int[] x = {getWidth() / 2, getWidth() / 2 - 50, getWidth() / 2 + 50};
		                        int[] y = {getHeight() / 2 - 50, getHeight() / 2 + 50, getHeight() / 2 + 50};
		                        grafico.setColor(Color.RED);
		                        grafico.fillPolygon(x, y,3);
		                        
		                        //cuadrado
		                    } else if (figuraActual == 3) {
		                    	int x = (getWidth() - 100) / 2; // Centrar horizontalmente
		                        int y = (getHeight() - 100) / 2; // Centrar verticalmente
		                        grafico.setColor(Color.ORANGE);
		                        grafico.fillRect(x, y, 100, 100);
		                    }
		                }
		            };
		            
		            botonCirculo = new JButton("Círculo");
		            botonTriangulo = new JButton("Triángulo");
		            botonCuadrado = new JButton("Cuadrado");
		            
		            // colores para los botones
		           botonCirculo.setBackground(Color.CYAN);
		            botonTriangulo.setBackground(Color.pink);
		            botonCuadrado.setBackground(Color.yellow);
		            
		            botonCirculo.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    borrarFigura();
		                    figuraActual = 1;
		                    panel.repaint();
		                }
		            });
		            
		            botonTriangulo.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    borrarFigura();
		                    figuraActual = 2;
		                    panel.repaint();
		                }
		            });
		            
		            botonCuadrado.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    borrarFigura();
		                    figuraActual = 3;
		                    panel.repaint();
		                }
		            });
		            
		            panel.setLayout(null); // Desactivar el diseño por defecto del panel
		            panel.add(botonCirculo);
		            panel.add(botonTriangulo);
		            panel.add(botonCuadrado);
		            
		            // Establecer las posiciones de los botones
		            botonCirculo.setBounds(50, 70, 110, 45);
		            botonTriangulo.setBounds(50, 185, 110, 45);
		            botonCuadrado.setBounds(50, 300, 110, 45);
		            
		            add(panel);
		        }
		        
		        private void borrarFigura() {
		            figuraActual = 0;
		            panel.repaint();
		        }


		    }

		


		

	


