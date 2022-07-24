import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    private JFrame frame;

    public int[][] city;
    public int[][] hmap;

    public int cx = 0;
    public int cy = 0;
    public int ko = 0;

    public Window() {
        frame = new JFrame("Procedural city generation v0.1");

        frame.setSize(700, 700);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(this);

        frame.addKeyListener(new Keyboard(this));

        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color cb = Color.BLUE;

        cb = new Color(Math.min(255, Math.max(0, cb.getRed() + ko * 3 + 0 * 1)),
                Math.min(255, Math.max(0, cb.getGreen() + ko * 3 + 0 * 1)),
                Math.min(255, Math.max(0, cb.getBlue() + ko * 9 + 0 * 3)));

        g.setColor(cb);

        g.fillRect(0, 0, 1920, 1080);

        for (int k = 0; k <= 20 + ko; k++) {
            for (int i = Math.max(0, cy / 50 - 10); i < Math.min(city.length, cy / 50 + 20); i++) {
                for (int j = Math.max(0, cx / 50 - 10); j < Math.min(city[i].length, cx / 50 + 20); j++) {
                    if (city[i][j] == 1) {
                        g.setColor(new Color(75, 255, 75));
                    } else if (city[i][j] == 2) {
//                        g.setColor(Color.GRAY);
                        g.setColor(new Color(127, 127, 127, 20));
                    } else if (city[i][j] == 3) {
                        g.setColor(Color.ORANGE);
                    } else if (city[i][j] == 4) {
                        g.setColor(Color.PINK);
                    } else if (city[i][j] == 5) {
                        g.setColor(Color.DARK_GRAY);
                    } else if (city[i][j] == 6) {
                        g.setColor(Color.BLUE);
                    } else if (city[i][j] == 7) {
                        g.setColor(Color.YELLOW);
                    } else {
                        g.setColor(Color.GREEN);
                    }

                    Color c = g.getColor();

                    c = new Color(Math.min(255, Math.max(0, c.getRed() + ko * 3 + k * 1)),
                            Math.min(255, Math.max(0, c.getGreen() + ko * 3 + k * 1)),
                            Math.min(255, Math.max(0, c.getBlue() + ko * 9 + k * 3)), c.getAlpha());

                    g.setColor(c);

                    if (hmap[i][j] >= ko + k - 40) {
//                        if(city[i][j] != 2) {
                        g.fillRect((int) ((j * 50 - cx) / ((40 + ko - k) / 50. + .1)) + 500,
                                (int) ((i * 50 - cy) / ((40 + ko - k) / 50. + .1)) + 500,
                                (int) (50 / ((40 + ko - k) / 50. + .1)),
                                (int) (50 / ((40 + ko - k) / 50. + .1)));
//                        }
                    }
                }
            }
        }

        repaint();
    }
}
