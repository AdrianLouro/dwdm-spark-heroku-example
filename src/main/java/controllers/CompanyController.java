package controllers;

import services.CompanyService;

import static spark.Spark.after;
import static spark.Spark.get;
import static utils.JsonUtil.json;


public class CompanyController {
    public CompanyController(final CompanyService companyService) {
        get("/companies/:id", (req, res) ->
                companyService.getCompany(req.params("id")), json()
        );

        get("/companies", (req, res) ->
                companyService.getCompanies(), json()
        );
    }

}
