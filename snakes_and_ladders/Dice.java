import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount)
    {
        this.diceCount = diceCount;
    }

    public int rollDice()
    {
        int total = 0;
        int dice = 0;
        while(dice<diceCount)
        {
            total += ThreadLocalRandom.current().nextInt(min,max+1);
            dice++;
        }
        return total;
    }
}
