package org.example.controller;

import com.github.tomaslanger.chalk.Chalk;
import org.example.DAO.BasketsDAO;
import org.example.DAO.OrdersDAO;
import org.example.DAO.ProductsDAO;
import org.example.DAO.ProductsOrdersDAO;
import org.example.service.TerminalManager;
import org.example.service.menu.CustomerMenu;
import org.example.model.Basket;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.ProductOrder;
import org.example.model.list.OrderList;
import org.example.model.list.ProductList;
import org.example.model.list.ProductsOrdersList;
import org.example.model.user.User;
import org.example.view.TableView;
import org.example.view.TerminalView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private User user;
    private Basket basket;
    private ProductList productList;
    private OrderList orderList;

    public CustomerController(User user) {
        this.user = user;
        this.basket = new Basket(user.getId());
        this.productList = new ProductList(new ProductsDAO().readAllProducts());
        this.orderList = new OrderList(new OrdersDAO().readAllOrders());


        // TODO:
        this.basket.setBasketFromDB();
        this.basket.updateProductList(this.productList);
    }

    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalManager.clearScreen();
            CustomerMenu.displayMenu();

            int choice = TerminalManager.askForInt("");

            switch (choice) {
                case 1:
                    TerminalView.clearScreen();
                    TableView.displayProducts(this.user);
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 2:
                    TerminalView.clearScreen();
                    TableView.displayAllCategories();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 3:
                    TerminalView.clearScreen();
                    TableView.displayProducts(this.user);
                    addProductToBasket();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 4:
                    TableView.displayBasketPretty(this.basket);
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    placeOrder();
                    break;
                case 8:
                    // TODO:
                    displayArchivedOrders(this.orderList, this.productList, this.user);
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private void displayArchivedOrders(OrderList orderList, ProductList productList, User user) {
        // TODO:
        System.out.println("qwe");
        for (Order order : orderList.getOrders()) {
            TerminalView.printString("OrderID: " + order.getId() + "\nStatus: "
                    + order.getStatus() + "\nDate: "
                    + order.getDate());

            ArrayList<Product> listOfProductsOfEachOrder = new ArrayList<>();
            ProductList productsInEachOrder = new ProductList(listOfProductsOfEachOrder);

            ProductsOrdersList productsOrdersList = new ProductsOrdersList(new ProductsOrdersDAO().readProductsOfOrder(order));

            for (ProductOrder productOrder : productsOrdersList.getProductsOrders()) {
                Product product = productList.getProductById(productOrder.getProductId());
                product.setAmount(productOrder.getAmount());
                product.setInStorage(true);
                productsInEachOrder.add(product);
            }

            TableView.displayProductsByProductsList(productsInEachOrder, user);


            String totalPriceMessage = "Total price of this basket: ";
//            System.out.println("" + Chalk.on(totalPriceMessage).green() + Chalk.on(String.valueOf(basket.calculateTotalValue())).magenta().bold() + " PLN.\n");
        }
    }

    private void placeOrder() {
        System.out.println("place order here");
        if (!basket.getProducts().isEmpty()) {

            // Save to DB
            new OrdersDAO().write(this.user);
            this.orderList.setOrders(new OrdersDAO().readOrdersByUser(this.user));

            // Order from the end
            Order newOrder = new OrdersDAO().readOrdersByUser(user).get(orderList.getOrders().size() - 1);

            // Save to ProductsOrder
            new ProductsOrdersDAO().write(basket, newOrder);

            // update products in DB
            this.productList.updateProductsInDB();

            // clear Basket
            basket.getProducts().clear();

            // delete basket from DB
            new BasketsDAO().delete(user);

            // update user productList
            this.productList = new ProductList(new ProductsDAO().readAllProducts());

            String successMessage = "Good job! You have just placed order!";
            System.out.println(Chalk.on(successMessage).cyan().underline());

        } else {
            System.out.println("Basket empty! At first put something to basket!");
        }
    }

    public void addProductToBasket() {
        boolean isRunnig = true;
        while (isRunnig) {
            int productId = TerminalManager.askForInt("Choose index of product: ");
            boolean isProductIdCorrect = productList.isIdCorrect(productId) && productList.getProductById(productId).isInStorage();

            if (isProductIdCorrect) {
                int quantity = TerminalManager.askForInt("How many of this product You want? ");
                if (quantity <= 0) {
                    isRunnig = false;
                }
                if (quantity > 0 && quantity <= productList.getProductById(productId).getAmount()
                        && productList.getProductById(productId).isAvailable()) {
                    basket.addProductToBasket(productId, this.productList.getProducts(), quantity);
                    this.productList.removeQuantityOfProductById(productId, quantity);

                    String successMessage = "Good job! You have just added product to basket! ";
                    System.out.println(Chalk.on(successMessage).cyan().underline());

                    isRunnig = false;
                } else {
                    System.out.println("Wrong input!");  // wrong amount or availability
                }
            } else {
                System.out.println("Wrong input!"); // wrong id
            }
        }


    }

}
