package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import route.RoutePath;

import java.util.Set;

public class ConvertMusicPage extends BasePage {


    private By inputSearch = By.xpath("//*[@id='keyword']");
    private By buttonOk = By.xpath("//*[@id='submit-button']");
    private By buttonDownload = By.xpath("//*[@id='download-button-content']");

    private By checkConfirmIsHuman = By.xpath("//*[text()='Verificar que usted es humano']/..//*[@type='checkbox']");

    private String titleFileReady = "Su archivo está listo! - noTube";
    private String titlePage = "Convertidor de YouTube a mp3 y mp4 gratuito - noTube";

    private static final String URL = "https://notube.fi/es/youtube-app-v152";

    public ConvertMusicPage(WebDriver driver) {
        super(driver);
    }

    public void goToNotube() {
        go(URL);
    }

    public void setUrlMusic(String url) {
        writeField(inputSearch, url, "input 'Search'");
    }

    public void clickButtonOk() {
        clickElement(buttonOk, "button 'Ok'");
    }

    public void clickButtonDownload() {
        clickExecuterJS(buttonDownload, "button 'Download'");
    }

    public void backWindowDownload() {
        Set<String> windows = driver.getWindowHandles();

        for (String window :
                windows) {

            driver.switchTo().window(window);
            String titleWindowCurrent = driver.getTitle();

            if (titleWindowCurrent.equals(titleFileReady) || titleWindowCurrent.equals(titlePage)) {
                break;
            }
        }

    }

    public void waitDownloadMusic(String nameFile) {
        waitDownloadFile(RoutePath.getInstance().getPathdownload(), nameFile + ".mp3");
    }

}
