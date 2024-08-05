import javax.swing.*;

public class Horse extends Figure{
    Horse(boolean s,int x,int y) {
        posx=x;
        posy=y;
        side = s;
        if (s)
            image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\kon_w.png").getImage();
        else
            image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\kon_b.png").getImage();
    }

    @Override
    boolean range(int posx, int posy,int nposx, int nposy,boolean ft)
    {
        return true;
    }
}
