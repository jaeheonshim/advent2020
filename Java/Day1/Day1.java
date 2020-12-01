import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();

        Set<Integer> mem = new HashSet<>();
        int[] data = loadDs(new FileInputStream("input.txt"));
        for(int n : data) {
            int needed = 2020 - n;
            if(mem.contains(needed)) {
                System.out.println("Answer: " + needed * n + " Finished in " + (System.currentTimeMillis() - start) + " millis.");
                return;
            }
            mem.add(n);
        }
    }

    public static int[] loadDs(InputStream is) {
        List<String> lines = new ArrayList<>();
        try(InputStreamReader reader = new InputStreamReader(is)) {
            int c;
            String s = "";
            while((c = reader.read()) != -1) {
                if(c == '\n') {
                    lines.add(s);
                    s = "";
                } else {
                    s += (char) c;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] data = new int[lines.size()];
        for(int i = 0; i < lines.size(); i++) {
            data[i] = Integer.parseInt(lines.get(i));
        }

        return data;
    }
}