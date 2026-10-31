package pages;

public class TestSandBox extends BasePage {

    private String categoryDropdown = "//select[@id='testingDropdown']";

    // El constructor se ha eliminado por completo. 
    // Java usará el constructor por defecto que llama a super() sin argumentos.

    public void navigateToSandbox(){
        navigateTo("https://www.testandquiz.com/selenium/testing.html");
    }

    public void selectCategory(String category){
        selectFromDropdownByValue(categoryDropdown, category);
    }
}
