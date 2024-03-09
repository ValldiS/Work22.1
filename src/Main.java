import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        String a = "Catalog create";
        String c = "File create";
        String b = "Error";

        File games = new File("C://Games");
        File src = new File(games, "src");
        File res = new File(games, "res");
        File saveGames = new File(games, "saveGames");
        File temp = new File(games, "temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icon = new File(res, "icon");


        List<File> listCatalog = Arrays.asList(games, src, res, saveGames, temp, main, test, drawables, vectors, icon);

        for (File step : listCatalog) {
            if (step.mkdir()) {
                log.append(step.getName() + " " + a);
                System.out.printf("%s  %s %n", step.getName(), a);
            } else {
                System.out.println(b);
            }
        }
        File file = new File(main, "Main.java.txt");
        File file2 = new File(main, "Utils.java.txt");
        File file3 = new File(temp, "temp.txt");

        List<File> listFile = Arrays.asList(file, file2, file3);

        for (File step : listFile) {
            try {
                if (step.createNewFile()) {
                    log.append(step.getName() + c);
                    System.out.printf("%s  %s %n", step.getName(), c);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        String text = log.toString();


        try {
            FileWriter writer = new FileWriter(file3, false);
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}