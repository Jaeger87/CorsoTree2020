import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class TreeExpress {

    private static TreeExpress instance;

    private static Gson gson = new Gson();

    Map<String, User> users = new HashMap<>();
    List<Delivery> deliveries = new ArrayList<>();

    private TreeExpress() {
    }

    public static TreeExpress getInstance() {
        if (instance == null)
            instance = new TreeExpress();
        return instance;
    }

    public void startTreeExpressService() {
        path("/express", () -> {
            path("/users", () -> {
                post("/add", (req, res) -> {
                    User user = gson.fromJson(req.body(), User.class);
                    if (users.containsKey(user.getUuid().toString())) {
                        res.status(400);
                        return "already present";
                    }
                    users.put(user.getUuid().toString(), user);
                    res.status(201);
                    return "ok";
                });
            });
            path("/delivery", () -> {
                post("/create", (req, res) -> {
                    String senderId = req.queryParams("senderId");
                    String receiverId = req.queryParams("receiverId");
                    if(!users.containsKey(senderId) || !users.containsKey(receiverId)) {
                        res.status(400);
                        return "bad request";
                    }
                    User sender = users.get(senderId);
                    User receiver = users.get(receiverId);
                    String weight = req.queryParams("weight");
                    if(weight == null) {
                        res.status(400);
                        return "bad request";
                    }
                    Double w = Double.parseDouble(weight);
                    if (sender == null || receiver == null) {
                        res.status(404);
                        return "user not found";
                    }
                    Delivery delivery = new Delivery(UUID.randomUUID(), sender, receiver,
                            w, DeliveryType.SHIPPING);
                    if (deliveries.contains(delivery)) {
                        res.status(400);
                        return "already present";
                    }
                    deliveries.add(delivery);
                    res.status(201);
                    return "ok";
                });
                delete("/remove", (req, res) -> {
                    String deliveryId = req.queryParams("id");
                    Optional<Delivery> delivery = deliveries.stream()
                            .filter(d -> d.getId().toString().equals(deliveryId))
                            .findFirst();
                    if (delivery.isEmpty()) {
                        res.status(404);
                        return "not found";
                    }
                    if (delivery.get().getDeliveryType() == DeliveryType.SHIPPED) {
                        res.status(403);
                        return "not allowed";
                    }
                    deliveries.remove(delivery.get());
                    res.status(200);
                    return "ok";
                });
                put("/shipped", (req, res) -> {
                    String deliveryId = req.queryParams("id");
                    Optional<Delivery> delivery = deliveries.stream()
                            .filter(d -> d.getId().toString().equals(deliveryId))
                            .findFirst();
                    if (delivery.isEmpty()) {
                        res.status(404);
                        return "not found";
                    }
                    delivery.get().setDeliveryType(DeliveryType.SHIPPED);
                    res.status(201);
                    return "ok";
                });

            });

            path("/deliveries", () -> {
                get("/shipping", (req, res) -> {
                    List<Delivery> shippingDeliveries = deliveries.stream()
                            .filter(delivery -> delivery.getDeliveryType().equals(DeliveryType.SHIPPING))
                            .collect(Collectors.toList());
                    res.type("application/json");
                    res.body();
                    res.status(200);
                    return gson.toJson(shippingDeliveries);
                });
                get("/user", (req, res) -> {
                    String receiverId = req.queryParams("receiver");
                    if(!users.containsKey(receiverId)) {
                        res.status(400);
                        return "bad request";
                    }
                    User receiver = users.get(receiverId);
                    List<Delivery> userDeliveries = deliveries.stream()
                            .filter(delivery -> delivery.getReceiver().equals(receiver))
                            .collect(Collectors.toList());
                    res.type("application/json");
                    res.body();
                    res.status(200);
                    return gson.toJson(userDeliveries);
                });
            });

        });
    }

    public static void main(String[] args) {
        TreeExpress treeExpress = TreeExpress.getInstance();
        treeExpress.startTreeExpressService();
    }

}
