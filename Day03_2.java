/*
As you finish identifying the misplaced items, the Elves come to you with another issue.
For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group.
For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves.
That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack,
and at most two of the Elves will be carrying any other item type.

The problem is that someone forgot to put this year's updated authenticity sticker on the badges.
All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.
Additionally, nobody wrote down which item type corresponds to each group's badges.
The only way to tell which item type is the right one is by finding the one item type that is common
between all three Elves in each group.

Every set of three lines in your list corresponds to a single group,
but each group can have a different badge item type. So, in the above example,
the first group's rucksacks are the first three lines:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
And the second group's rucksacks are the next three lines:

wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
In the first group, the only item type that appears in all three rucksacks is lowercase r;
this must be their badges. In the second group, their badge item type must be Z.

Priorities for these items must still be found to organize the sticker attachment efforts: here,
they are 18 (r) for the first group and 52 (Z) for the second group.
The sum of these is 70.

Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?


 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day03_2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("inputs/day03.txt"));

        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        HashMap<Integer, String> group = new HashMap<>();


        int sum = 0;
        int groupSize = 3;

        while (scanner.hasNext()) {


            for (int i = 0; i < groupSize; i++) {

                group.put(i, scanner.nextLine());
            }

            // getting the values of the hashmap into a char array


            char[] first = group.get(0).toCharArray();
            char[] second = group.get(1).toCharArray();
            char[] third = group.get(2).toCharArray();

            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            Set<Character> set3 = new HashSet<>();

            // Add the elements of each array to a set
            for (char c : first) {
                set1.add(c);
            }
            for (char c : second) {
                set2.add(c);
            }
            for (char c : third) {
                set3.add(c);
            }

            // intersection method to find the characters that are present in all three sets
            set1.retainAll(set2);
            set1.retainAll(set3);

            // getting the character out of the array
            Iterator<Character> iterator = set1.iterator();
            char foundchar = iterator.next();

            sum += getIntofChar(alphabet, foundchar);


        }

        System.out.println(sum);


    }

    public static int getIntofChar(String alphabet, char c) {
        // Lowercase characters  1 through 26
        if (c >= 'a' && c <= 'z') {
            return alphabet.indexOf(c) - alphabet.indexOf('a') + 1;
        }

        // Uppercase characters  27 through 52
        if (c >= 'A' && c <= 'Z') {
            return alphabet.indexOf(c) - alphabet.indexOf('A') + 27;
        }


        return 0;
    }

}
