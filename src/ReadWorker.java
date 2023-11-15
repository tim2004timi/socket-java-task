import java.io.BufferedReader;
import java.io.IOException;

public class ReadWorker implements Runnable {

    private BufferedReader reader;

    public ReadWorker(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}