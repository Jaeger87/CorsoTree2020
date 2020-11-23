import java.awt.*;

public class PixelSortable implements Comparable<PixelSortable>{
    private Color color;

    public PixelSortable(Color color) {
        this.color = color;
    }

    @Override
    public int compareTo(PixelSortable o) {
        int red = color.getRed() - o.color.getRed();
        int green = color.getGreen() - o.color.getGreen();
        int blue = color.getBlue() - o.color.getBlue();

        return red + green + blue;
    }

    public Color getColor() {
        return color;
    }
}
