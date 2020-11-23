import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class ThreadPixelSorter extends Thread {

    private BufferedImage inputImage;
    private BufferedImage outputImage;
    private ThreadPixelSorter child1;
    private ThreadPixelSorter child2;
    private int startRow;
    private int endRow;
    private int deepLevel;
    private final static int MAXDEPTH = 4;
    private List<PixelSortable> pixelsSorted = new LinkedList<>();

    public ThreadPixelSorter(BufferedImage inputImage, BufferedImage outputImage) {
        this.inputImage = inputImage;
        this.outputImage = outputImage;
        child1 = new ThreadPixelSorter(inputImage, outputImage, 0, inputImage.getHeight() / 2, 1);
        child2 = new ThreadPixelSorter(inputImage, outputImage, inputImage.getHeight() / 2, inputImage.getHeight(), 1);
        startRow = 0;
        endRow = inputImage.getHeight();
        deepLevel = 0;

    }

    private ThreadPixelSorter(BufferedImage inputImage, BufferedImage outputImage, int startRow, int endRow, int deepLevel) {
        this.inputImage = inputImage;
        this.outputImage = outputImage;
        this.startRow = startRow;
        this.endRow = endRow;
        this.deepLevel = deepLevel;

        if (deepLevel < MAXDEPTH) {
            child1 = new ThreadPixelSorter(inputImage, outputImage, startRow, (startRow + endRow) / 2, deepLevel + 1);
            child2 = new ThreadPixelSorter(inputImage, outputImage, (startRow + endRow) / 2, endRow, deepLevel + 1);
        }
    }

    @Override
    public void run() {
        if (child1 == null) { //codice foglie
            for (int y = startRow; y < endRow; y++)
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    pixelsSorted.add(new PixelSortable(new Color(inputImage.getRGB(x, y))));
                }
            pixelsSorted.sort(null);
            return;
        }

        child1.start();
        child2.start();

        try {
            child1.join();
            child2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<PixelSortable> pixelChild1 = child1.pixelsSorted;
        List<PixelSortable> pixelChild2 = child2.pixelsSorted;

        do {
            PixelSortable minChild1Pixel = pixelChild1.get(0);
            PixelSortable minChild2Pixel = pixelChild2.get(0);
            if (minChild1Pixel.compareTo(minChild2Pixel) < 0)
                pixelsSorted.add(pixelChild1.remove(0));
            else
                pixelsSorted.add(pixelChild2.remove(0));

        } while (!pixelChild1.isEmpty() && !pixelChild2.isEmpty());

        if (pixelChild1.isEmpty())
            pixelsSorted.addAll(pixelChild2);

        else
            pixelsSorted.addAll(pixelChild1);


        if (deepLevel > 0) {
            return;
        }
        for (int y = startRow; y < endRow; y++)
            for (int x = 0; x < inputImage.getWidth(); x++) {
                outputImage.setRGB(x, y, pixelsSorted.remove(0).getColor().getRGB());
            }

    }
}
