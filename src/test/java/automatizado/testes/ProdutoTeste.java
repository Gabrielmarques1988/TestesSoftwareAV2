package automatizado.testes;

import automatizado.pageObject.LoginPO;
import automatizado.pageObject.ProdutoPO;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProdutoTeste extends BaseTest {

    private static ProdutoPO ProdutoPage;

    @BeforeClass
    public static void PrepararTests() {
        ProdutoPage = new ProdutoPO(driver);
        ProdutoPage.buttonAdcionar.click();
        ProdutoPage.buttonAdcionar.click();
    }

    @Test
    public void nenhumCampoDeveEstarEmBranco(){

        ProdutoPage.inputCodigo.sendKeys("");
        ProdutoPage.inputNome.sendKeys("");
        ProdutoPage.inputQuantidade.sendKeys("");
        ProdutoPage.inputValor.sendKeys("");
        ProdutoPage.inputData.sendKeys("");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void campoCodigoDeveSerPreenchido(){

        ProdutoPage.inputCodigo.sendKeys("");
        ProdutoPage.inputNome.sendKeys("BeyBlade");
        ProdutoPage.inputQuantidade.sendKeys("1");
        ProdutoPage.inputValor.sendKeys("2000");
        ProdutoPage.inputData.sendKeys("29/11/2024");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");

    }

    @Test
    public void campoNomeDeveSerPreenchido(){

        ProdutoPage.inputCodigo.sendKeys("001");
        ProdutoPage.inputNome.sendKeys("");
        ProdutoPage.inputQuantidade.sendKeys("1");
        ProdutoPage.inputValor.sendKeys("2000");
        ProdutoPage.inputData.sendKeys("29/11/2024");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");

    }

    @Test
    public void campoQuantidadeDeveSerPreenchido(){

        ProdutoPage.inputCodigo.sendKeys("001");
        ProdutoPage.inputNome.sendKeys("BeyBlade");
        ProdutoPage.inputQuantidade.sendKeys("");
        ProdutoPage.inputValor.sendKeys("2000");
        ProdutoPage.inputData.sendKeys("29/11/2024");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");

    }
}

