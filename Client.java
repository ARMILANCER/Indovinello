package Client;

import java.net.*;
import java.io.*;
public class Client {

    // Use to create a new file game, this file contain the question and the answer
    private File  file = new File("Guess.dat");
    // if exit is true, stop the program.
    private static boolean exit = false;

    public static void main(String[] args) throws IOException {
        // read the input of the keyBoard
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = new Socket("localhost", 8080);

        while(!exit) {
            System.out.println("[0] Add Question/Answer");
            System.out.println("[1] Do an Question");
            System.out.println("'*' to exit");
            switch (Integer.parseInt(buff.readLine())){
                case 0:

                    break;
                case 1:

                    break;
                case (int)'*':
                    exit = true;
                    break;
            }

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        }
    }

    // save the question and answer in a file
    public void addElements(){

    }

    // read the Question save in a Hashmap
    public void fileSystemRequest(){

    }
    // if the file isn't empty, read the file and put the elements int the HashMap 'name',
    // else insert new element(Question - Answer)
    public void fileSystemFill(){
        try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            if(raf.length() == 0){
                System.out.println("The File is empty, insert elements");
                addElements();
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}