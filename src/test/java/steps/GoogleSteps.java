package steps;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        // Aquí ya se escribe el texto Y se pulsa ENTER automáticamente
        google.enterSearchCriteria("Selenium QA");
    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        // Este paso ahora está vacío porque el ENTER ya se envió en el paso anterior.
        // Lo dejamos para que el archivo .feature no se rompa, pero no hace nada.
    }

    @Then("^the results match the criteria$")
    public void validateResults(){
        String result = google.firstResult();
        // Verificamos que el resultado no esté vacío y contenga la palabra buscada (en cualquier caso)
        Assert.assertTrue("El primer resultado no debe estar vacío", result != null && !result.isEmpty());
        Assert.assertTrue("El resultado debería mencionar Selenium", result.toLowerCase().contains("selenium"));
    }
}
