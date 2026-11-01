package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage {

    private String searchTextField = "//input[@name='q']";
    private String firstResult = "(//h3)[1]";

    public void navigateToGoogle(){
        // /ncr evita redirecciones por país y acelera la carga limpia
        navigateTo("https://www.google.com/ncr");
        
        // BLINDAJE: Forzamos a Selenium a esperar a que el campo de búsqueda exista en el DOM
        // antes de dar por buena la navegación.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchTextField)));
    }

    public void enterSearchCriteria(String criteria){
        // Truco profesional: Escribir el texto y añadir "\n" (tecla ENTER) al final.
        // Esto es mucho más fiable que buscar el botón y hacer clic, ya que evita 
        // problemas de superposición de elementos o banners.
        write(searchTextField, criteria + "\n");
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}
