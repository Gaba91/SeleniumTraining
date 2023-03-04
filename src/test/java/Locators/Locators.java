package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators
{
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {
        //Se coloca la direccion del driver, segun corresponda (chrome, mozilla, safari, edge, etc...)
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        //Se crea la instancia u objeto del navegador
        driver = new ChromeDriver();

        //Maximiza el navegador
        driver.manage().window().maximize();

        //Enviamos la URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);

    }


    @Test
    public void Locators() throws InterruptedException
    {
        // ------Localizador por id------
        /*WebElement demoSite = driver.findElement(By.id("site-name"));
        Thread.sleep(3000);
        //click = selecciona / click en el elemento --> "demoSite"
        demoSite.click();
        Thread.sleep(3000);*/

        // ------Localizador por nombre------
        /*WebElement userName = driver.findElement(By.name("userName"));
        userName.sendKeys("Automation23");
        Thread.sleep(3000);*/

        // ------Localizador por nombre de clase------
        /*WebElement logo = driver.findElement(By.className("logo"));
        logo.click();
        Thread.sleep(3000);*/

        // ------Localizador por tagname------ <-- se omite por no parecer ser muy funcional

        // ------Localizador por link text------
        /*WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep(3000);*/

        // ------Localizador por partial link text------
        /*WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(3000);*/

        // ------Localizador por cssSelector------
        //WebElement userName = driver.findElement(By.cssSelector("input[name='usarName']")); <-- opcion #1
        //WebElement demoSite = driver.findElement(By.cssSelector("div#site-name")); <-- opcion #2
        //WebElement demoSite = driver.findElement(By.cssSelector("#site-name")); <-- opcion #3 esta tecnica solo funciona por id, no por name
        //demoSite.click();
        //WebElement userName = driver.findElement(By.cssSelector("input[type='text'][name='userName']")); <-- opcion #4
        //userName.sendKeys("Automation");
        //Thread.sleep(3000);

        // ------Localizador por XPath------
        //Hay dos tipos de Xpaths: absoluto y relativo
        //El XPath absoluto por buenas practicas NO debe utilizarse o abusar de el.
        //Diferencias: el XPath absoluto es toda la ruta/ubicacion del elemento, su sintaxis inicia con una diagonal

        // ------XPath absoluto
        /*WebElement  userName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
        userName.sendKeys("locura");
        Thread.sleep(3000);*/

        //------XPath relativo
        //El uso de XPath relativo, inicio con doble "//" (diagonal y/o slash)
        //El uso de XPath relativo se realiza por medio de los tags y atributos (tags = span, img, button, input, etc...)

        //1. Un solo atributo
        /*WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("REGISTRO");
        Thread.sleep(3000);*/

        //2. Dos atributos
        /*WebElement demoSite = driver.findElement(By.xpath("a[@title='Home' and @style='font-size:32px;']"));
        demoSite.click();
        Thread.sleep(3000);*/

        //3. Usando "*" o "tag" (el asterisco en lenguaje informatico significa totalidad) + la palabra "contains" (contiene) y el atributo
        /*WebElement demoSite = driver.findElement(By.xpath("//*[contains(text(), 'Demo Site')]"));
        demoSite.click();
        Thread.sleep(3000);*/

    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();

    }

}

/*Locators: se puede localizar por diferentes atributos, ej. por id, name, class, tagname, link text, partial link text, cssSelector, xpath <-- debe ser siempre la
ultima tecnica para automatizar, primero agotar todas las demas alternativas antes que usar xpath*/