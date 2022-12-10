/*
The Elf finishes helping with the tent and sneaks back over to you.
"Anyway, the second column says how the round needs to end:
X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
Good luck!"

The total score is still calculated in the same way, but now you need to figure out what shape to choose
so the round ends as indicated. The example above now goes like this:

In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y),
so you also choose Rock. This gives you a score of 1 + 3 = 4.
In the second round, your opponent will choose Paper (B),
and you choose Rock, so you lose (X) with a score of 1 + 0 = 1.
In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
Following the Elf's instructions for the second column,
what would your total score be if everything goes exactly according to your strategy guide?

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day02_2 {

    public static void main(String[] args) throws FileNotFoundException {

        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int lose = 0;
        int draw = 3;
        int win = 6;

        int score = 0;

        Scanner scanner = new Scanner(new File("inputs/day02.txt"));

        // Hashmap: maps shape to their number in order to calculate losing winning or draw
        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("A", rock);
        shapes.put("B", paper);
        shapes.put("C", scissors);
        shapes.put("X", rock);
        shapes.put("Y", paper);
        shapes.put("Z", scissors);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] compare = line.split(" ");

            // X means I loose
            if (shapes.get(compare[1]) == 1) {
                score += lose;
                // checking what enemy has in order to see what am I loosing with
                if (shapes.get(compare[0]) == 1)
                    score += scissors;
                if (shapes.get(compare[0]) == 2)
                    score += rock;
                if (shapes.get(compare[0]) == 3)
                    score += paper;

                // Y means I draw
            } else if (shapes.get(compare[1]) == 2) {
                score += draw;

                // checking what enemy has in order to see what am I drawing with
                if (shapes.get(compare[0]) == 1)
                    score += rock;
                if (shapes.get(compare[0]) == 2)
                    score += paper;
                if (shapes.get(compare[0]) == 3)
                    score += scissors;
            } else {

                // its Z and im winning
                score += win;

                // checking what enemy has in order to see what am I winning with
                if (shapes.get(compare[0]) == 1)
                    score += paper;
                if (shapes.get(compare[0]) == 2)
                    score += scissors;
                if (shapes.get(compare[0]) == 3)
                    score += rock;


            }

        }
        System.out.println(score);
    }
}

