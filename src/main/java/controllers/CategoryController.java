package controllers;

import services.CategoryService;

import static spark.Spark.get;
import static utils.JsonUtil.json;


public class CategoryController {
    public CategoryController(final CategoryService categoryService) {
        get("/categories/:id", (req, res) ->
                categoryService.getCategory(req.params("id")), json()
        );

        get("/categories", (req, res) ->
                categoryService.getCategories(), json()
        );

        get("/categories/:id/saves", (req, res) ->
                categoryService.getSaves(req.params("id")), json()
        );
    }

}
