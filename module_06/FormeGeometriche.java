package module_06;

public class FormeGeometriche {

    public static void main(String[] args) {
        Quadrato quadrato = new Quadrato(5);
        Rettangolo rettangolo = new Rettangolo(5,6);
        System.out.println(quadrato.toString());
        System.out.println(quadrato.getArea());
    }

}

class FormaGeometrica {
    double x, y;

    public FormaGeometrica(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getArea(){
        return x * y;
    }

    public double getPerimeter(){
        return (x + y) * 2;
    }
}

class Quadrato extends FormaGeometrica{

    public Quadrato(double x) {
        super(x, x);
    }

    @Override
    public String toString() {
        return "quadrato";
    }
}

class Rettangolo extends FormaGeometrica{

    public Rettangolo(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "rettangolo";
    }
}