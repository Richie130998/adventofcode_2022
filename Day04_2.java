/*
It seems like there is still quite a bit of duplicate work planned.
Instead, the Elves would like to know the number of pairs that overlap at all.

In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap,
 while the remaining four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:

5-7,7-9 overlaps in a single section, 7.
2-8,3-7 overlaps all of the sections 3 through 7.
6-6,4-6 overlaps in a single section, 6.
2-6,4-8 overlaps in sections 4, 5, and 6.
So, in this example, the number of overlapping assignment pairs is 4.

In how many assignment pairs do the ranges overlap?
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day04_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("inputs/day04.txt"));

        int noOverlap = 0;
        int allPairs = 0;


        while (scanner.hasNextLine()) {


            String line = scanner.nextLine();
            String[] elfjobs = line.split(",");
            String[] elfassign1 = elfjobs[0].split("-");
            String[] elfassign2 = elfjobs[1].split("-");


            int elf1low = Integer.parseInt(elfassign1[0]);
            int elf1high = Integer.parseInt(elfassign1[1]);
            int elf2low = Integer.parseInt(elfassign2[0]);
            int elf2high = Integer.parseInt(elfassign2[1]);


            if (elf1low > elf2high) {
                noOverlap++;
            } else if (elf2low > elf1high) {
                noOverlap++;
            }
            allPairs++;


        }
        System.out.println(allPairs - noOverlap);

    }
}
