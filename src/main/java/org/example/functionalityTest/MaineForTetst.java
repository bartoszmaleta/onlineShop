package org.example.functionalityTest;

import com.jakewharton.fliptables.FlipTableConverters;
import org.example.DAO.ProductsDAO;
import org.example.service.TerminalManager;
import org.example.model.Product;
import org.example.model.list.ProductList;
import org.example.view.TerminalView;

public class MaineForTetst {
    public static void main(String[] args) {
        TerminalView.repeatString("-", 23);

        ProductList productList = new ProductList(new ProductsDAO().readAllProducts());
        String idTitle = "Id";
        String nameTitle = "Name";
        String priceTitle = "Price";
        String amountTitle = "Amount";
//        String totalPrice = "Total Price";

        String[] headers = {idTitle, nameTitle, priceTitle, amountTitle};
        Object[][] data = new Object[productList.getProducts().size()][headers.length];

        System.out.println("headers = " + headers.length);
        System.out.println("data = " + data.length);
        System.out.println("productList = " + productList.getProducts().size());

        for (int i = 0; i < productList.getProducts().size(); i++) {
            Product product = productList.getProducts().get(i);
            data[i][0] = product.getId();
            data[i][1] = product.getName();
            data[i][2] = product.getPrice();
            data[i][3] = product.getAmount();
        }
//        for (int y = 0; y < productList.getProducts().size(); y++) {
//            for (int x = 0; x < headers.length; x++) {
////                data[y][x]
//                data[y][x] = productList.getProducts().get(x).getId();
//                data[y][x + 1] = productList.getProducts().get(x + 1).getName();
//                data[y][x + 2] = productList.getProducts().get(x + 2).getPrice();
//                data[y][x + 3] = productList.getProducts().get(x + 3).getAmount();
//            }
//        }

        System.out.println(FlipTableConverters.fromObjects(headers, data));


        Object[][] table = {
                {productList.getProducts().get(0).getId()
                        , productList.getProducts().get(0).getName()
                        , productList.getProducts().get(0).getPrice()
                        , productList.getProducts().get(0).getAmount()},
                {productList.getProducts().get(1).getId()
                        , productList.getProducts().get(1).getName()
                        , productList.getProducts().get(1).getPrice()
                        , productList.getProducts().get(1).getAmount()},
                {productList.getProducts().get(2).getId()
                        , productList.getProducts().get(2).getName()
                        , productList.getProducts().get(2).getPrice()
                        , productList.getProducts().get(2).getAmount()},
        };

        System.out.println(FlipTableConverters.fromObjects(headers, table));

        boolean isAvailable = TerminalManager.askForBool("Enter (y) if product will be available "
                + "or (n) if not: ");

        System.out.println("isA = " + isAvailable);

    }
}
