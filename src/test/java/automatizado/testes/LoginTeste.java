package automatizado.testes;

import automatizado.pageObject.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTeste extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTests() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazio() {
        loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("123");

        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem estar em branco");

    }
}

//    @Test
//    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazio(){
//        loginPage.executarAcaoLogar("admin@admin.com", "admin@123");
//
//        assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");
//    }
//}
