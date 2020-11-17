import java.awt.*;
import java.awt.image.BufferedImage;

public class ThreadImmagine extends Thread{

    private BufferedImage inputImage;
    private BufferedImage outputImage;
    private int startRow;
    private int endRow;
    private final static Color black = new Color(0,0,0);
    private final static Color white = new Color(255,255,255);

    public ThreadImmagine(BufferedImage inputImage, BufferedImage outputImage, int startRow, int endRow) {
        this.inputImage = inputImage;
        this.outputImage = outputImage;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
       for(int x = 0; x < inputImage.getWidth(); x++)
               for(int y = startRow; y < endRow; y++) //itero sui pixel dell'immagine
               {
                   double sumNeighboors = 0;
                   Color currentPixel = new Color(inputImage.getRGB(x,y));

                /*
                      | n | n | n |
                      | n | p | n |
                      | n | n | n |

                      In questo loop calcolo la distanza del pixel con ogni suo vicino e sommo
                 */
                   for(int internalX = -1; internalX < 2; internalX++)
                       for(int internalY = -1; internalY < 2; internalY++)
                       {
                           //Controlli per vedere se il vicino è fuori matrice
                           if(internalX == 0 && internalX == internalY)
                               continue;
                           int neighboorI = x + internalX;
                           if(neighboorI < 0 || neighboorI >= inputImage.getWidth())
                               continue;
                           int neighboorJ = y + internalY;
                           if(neighboorJ < 0 || neighboorJ >= inputImage.getHeight())
                               continue;

                           Color pendingPixel = new Color(inputImage.getRGB(neighboorI,neighboorJ));
                           sumNeighboors += colorDistance(currentPixel, pendingPixel);
                       }

                   //Se la differenza con i vicini è alta, abbiamo un bordo
                   if (sumNeighboors > 255)
                       outputImage.setRGB(x,y,black.getRGB());
                   else
                       outputImage.setRGB(x,y, white.getRGB());
               }
    }


    private static double  colorDistance(Color c1, Color c2){
        int redDifference = c1.getRed() - c2.getRed();
        int greenDifference = c1.getGreen() - c2.getGreen();
        int blueDifference = c1.getBlue() - c2.getBlue();
        return Math.sqrt(Math.pow(redDifference, 2) + Math.pow(greenDifference, 2) + Math.pow(blueDifference, 2));
    }
}
