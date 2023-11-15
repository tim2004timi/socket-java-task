import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteWorker implements Runnable {

    private BufferedWriter writer;

    private BufferedReader consoleReader;

    public WriteWorker(BufferedWriter writer, BufferedReader consoleReader) {
        this.writer = writer;
        this.consoleReader = consoleReader;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = consoleReader.readLine();
                writer.write(message + "\n");
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}