/*
One Elf has the important job of loading all of the rucksacks with supplies
for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions,
and so a few items now need to be rearranged.
Each rucksack has two large compartments. All items of a given type are meant to go into exactly
one of the two compartments. The Elf that did the packing failed to follow this rule for
exactly one item type per rucksack.

The Elves have made a list of all of the items currently in each rucksack
(your puzzle input), but they need your help finding the errors.
Every item type is identified by a single lowercase or uppercase letter
(that is, a and A refer to different types of items).
The list of items for each rucksack is given as characters all on a single line.
A given rucksack always has the same number of items in each of its two compartments,
so the first half of the characters represent items in the first compartment,
while the second half of the characters represent items in the second compartment.

For example, suppose you have the following list of contents from six rucksacks:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw


The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp,
which means its first compartment contains the items vJrwpWtwJgWr,
while the second compartment contains the items hcsFMMfFFhFp.
The only item type that appears in both compartments is lowercase p.
The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL.
The only item type that appears in both compartments is uppercase L.
The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; te only common item type is uppercase P.
The fourth rucksack's compartments only share item type v.
The fifth rucksack's compartments only share item type t.
The sixth rucksack's compartments only share item type s.
To help prioritize item rearrangement, every item type can be converted to a priority:

Lowercase item types a through z have priorities 1 through 26.
Uppercase item types A through Z have priorities 27 through 52.
In the above example, the priority of the item type that appears in
both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s);
the sum of these is 157.
Find the item type that appears in both compartments of each rucksack.
What is the sum of the priorities of those item types?
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("inputs/day03.txt"));


        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


        int sum = 0;


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();


            int length = line.length() / 2;


            String compartment1 = line.substring(0, length);


            String compartment2 = line.substring(length);

            // Loop through each character in the first compartment
            for (char c : compartment1.toCharArray()) {
                // If the character appears in the second compartment,
                // add its intValue to the sum and break out of the loop
                if (compartment2.indexOf(c) >= 0) {
                    sum += getIntofChar(alphabet, c);
                    break;
                }
            }
        }

        // Print the final sum
        System.out.println(sum);
    }

    // Returns the priority of the given character
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