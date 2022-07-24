import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private Window window;

    public Keyboard(Window window) {
        this.window = window;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> window.cx -= 10;
            case 'd' -> window.cx += 10;
            case 'w' -> window.cy -= 10;
            case 's' -> window.cy += 10;
            case 'e' -> window.ko -= 1;
            case 'q' -> window.ko += 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
