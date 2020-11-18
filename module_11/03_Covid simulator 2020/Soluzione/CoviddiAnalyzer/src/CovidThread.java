import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

public class CovidThread extends Thread{

    private String fileName;
    private Collection safeList;
    private Stack<String> idTamponi;
    public CovidThread(String fileName, Stack idTamponi) {
        this.fileName = fileName;
        this.idTamponi = idTamponi;
    }

    @Override
    public void run() {
        try (
                InputStream istream = new FileInputStream(fileName); // Or Reader or something
                Scanner scanner = new Scanner(istream)
        ) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();  //linea di esempio = 01d805bf-c6be-4b80-a9f4-eb400f040f8c;39.4;61;false;false;false;SOTTOCONTROLLO
                String[] values = line.split(";");
                String id = values[0];
                double temperature = Double.valueOf(values[1]);
                int age = Integer.valueOf(values[2]);

                boolean taste = Boolean.parseBoolean(values[3]);
                boolean cough = Boolean.parseBoolean(values[4]);
                boolean wickness = Boolean.parseBoolean(values[5]);
                SituazioneClinica status = SituazioneClinica.valueOf(values[6]);

                if(temperature >= 40)
                {
                    idTamponi.push(id);
                    continue;
                }

                int sumSymptoms = (taste ? 1 : 0) + (cough ? 1 : 0) + (wickness ? 1 : 0);

                if(temperature >= 38 && sumSymptoms == 3)
                {
                    idTamponi.push(id);
                    continue;
                }

                if(status == SituazioneClinica.CRITICA && (sumSymptoms >= 1 || temperature >= 38.5))
                {
                    idTamponi.push(id);
                    continue;
                }

                if(age >= 50 && temperature >= 37)
                {
                    idTamponi.push(id);
                    continue;
                }

                if (age >= 60 && ((taste && status == SituazioneClinica.CAUTELA) || (cough && status == SituazioneClinica.CRITICA)))
                {
                    idTamponi.push(id);
                    continue;
                }

            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
