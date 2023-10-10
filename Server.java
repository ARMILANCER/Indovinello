package Server;

import java.net.*;
import java.io.*;
 
public class Server {
   // Contain the maximum length of the record
   private static int MAX_LENGTH_RECORD = 2+(80*Character.BYTES);
   // Contain the maximum length of the string
   private static int MAX_LENGTH_STRING = 80;
   // Use to create a new file game, this file contain the question and the answer
   private File  file = new File("Guess.dat");

   public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = new ServerSocket(8080);
      Socket clientSocket = serverSocket.accept();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
         out.println(inputLine);
      }
   }

   public void searchAnswer(String Question){
      byte[] num = new byte[MAX_LENGTH_RECORD];
      // if the question was found in the file, exit of the cycle,
      // return the answer, and printf the answer;
      boolean found = false;
      int bytesRead = 0;
      // contain the Question of the file, is used to the comparison
      String question;
      try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
         raf.seek(0);
         while((bytesRead = raf.read(num))!=-1 && !found){
            for(int i=0;i<bytesRead;i++){
               question.
            }
         }

      }catch (IOException e) {
         throw new RuntimeException(e);
      }

   }

}