import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    private final Figure[][] board;
    private final int pixelSize = 100;
    public boolean turn=true;
    public int Fpx=-1;
    public int Fpy=-1;
    public boolean firstTurn=true;


    public Board(boolean side_choose) {
        int size = 800 / pixelSize;
        board = new Figure[size][size];
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.WHITE);
        fill_board(side_choose);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                move(e.getX()/pixelSize,e.getY()/pixelSize,turn);

                repaint();
            }

        });

        setFocusable(true);
        requestFocusInWindow();
    }

    private void fill_board(boolean side_choose) {

        for(int i =0;i<8;i++)
        {
            for(int j =0;j<8;j++)
            {
                if(j== 1) {
                    Pawn p = new Pawn(!side_choose,i,j);
                    board[i][j] = p;
                }
                if(j== 6) {
                    Pawn p = new Pawn(side_choose,i,j);
                    board[i][j] = p;
                }
                Tower t1 = new Tower(!side_choose,0,0);
                board[0][0]=t1;
                Tower t2 = new Tower(!side_choose,7,0);
                board[7][0]=t2;
                Tower t21 = new Tower(side_choose,0,7);
                board[0][7]=t21;
                Tower t22 = new Tower(side_choose,7,7);
                board[7][7]=t22;

                Horse h1 = new Horse(!side_choose,1,0);
                board[1][0]=h1;
                Horse h2 = new Horse(!side_choose,6,0);
                board[6][0]=h2;
                Horse h21 = new Horse(side_choose,1,7);
                board[1][7]=h21;
                Horse h22 = new Horse(side_choose,6,7);
                board[6][7]=h22;

                Bishop b1 = new Bishop(!side_choose,2,0);
                board[2][0]=b1;
                Bishop b2 = new Bishop(!side_choose,5,0);
                board[5][0]=b2;
                Bishop b21 = new Bishop(side_choose,2,7);
                board[2][7]=b21;
                Bishop b22 = new Bishop(side_choose,5,7);
                board[5][7]=b22;

                Queen q = new Queen(!side_choose,3,0);
                board[3][0]=q;
                Queen q2 = new Queen(side_choose,4,7);
                board[4][7]=q2;


                King k = new King(!side_choose,4,0);
                board[4][0]=k;
                King k2 = new King(side_choose,3,7);
                board[3][7]=k2;


            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1)) {
                    g.setColor(new Color(0, 0, 0));
                    g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                }
                if (board[x][y]!=null) {
                    g.drawImage(board[x][y].image, x * pixelSize, y * pixelSize, pixelSize, pixelSize, this);
                }


            }
        }
    }


public void move(int posx, int posy,boolean t)
{
if(board[posx][posy]!=null && board[posx][posy].side==t)
{
    if(Fpx==-1)
    {
        System.out.println("wybrano figure");
        Fpx=posx;
        Fpy=posy;
    }
    else if(board[posx][posy].range(posx,posy,Fpx,Fpy,firstTurn))
    {
        System.out.println("Bicie");
        board[posx][posy]=board[Fpx][Fpy];
        board[Fpx][Fpy]=null;
        Fpx=-1;
        Fpy=-1;
        turn=!turn;
        repaint();
    }

}
else
{
    if(Fpx!=-1 && board[Fpx][Fpy].range(posx,posy,Fpx,Fpy,firstTurn))
    {
        System.out.println("ruch");
        board[posx][posy]=board[Fpx][Fpy];
        board[Fpx][Fpy]=null;
        Fpx=-1;
        Fpy=-1;
        turn=!turn;
        repaint();
    }
    else
        System.out.println("Błąd!!!");
}


}

}