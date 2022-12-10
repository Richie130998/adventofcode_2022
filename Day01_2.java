/*      By the time you calculate the answer to the Elves' question,
        they've already realized that the Elf carrying the most Calories of food might
        eventually run out of snacks. To avoid this unacceptable situation, the Elves
        would instead like to know the total Calories carried by the top three Elves carrying
        the most Calories. That way, even if one of those Elves runs out of snacks,
        they still have two backups.
        In the example above, the top three Elves are the fourth Elf (with 24000 Calories),
        then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories).
        The sum of the Calories carried by these three elves is 45000.
        Find the top three Elves carrying the most Calories.
        How many Calories are those Elves carrying in total?

*/

import java.io.File;
import java.util.Scanner;

public class Day01_2 {

        public static void main(String[] args) throws Exception {

            // Create a Scanner to read input from the file
            Scanner scanner = new Scanner(new File("inputs/day01.txt"));

            // Find the top three Elves carrying the most calories
            int[] highestCalories = new int[] {0, 0, 0};
            int[] highestCaloriesElf = new int[] {0, 0, 0};
            int currentElf = 0;
            int currentCalories = 0;
            while (scanner.hasNextLine()) {
                // Read the next line of input
                String line = scanner.nextLine();

                // If the current line is empty, it indicates that the next elf's inventory is starting
                if (line.isEmpty()) {
                    // Update the top three Elves carrying the most Calories. Checking currentCalories if its higher
                    // than highest, secondhighest or thirdhighest
                    if (currentCalories > highestCalories[0]) {
                        highestCalories[2] = highestCalories[1];
                        highestCalories[1] = highestCalories[0];
                        highestCalories[0] = currentCalories;
                        highestCaloriesElf[2] = highestCaloriesElf[1];
                        highestCaloriesElf[1] = highestCaloriesElf[0];
                        highestCaloriesElf[0] = currentElf;
                    } else if (currentCalories > highestCalories[1]) {
                        highestCalories[2] = highestCalories[1];
                        highestCalories[1] = currentCalories;
                        highestCaloriesElf[2] = highestCaloriesElf[1];
                        highestCaloriesElf[1] = currentElf;
                    } else if (currentCalories > highestCalories[2]) {
                        highestCalories[2] = currentCalories;
                        highestCaloriesElf[2] = currentElf;
                    }
                    // Reset the current Elf and their total Calories
                    currentElf++;
                    currentCalories = 0;
                } else {
                    // Parse the line as an integer and add it to the current Elf's total calories
                    currentCalories += Integer.parseInt(line);
                }
            }

            // Print the result
            System.out.println("Top three Elves ");
            System.out.println("Elf " + highestCaloriesElf[0] + " : " + highestCalories[0] + " calories");
            System.out.println("Elf " + highestCaloriesElf[1] + " : " + highestCalories[1] + " calories");
            System.out.println("Elf " + highestCaloriesElf[2] + " : " + highestCalories[2] + " calories");
            System.out.println("Total calories : " + (highestCalories[0] + highestCalories[1] + highestCalories[2]));
        }
    }

