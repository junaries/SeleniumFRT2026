package pages;

public class GooglePage extends BasePage {

    private String searchTextField = "//input[@name='q']";
    private String searchButton = "//button[@name='btnK']"; // El botón "Buscar" también tiene un name universal
    
    // ⚠️ OJO: Aquí tenías el string vacío. He puesto un XPath real para el primer resultado de Google, 
    // de lo contrario el test compilará pero fallará al no encontrar el elemento.
    private String firstResult = "(//h3)[1]"; 

    // El constructor se ha eliminado por completo. 
    // Java usará el constructor por defecto que llama a super() sin argumentos.

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}
