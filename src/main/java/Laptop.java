/**
 * Класс Laptop представляет собой ноутбук
 */
class Laptop {
    private String brand;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double price;


    /**
     * Конструктор класса Laptop
     * @param brand бренд ноутбука
     * @param ram объем оперативной памяти в ГБ
     * @param hdd объем жесткого диска в ГБ
     * @param os название операционной системы
     * @param color цвет ноутбука
     * @param price цена ноутбука
     */
    public Laptop(String brand, int ram, int hdd, String os, String color, double price) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Переопределение toString() для удобного вывода информации о ноутбуке
     * @return возвращает строковое представление информации о ноутбуке.
     */
    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price + " руб" +
                '}';
    }
}

