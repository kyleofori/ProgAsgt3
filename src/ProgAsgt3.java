import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by kyleofori on 2/10/15.
 */
public class ProgAsgt3 {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/kyleofori/Desktop/Coursera/ProgAsgt3/src/kargerMinCut.txt");
        Charset charset = Charset.forName("US-ASCII");
        String line;
        final int VERTEX1 = 2;
        final int VERTEX2 = 5;

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            while ((line = reader.readLine()) != null) {
                String[] numberStrings = line.split("\t");
                Integer[] numbers = new Integer[numberStrings.length];
                List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Integer.parseInt(numberStrings[i]);
                    //this is the point at which I have an array of integers.
                    printVertices(numbers, i);

                    if(numbers[i] == VERTEX1) {
                        Collections.addAll(a, numbers);}
                    if(numbers[i] == VERTEX2) {
                        Collections.addAll(b, numbers);}
                    for (int y: b) {
                        for (int x: a) {
                            if (x==y) {
                                break;
                            }
                        }
                        a.add(y);
                        }
                    }
                    System.out.println(a);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void printVertices(Integer[] numbers, int i) {
        if(i==0) {
            System.out.println("The vertex labeled " + numbers[i] + " is adjacent to: ");
        } else if(i==numbers.length - 1) {
            System.out.print(numbers[i] + "\n");
        } else {
            System.out.print(numbers[i] + ", ");
        }
    }
    private void contractEdge(int a, int b) {
        //go through all the integer arrays that numbers[] could be
        //if numbers[0] == a, save the array as something; same for b
    }
}
