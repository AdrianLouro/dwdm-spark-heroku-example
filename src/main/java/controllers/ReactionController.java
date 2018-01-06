package controllers;

import services.FavoriteService;
import services.ReactionService;

import static spark.Spark.*;
import static utils.JsonUtil.json;


public class ReactionController {
    public ReactionController(final ReactionService reactionService) {
        get("/reactions", (req, res) ->
                        req.queryParams("positiva") == null ?
                                reactionService.getReaction(req.queryParams("chollo"), req.queryParams("usuario")) :
                                reactionService.getReactionByPositiva(req.queryParams("chollo"), req.queryParams("usuario"), req.queryParams("positiva"))
                , json()
        );

        post("/reactions", (req, res) ->
                reactionService.createReaction(req.queryParams("chollo"), req.queryParams("usuario"), req.queryParams("positiva")), json()
        );

        put("/reactions", (req, res) ->
                reactionService.editReaction(req.queryParams("chollo"), req.queryParams("usuario"), req.queryParams("positiva")), json()
        );

        delete("/reactions", (req, res) ->
                reactionService.deleteReaction(req.queryParams("chollo"), req.queryParams("usuario")), json()
        );
    }
}
