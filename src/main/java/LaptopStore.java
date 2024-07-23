import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

/**
 * Класс LaptopStore описывает магазин ноутбуков
 */
public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
    }

    /**
     * Метод для добавления ноутбука в магазин
     * @param laptop ноутбук для добавления в магазин
     */
    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    /**
     * Метод для фильтрации ноутбуков
     */
    public void filterLaptops() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Цена");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ (в ГБ):");
                filters.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД (в ГБ):");
                filters.put("hdd", scanner.nextInt());
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                filters.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.println("Введите цвет:");
                filters.put("color", scanner.nextLine());
                break;
            case 5:
                System.out.println("Введите максимальную цену:");
                filters.put("price", scanner.nextDouble());
                break;
            default:
                System.out.println("Неверный критерий");
                return;
        }

        /**
         * Фильтрация ноутбуков на основе критериев
         */
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() < (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (filters.containsKey("price") && laptop.getPrice() > (double) filters.get("price")) {
                matches = false;
            }
            if (matches) {
                filteredLaptops.add(laptop);
            }
        }

        /**
         * Вывод отфильтрованных ноутбуков
         */
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуков, удовлетворяющих критериям, не найдено.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        // Добавление ноутбуков в магазин
        store.addLaptop(new Laptop("Dell", 8, 512, "Windows", "Черный", 80000));
        store.addLaptop(new Laptop("HP", 16, 1024, "Windows", "Серебристый", 120000));
        store.addLaptop(new Laptop("Apple", 8, 256, "MacOS", "Серый", 200000));
        store.addLaptop(new Laptop("Lenovo", 4, 500, "Linux", "Черный", 60000));

        // Фильтрация ноутбуков
        store.filterLaptops();
    }
}

