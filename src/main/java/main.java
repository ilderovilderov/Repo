public class main {

    public static void main(String[] args) {

        // Задача №1

        BankAccount bankAccount = new BankAccount();

        bankAccount.setOwnerName("Саня");
        bankAccount.setBalance(1000);
        bankAccount.setBalance(-500);
        bankAccount.finalBalance();

        // Задача №2

        Person person1 = new Person("Иван", "Иванов", 10);
        Person person2 = new Person("Пётр", "Петров", 20);
        Person person3 = new Person("Волан", "де-Морт", 40);

        person1.introduce();
        person2.introduce();
        person3.introduce();

        // Задача №3

        System.out.println(MathHelper.sum(4,8));
        System.out.println(MathHelper.max(15,16));
        System.out.println(MathHelper.isEven(23));

        // Задача №4

        Visitor visitor1 = new Visitor();
        System.out.println(Visitor.getTotalVisitors());

        Visitor visitor2 = new Visitor();
        System.out.println(Visitor.getTotalVisitors());

        Visitor visitor3 = new Visitor();
        System.out.println(Visitor.getTotalVisitors());

        Visitor visitor4 = new Visitor();
        System.out.println(Visitor.getTotalVisitors());

        Visitor visitor5 = new Visitor();                   // totalVisitors - статичная переменная
        System.out.println(Visitor.getTotalVisitors());     // она принадлежит всему классу, а не конкретному объекту

        // Задача №5

        Product winston = new Product("Пачка Винстона", 239.00);
        Product zazhigalka = new Product("Зажигалка", 49.99);
        Product konfetka = new Product("Конфетка по рублю", 2.00);

        Cart cart = new Cart();

        cart.addProduct(winston, 2);
        cart.addProduct(zazhigalka, 1);
        cart.addProduct(konfetka, 4);
        cart.addProduct(konfetka, 3);

        System.out.println("Общее количество товаров: " + cart.getProductCount() + " ед.");
        System.out.println("Общая сумма: " + cart.getTotalPrice() + " руб.");
    }
}