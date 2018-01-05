package controllers;

import services.UserService;

import static spark.Spark.*;
import static utils.JsonUtil.json;

public class UserController {
    public UserController(final UserService userService) {
        get("/users/:id", (req, res) ->
                userService.getUser(req.params("id")), json()
        );

        get("/users", (req, res) ->
                req.queryParams("telephone") != null ? userService.getUserByTelephone(req.queryParams("telephone")) :
                        req.queryParams("alias") != null ? userService.getUserByAlias(req.queryParams("alias")) :
                                userService.getUsers(), json()
        );


        after((req, res) -> {
            res.type("application/json");
        });
    }
}
