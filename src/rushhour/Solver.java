package rushhour;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Shintaro Morikawa ID:301435113
//Chris Wen ID:301251957
public class Solver {
    public static void solveFromFile(String inputPath, String outputPath) {
        try {
            rushhour game = new rushhour(inputPath);
            game.BFS();
            createFile(outputPath);
            for (int i = 1; i < game.getRoute().size(); i++) {
                writeMoveToFile(outputPath, game.getRoute().get(i));
                if (i < game.getRoute().size()-1) {
                    writeMoveToFile(outputPath, "\n");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error solving from file.");
            e.printStackTrace();
        }

    }

    /**
     * @param fileName create a solution file (i.e. "A00Sol.txt")
     * @throws IOException if the move is illegal
     */
    public static void createFile(String fileName) throws IOException {
        try {
            File solution = new File(fileName);
            if (solution.createNewFile()) {
                System.out.println("New solution file created in src folder: " + fileName + ". Please delete this file before running the same file again.");
            }
        }
        catch (IOException e) {
            System.out.println("Unable to create new file.");
            e.printStackTrace();
        }
    }

    public static void writeMoveToFile(String fileName, String contents) throws IOException {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(contents);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }
}
