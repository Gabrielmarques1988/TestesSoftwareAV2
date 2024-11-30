package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    /**
     * Construtor base para a criação da fábrica de emelentos (PageFactory)
     *
     * @param driver
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem(){
        return this.spanMensagem.getText();
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    public void executarAcaoLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }

    public String obterTituloDaPagina() { return driver.getTitle(); }
}
