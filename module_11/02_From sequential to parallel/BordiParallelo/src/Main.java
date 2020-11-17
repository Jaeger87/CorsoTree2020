import javax.imageio.ImageIO;
import java.awt.*;
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

        ThreadImmagine threadImmagine1 = new ThreadImmagine(inputImage, outputImage, 0, inputImage.getHeight() / 4);
        ThreadImmagine threadImmagine2 = new ThreadImmagine(inputImage, outputImage, inputImage.getHeight() / 4, (inputImage.getHeight() / 4) * 2);

        ThreadImmagine threadImmagine3 = new ThreadImmagine(inputImage, outputImage, (inputImage.getHeight() / 4) * 2, (inputImage.getHeight() / 4) * 3);
        ThreadImmagine threadImmagine4 = new ThreadImmagine(inputImage, outputImage, (inputImage.getHeight() / 4) * 3, inputImage.getHeight());

        threadImmagine1.start();
        threadImmagine2.start();
        threadImmagine3.start();
        threadImmagine4.run();

        try {
            threadImmagine1.join();
            threadImmagine2.join();
            threadImmagine3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
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
