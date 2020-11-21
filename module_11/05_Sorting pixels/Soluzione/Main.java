import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(new File("gris.png")); //caricamento immagine
        } catch (IOException e) {
        }

        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output


        ThreadPixelSorter tps = new ThreadPixelSorter(inputImage, outputImage);

        tps.start();
        try {
            tps.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(outputImage, "png", new File("outputImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
