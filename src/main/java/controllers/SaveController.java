package controllers;

import services.SaveService;

import static spark.Spark.*;
import static utils.JsonUtil.json;

public class SaveController {
    public SaveController(final SaveService saveService) {
        get("/saves/:id", (req, res) ->
                saveService.getSave(req.params("id")), json()
        );

        get("/saves", (req, res) ->
                saveService.getSaves(), json()
        );

        get("/saves/:id/reactions", (req, res) ->
                saveService.getReactionsCountFor(req.params("id"), req.queryParams("positiva")), json()
        );

        post("/saves", (req, res) ->
                saveService.createSave(
                        req.queryParams("titulo"),
                        req.queryParams("enlace"),
                        req.queryParams("descripcion"),
                        req.queryParams("precioAntes"),
                        req.queryParams("precioDespues"),
                        req.queryParams("empresaNoPatrocinada"),
                        req.queryParams("empresaPatrocinada"),
                        req.queryParams("usuario"),
                        req.queryParams("categoria")
                ), json()
        );

        put("/saves/:id", (req, res) ->
                saveService.editSave(
                        req.params("id"),
                        req.queryParams("titulo"),
                        req.queryParams("enlace"),
                        req.queryParams("descripcion"),
                        req.queryParams("precioAntes"),
                        req.queryParams("precioDespues"),
                        req.queryParams("empresaNoPatrocinada"),
                        req.queryParams("empresaPatrocinada"),
                        req.queryParams("categoria")
                ), json()
        );

        delete("/saves/:id", (req, res) ->
                saveService.deleteSave(req.params("id")), json()
        );

    }

}
