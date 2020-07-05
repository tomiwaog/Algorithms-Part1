import java.io.File;
import java.nio.file.Files;

import sorting.SortTools;
public class StringSorter {

    public static void main(String[] args) {
        System.out.println("Running Sorter");

        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        for (File x: files){
            System.out.println("fileName: "+x.getName());
        }
        System.out.println("\n");
        SortTools.shellSort(files);
        for (File x: files){
            System.out.println("fileName: "+x.getName());
        }
    }
}
