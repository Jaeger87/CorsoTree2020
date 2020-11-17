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

        /*
        Creo i due colori che utilizzerò per l'immagine finale
         */
        Color black = new Color(0,0,0);
        Color white = new Color(255,255,255);



        for(int i = 0; i < inputImage.getWidth(); i++)
            for(int j = 0; j < inputImage.getHeight(); j++) //itero sui pixel dell'immagine
            {
                double sumNeighboors = 0;
                Color currentPixel = new Color(inputImage.getRGB(i,j));

                /*
                      | n | n | n |
                      | n | p | n |
                      | n | n | n |

                      In questo loop calcolo la distanza del pixel con ogni suo vicino e sommo
                 */
                for(int internalI = -1; internalI < 2; internalI++)
                    for(int internalJ = -1; internalJ < 2; internalJ++)
                    {
                        //Controlli per vedere se il vicino è fuori matrice
                        if(internalI == 0 && internalI == internalJ)
                            continue;
                        int neighboorI = i + internalI;
                        if(neighboorI < 0 || neighboorI >= inputImage.getWidth())
                            continue;
                        int neighboorJ = j + internalJ;
                        if(neighboorJ < 0 || neighboorJ >= inputImage.getHeight())
                            continue;


                        Color pendingPixel = new Color(inputImage.getRGB(neighboorI,neighboorJ));
                        sumNeighboors += colorDistance(currentPixel, pendingPixel);
                    }

                //Se la differenza con i vicini è alta, abbiamo un bordo
                if (sumNeighboors > 255)
                    outputImage.setRGB(i,j,black.getRGB());
                else
                    outputImage.setRGB(i,j, white.getRGB());
            }

        try {
            ImageIO.write(outputImage, "png", new File("outputImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);

    }

    private static double  colorDistance(Color c1, Color c2){
        int redDifference = c1.getRed() - c2.getRed();
        int greenDifference = c1.getGreen() - c2.getGreen();
        int blueDifference = c1.getBlue() - c2.getBlue();
        return Math.sqrt(Math.pow(redDifference, 2) + Math.pow(greenDifference, 2) + Math.pow(blueDifference, 2));
    }
}
