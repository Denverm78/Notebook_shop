public class Notebook {
    int id;
    String vendor;
    double diagonal;
    String color;
    int ram;
    String processor;
    int price;

    public Notebook(int id, String vendor, double diagonal, String color, int ram, String processor, int price) {
        this.id = id;
        this.vendor = vendor;
        this.diagonal = diagonal;
        this.color = color;
        this.ram = ram;
        this.processor = processor;
        this.price = price;
    }

    public String toString() {
        return String.format(
                "id: %d, Производитель: %s, диагональ: %.1f, цвет: %s, оперативная память: %d Gb, процессор: %s, цена: %d руб.",
                id, vendor, diagonal, color, ram, processor, price);
    }

    // public boolean equals(Object o) {
    //     Notebook t = (Notebook) o;
    //     return id == t.id;
    // }
}