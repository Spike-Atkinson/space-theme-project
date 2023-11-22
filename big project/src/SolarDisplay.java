import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SolarDisplay extends JComponent {
    double time = 0;

    // 2d array holding the Orbit, Year length, and speed relative to earth
    double[][] planets = { {0.387, 0.2409, 1.607}, {0.723,0.616,1.174}, {1, 1, 1}, {1.524,1.9,0.802} };
    Color[] colour = {Color.ORANGE, Color.YELLOW, Color.BLUE, Color.RED};
    boolean pause = false;
    double speed = 0.01;
    SolarDisplay() {
        addKeyListener(new KeyAdapter() { // key adapter has empty methods for the convenience of not having to override all the methods in KeyListener
            @Override
            public void keyPressed(KeyEvent e) { //override keyPressed method

                int key = e.getKeyCode();
                boolean shift = e.isShiftDown();

                if (shift && key == KeyEvent.VK_EQUALS) {
                    key = KeyEvent.VK_PLUS;
                }

                if (key == KeyEvent.VK_PLUS || key == KeyEvent.VK_EQUALS) {
                    speed += 0.0005;
                } else if (key == KeyEvent.VK_MINUS || key == KeyEvent.VK_UNDERSCORE) {
                    if (speed > 0) {
                        speed -= 0.0005;
                    }
                }
            }
        });
        addMouseListener(new MouseAdapter() { //new mouse adapter
            @Override
            public void mouseClicked(MouseEvent e) { //override mouseClicked method
                int button = e.getButton(); // get button number
                if (button == MouseEvent.BUTTON1 && !pause){
                    pause = true;
                }
                else if(button == 1 && pause){
                    pause = false;
                }
            }
        });

    }
    @Override
    public void paintComponent(Graphics body) {
    super.paintComponent(body);
    //sun
    body.setColor(Color.YELLOW);
    int sunPosition = 220;
    int sunXY = 30;
    body.fillOval(sunPosition, sunPosition, sunXY, sunXY);

    int planetSize = 15;
    int sunSurface = (int) (sunPosition + (sunXY / 4));
    for (int i = 0; i< planets.length; i++) {
        double planetOrbit = planets[i][0] * 125;
        double planetYear =  planets[i][1];
        int planetX = (int) Math.round((Math.cos(time / planetYear) * planetOrbit + sunSurface));
        int planetY = (int) Math.round((Math.sin(time / planetYear) * planetOrbit + sunSurface));
        body.setColor(colour[i]);
        body.fillOval(planetX, planetY, planetSize, planetSize);
    }
    if (!pause) {
        time += speed;
    }
    }
}
