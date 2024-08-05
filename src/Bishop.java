import javax.swing.*;

public class Bishop extends Figure{
    Bishop(boolean s,int x,int y)
    {
        posx=x;
        posy=y;
        side=s;
        if(s)
            image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\rojfel_w.png").getImage();
        else
            image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\rojfel_b.png").getImage();

    }

    @Override
    boolean range(int posx, int posy,int nposx, int nposy,boolean ft)
    {
        return true;
    }
}
