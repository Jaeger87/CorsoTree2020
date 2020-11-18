import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainClass {

    private static Stack<String> idTamponi;

    public static void main(String[] args) {
        idTamponi = new Stack<>();
        CovidThread nord = new CovidThread("files\\nord.txt", idTamponi);
        CovidThread centro = new CovidThread("files\\centro.txt", idTamponi);
        CovidThread sud = new CovidThread("files\\sud.txt", idTamponi);

        nord.start();
        centro.start();
        sud.start();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt")))
        {
            while(nord.isAlive() || centro.isAlive() || sud.isAlive())
            {
                while(!idTamponi.empty())
                    bw.write(idTamponi.pop() + '\n');
            }


            while(!idTamponi.empty())
                bw.write(idTamponi.pop() + '\n');
        }

        catch (IOException ioe)
        {
            System.out.println(ioe);
        }


    }
}
