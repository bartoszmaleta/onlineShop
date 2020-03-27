package org.example.controller;

import org.example.DAO.OrdersDAO;
import org.example.DAO.ProductsDAO;
import org.example.DAO.UsersDAO;
import org.example.Services.TerminalManager;
import org.example.Services.menu.AdminMenu;
import org.example.model.Category;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.list.CategoryList;
import org.example.model.list.OrderList;
import org.example.model.list.ProductList;
import org.example.model.list.UserList;
import org.example.model.user.User;
import org.example.view.TableView;
import org.example.view.TerminalView;

import java.io.FileNotFoundException;

public class AdminController {
    private final User user;
    private ProductList productList;
    private final UserList userList;
    private OrderList ordersList;

    AdminController(User user) {
        this.user = user;
        this.productList = new ProductList(new ProductsDAO().readAllProducts());
        this.userList = new UserList(new UsersDAO().readAllUsers());
        this.ordersList = new OrderList(new OrdersDAO().readAllOrders());
    }

    public void deleteMode() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            TerminalView.printString("Delete mode");

            AdminMenu.displayDeleteMode();

            int choice = TerminalManager.askForInt("What do You want to do: ");

            switch (choice) {
                case 1:
//                    TableView.displayProducts(user);
//                    deleteProduct();
                    break;
                case 2:
//                    TableView.displayAllCategories();
//                    deleteCategory();
                    break;
                case 3:
//                    TableView.displayAllOrders();
//                    deleteOrder();
                    break;
                case 4:
//                    TableView.displayAllUsers();
//                    deleteUser();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public void editMode() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            TerminalView.printString("Edit mode");

            AdminMenu.displayEditMode();

            int choice = TerminalManager.askForInt("What do You want to do: ");

            switch (choice) {
                case 1:
//                    TableView.displayProducts(user);
//                    editProduct();
                    break;
                case 2:
//                    TableView.displayAllCategories();
//                    editCategory();
                    break;
                case 3:
                    TableView.displayAllOrders();
                    editOrder();
                    break;
                case 4:
//                    TableView.displayAllUsers();
//                    editUser();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public void addMode() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            TerminalView.printString("Add mode");

            AdminMenu.displayAddMode();

            int choice = TerminalManager.askForInt("What do You want to do: ");

            switch (choice) {
                case 1:
                    TableView.displayProducts(user);
                    addNewProduct();
                    break;
                case 2:
                    TableView.displayAllCategories();
                    addNewCategory();
                    break;
                case 3:
                    TableView.displayAllOrders();
//                    addNewOrder();
                    break;
                case 4:
//                    TableView.displayAllUsers();
//                    addNewUser();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            AdminMenu.displayMenu();

//            this.productList = new ProductList(new ProductDAO().read());

            int choice = TerminalManager.askForInt("What is Your choice? ");

            switch (choice) {

                case 1: {
                    TerminalView.clearScreen();
                    TableView.displayProducts(user);
                    TerminalView.pressAnyKeyToContinue();
                    break;
                }

                case 2: {
                    TerminalView.clearScreen();
                    TableView.displayAllCategories();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                }

                case 3: {
                    TerminalView.clearScreen();
                    TableView.displayAllOrders();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                }

                case 4: {
//                    TODO:
//                    TerminalView.clearScreen();
//                    TableView.displayProducts(user);
//                    TableView.displayAllUsers();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                }

                case 5: {
                    TerminalView.clearScreen();
                    deleteMode();
                    break;
                }

                case 6: {
                    TerminalView.clearScreen();
                    editMode();
                    break;
                }

                case 7: {
                    TerminalView.clearScreen();
                    addMode();
                    break;
                }

                case 9: {
                    // TODO: STATS
                    TerminalView.clearScreen();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                }

                case 0: {
                    isRunning = false;
                    break;
                }
                default: {
//                    Display.clearScreen();
                }
            }
        }
    }

    private void addNewProduct() throws FileNotFoundException {
        String name = TerminalManager.askForString("Enter name of the new product: ");
        double price = TerminalManager.askForDouble("Enter price of the new product: ");
        int amount = TerminalManager.askForInt("Enter amount of the new product: ");
        boolean isAvailable = TerminalManager.askForBool("Enter (y) if product will be available "
                + "or (n) if not: ");

        CategoryList categoryList = new CategoryList();
        TableView.displayAllCategoriesByCategoryList(categoryList);

        String idOfCategoryString = TerminalManager.askForString("Enter id of category of the new product: ");

        while (!idOfCategoryString.matches("[0-" + categoryList.getCategoryList().size() + "]+")) {
            TerminalView.printString("Wrong input! You inputted zero or categoryId which is too high!");
            idOfCategoryString = TerminalManager.askForString("Enter id of category of the new product: ");
            // break?
        }
        if (!idOfCategoryString.equals("0")) {
            int categoryId = Integer.parseInt(idOfCategoryString);
            boolean isInStorage;
            if (amount > 0) {
                isInStorage = true;
            } else {
                isInStorage = false;
            }
            Product product = new Product(name, price, amount, isAvailable, categoryId, isInStorage, 0);
            this.productList.add(product);
            product.write();
        }
    }

    private void addNewCategory() {
        String name = TerminalManager.askForString("Enter name of the new category: ");
        Category category = new Category(name);
        category.writeToDB();
    }

    private void editOrder() throws FileNotFoundException {
        int indexOfOrderToSend = TerminalManager.askForInt("Enter id of order to send");
        TableView.displayAllOrders();
        Order order = this.ordersList.getOrders().get(indexOfOrderToSend);

        // Only onTheWay done!
        // TODO: more statuses
        order.setStatusOnTheWay();
        order.updateStatus();
    }
}
