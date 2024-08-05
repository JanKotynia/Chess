import javax.swing.*;
import java.awt.*;

public class Pawn extends Figure{
Pawn(boolean s,int x,int y)
{
    posx=x;
    posy=y;
    side=s;

    if(s)
        image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\pion_w.png").getImage();
    else
        image = new ImageIcon("C:\\Users\\jasie\\IdeaProjects\\Git-test\\Chess\\src\\chess_f\\pion_b.png").getImage();

}
    @Override
    boolean range(int posx, int posy,int nposx, int nposy,boolean ft)
    {
        return true;
    }



}
