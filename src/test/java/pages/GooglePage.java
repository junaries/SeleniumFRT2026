package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GooglePage extends BasePage {

    // Busca CUALQUIER elemento (input o textarea) con name='q'
    private String searchTextField = "//*[@name='q']";
    
    // Botón de "Aceptar todo" o "Accept all" del banner de cookies de Google
    private String consentButton = "//button[contains(., 'Aceptar') or contains(., 'Accept')]";
    
    private String firstResult = "(//h3)[1]";

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/ncr");
        
        // 1. TRUCO PARA EUROPA: Intentar cerrar el banner de cookies si aparece
        try {
            // Esperamos solo 3 segundos por el banner. Si no está, salta al catch y sigue.
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath(consentButton))).click();
            System.out.println("✅ Banner de cookies detectado y aceptado.");
        } catch (Exception e) {
            System.out.println("ℹ️ No hay banner de cookies (o ya fue aceptado). Continuando...");
        }

        // 2. Ahora sí, esperamos a que el campo de búsqueda esté presente en el DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchTextField)));
    }

    public void enterSearchCriteria(String criteria){
        // Escribe el texto y pulsa ENTER
        write(searchTextField, criteria + "\n");
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}
