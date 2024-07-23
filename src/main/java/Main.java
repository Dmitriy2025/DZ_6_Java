public class Main {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        /**
         * Добавление ноутбуков в магазин
         */
        store.addLaptop(new Laptop("Dell", 8, 512, "Windows", "Черный", 80000));
        store.addLaptop(new Laptop("HP", 16, 1024, "Windows", "Синий", 120000));
        store.addLaptop(new Laptop("Apple", 8, 256, "MacOS", "Серый", 250000));
        store.addLaptop(new Laptop("Lenovo", 4, 512, "Linux", "Черный", 60000));

        /**
         * Фильтрация ноутбуков
         */
        store.filterLaptops();
    }
}

