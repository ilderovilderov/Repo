import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {

        if (products.containsKey(product)) {              // Проверяем есть ли товар в корзине (в Map)
            int currentQty = products.get(product);       // Берём текущее кол-во этого продукта из корзины
            products.put(product, currentQty + quantity); // Записываем в козину обновлённое количество
        } else {
            products.put(product, quantity);              // Если продукта нет в корзине, то добавляем
        }
    }

    public double getTotalPrice() {

        double total = 0;                                                    // Переменная для накопления суммы

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {      // Проходим по всем парам в Map
            Product product = entry.getKey();                                // Из пары берём продукт
            int quantity = entry.getValue();                                 // Из пары берём количество

            total += product.getPrice() * quantity;                          // Считаем стоимость товара
        }

        return total;                                                        // Возвращаем итоговую сумму корзины
    }

    public int getProductCount() {

        int count = 0; // Переменная для накопления товаров

        for (int quantity : products.values()) {                            // Проходим по всем значениям
            count += quantity;                                              // Прибавляем текущее количество товаров к общему счётчику
        }

        return count;                                                       // Возвращаем итоговое количество товаров в корзине
    }
}
