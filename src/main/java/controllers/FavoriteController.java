package controllers;

import services.FavoriteService;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static utils.JsonUtil.json;


public class FavoriteController {
    public FavoriteController(final FavoriteService favoriteService) {
        get("/favorites", (req, res) ->
                favoriteService.getFavorite(req.queryParams("chollo"), req.queryParams("usuario")), json()
        );

        post("/favorites", (req, res) ->
                favoriteService.createFavorite(req.queryParams("chollo"), req.queryParams("usuario"), req), json()
        );

        delete("/favorites", (req, res) ->
                favoriteService.deleteFavorite(req.queryParams("chollo"), req.queryParams("usuario"), req), json()
        );
    }
}
