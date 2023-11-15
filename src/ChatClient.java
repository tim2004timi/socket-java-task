import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {

            Socket server = new Socket("services.tms-studio.ru", 27015);

            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

            System.out.print("Ваш ник: ");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String nickName = consoleReader.readLine();

            out.write(nickName);
            out.newLine();
            out.flush();

            Thread readThread = new Thread(new ReadWorker(in));
            Thread writeThread = new Thread(new WriteWorker(out, consoleReader));

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();

            server.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}