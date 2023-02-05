import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Board {
    Cell[][] cells;

    public Board(int boardSize,int numberOfsnakes,int numberOfladders)
    {
        initialize(boardSize);
        addSnakesLadders(cells,numberOfsnakes,numberOfladders);
    }

    private void initialize(int boardSize)
    {
        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++)
        {
            for(int j=0;j<boardSize;j++)
            {
                Cell cellobj = new Cell();
                cells[i][j] = cellobj;
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells,int numberOfsnakes,int numberOfladders)
    {
        while(numberOfsnakes>0)
        {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length - 1);
            if(snakeTail>=snakeHead)
            {
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfsnakes--;
        }

        while(numberOfladders>0)
        {
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart>=ladderEnd)
            {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            numberOfladders--;
        }

    }

    Cell getCell(int playerPosition)
    {
        int boardRow = playerPosition/cells.length;
        int boardcolumn = (playerPosition%cells.length);
        return cells[boardRow][boardcolumn];
    }
}
