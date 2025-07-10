   @Test
    public void testInNegativeScenariovalidCapital() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/capital";

        given()
        .when()
            .get("/testone")
        .then()
            .statusCode(404);
    }
}