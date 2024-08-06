import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class Bishop extends Figure{
    Bishop(boolean s,int x,int y)
    {
        posx=x;
        posy=y;
        side=s;
        if(s) {
            InputStream imageStream = Main.class.getResourceAsStream("/chess_f/rojfel_b.png");
            if (imageStream == null) {
                System.err.println("Nie znaleziono pliku: " + "/chess_f/rojfel_b.png");
            }
            try {
                image = ImageIO.read(imageStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\rojfel_b.png").getImage();

    }

    @Override
    boolean range(int posx, int posy,int nposx, int nposy,boolean ft)
    {
        return true;
    }
}
