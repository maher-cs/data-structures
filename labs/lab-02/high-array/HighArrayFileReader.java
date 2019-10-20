import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighArrayFileReader {

    private HighArray<Integer> hArray;

    public HighArrayFileReader(HighArray<Integer> hArray) {
        this.hArray = hArray;
    }

    public void readIntFile(String fileName) throws FileNotFoundException {

        Scanner input = new Scanner(new File(fileName));
        while(input.hasNextLine()) {
            int item = input.nextInt();
            this.hArray.insert(item);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        HighArray<Integer> array = new HighArray<Integer>(20);
        HighArrayFileReader hafReader = new HighArrayFileReader(array);
        hafReader.readIntFile("numbers.txt");
        System.out.println(hafReader.hArray);
    }

}