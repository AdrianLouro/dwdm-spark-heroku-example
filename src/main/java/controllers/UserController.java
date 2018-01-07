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
                req.queryParams("telefono") != null ? userService.getUserByTelephone(req.queryParams("telefono")) :
                        req.queryParams("alias") != null ? userService.getUserByAlias(req.queryParams("alias")) :
                                userService.getUsers(), json()
        );

        get("/users/:id/favorites", (req, res) ->
                userService.getFavoriteSaves(req.params("id")), json()
        );

        post("/users", (req, res) ->
                userService.createUser(req.queryParams("telefono"), req.queryParams("alias"), req), json()
        );

        get("/users/:id/saves", (req, res) ->
                userService.getSaves(req.params("id")), json()
        );

        get("/users/:id/reactions", (req, res) ->
                userService.getReactionsCount(req.params("id"), req.queryParams("positiva")), json()
        );
    }

}
