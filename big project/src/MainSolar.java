import javax.swing.*;

public class MainSolar {
    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame("Solar Display"); // create new JFrame entitled "Solar Display"
        f.setSize(500, 500); // set the size of the JFrame to 500x500 pixels
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets whether JFrame to exit when closed
        SolarDisplay sol = new SolarDisplay();
        f.add(sol);
        f.setVisible(true); // makes JFrame window visible
        sol.requestFocus(); // give focus to MyComponent object component
        while (true) {
            Thread.sleep(10);
            sol.repaint();

        }
    }
}
