package logic;

public class TestWindow
{
    public static void main(String[] args)
    {
        BoardGenerator b_gen = new BoardGenerator(10,10,4);
        Board board = b_gen.nextBoard();
        
        board.show();
    }
}
