
import com.google.gson.Gson;

import java.util.*;

import static spark.Spark.*;

public class MiniEcommerce {

    private static Gson gson = new Gson();

    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        path("/ecommerce", () -> {
            path("/product", () -> {
                post("/add", (req, res) -> {
                    Product product = gson.fromJson(req.body(), Product.class);
                    if(products.contains(product)){
                        res.status(400);
                        return "already present";
                    }
                    products.add(product);
                    res.status(201);
                    return "ok";
                });
                delete("/remove", (req, res) -> {
                    String productId = req.queryParams("id");

                    products.removeIf(p->p.getId().equals(productId));
                    res.status(200);
                    return "ok";
                });
                post("/buy", (req, res) -> {
                    String productId = req.queryParams("id");
                    String quantityString = req.queryParams("quantity");
                    if(productId == null || quantityString == null) {
                        res.status(400);
                        return "malformed request";
                    }
                    int quantity = Integer.parseInt(quantityString);
                    Optional<Product> productIdOptional = getProduct(productId);
                    if(productIdOptional.isEmpty()) {
                        res.status(404);
                        return "not found";
                    }
                    Product product = productIdOptional.get();
                    if(product.getStockAvailability() < quantity) {
                        res.status(404);
                        return "out of stock";
                    }
                    product.decreaseStockAvailability(quantity);
                    res.status(200);
                    return "ok";
                });
            });
            path("/products", () -> {
                get("/available", (req, res) -> {
                    res.type("application/json");
                    res.status(200);
                    return gson.toJson(products);
                });
            });
        });

    }

    private static Optional<Product> getProduct(String productId) {
        return products.stream()
                .filter(prod -> prod.getId().equals(productId))
                .findFirst();
    }

}
