package sorting;

import java.util.Arrays;
import java.util.Random;

public class SortNubianNationalFlag {

    public static void shuffleColor(Object flagColors[]) {
        // Shuffling using Fisher-Yates Suffle aka Knuth's Shuffle
        for (int i = flagColors.length - 1; i > 0; i--) {
            int randomPos = 0;
            randomPos = new Random().nextInt(i + 1);

            Object swap = flagColors[i];
            flagColors[i] = flagColors[randomPos];
            flagColors[randomPos] = swap;
        }
    }

    public static void main(String[] args) {
        DutchFlagColor[] dutchFlagColors = new DutchFlagColor[] {
                new DutchFlagColor("black"), new DutchFlagColor("red"),
                new DutchFlagColor("green"), new DutchFlagColor("black"),
                new DutchFlagColor("red"), new DutchFlagColor("green") };
        System.out.println("Before Shuffle! "
                + Arrays.toString(dutchFlagColors));
        shuffleColor(dutchFlagColors);
        System.out
                .println("After Shuffle! " + Arrays.toString(dutchFlagColors));

        DutchFlagColor.sort(dutchFlagColors);
        SortTools.shellSort(dutchFlagColors);
        System.out.println("After Sort!! " + Arrays.toString(dutchFlagColors));
    }

}

class DutchFlagColor implements Comparable<DutchFlagColor> {
    String name;

    DutchFlagColor(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(DutchFlagColor thatColor) {
        if (!this.name.equalsIgnoreCase("red")
                && thatColor.name.equalsIgnoreCase("red"))
            return 1;
        if (!thatColor.name.equalsIgnoreCase("red")
                && this.name.equalsIgnoreCase("red"))
            return -1;
        if (!this.name.equalsIgnoreCase("black")
                && thatColor.name.equalsIgnoreCase("black"))
            return 1;
        if (!thatColor.name.equalsIgnoreCase("black")
                && this.name.equalsIgnoreCase("black"))
            return -1;
        return 0;
    }

    public static void sort(DutchFlagColor[] colors) {
        // Shell Sort implementation
        int gap = 1;
        while (gap < colors.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < colors.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (colors[j].compareTo(colors[j - gap]) < 0) {
                        DutchFlagColor swap = colors[j];
                        colors[j] = colors[j - gap];
                        colors[j - gap] = swap;
                    } else
                        break;
                }
            }
            gap = gap / 3;
        }
    }

    public String toString() {
        return this.name;
    }
}