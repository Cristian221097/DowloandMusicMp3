package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoutubePage extends BasePage{

    private By inputSearch = By.xpath("//input[@id='search']");
    private By buttonSearch = By.xpath("//button[@id='search-icon-legacy']");
    private String videoTitleXpath = "//a[@id='video-title']//*[contains(text(),'%s')]";

    private static final String URL ="https://www.youtube.com/";

    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    public void goToYoutube(){
        go(URL);
    }

    public void writeMusic(String titleSong){
        writeField(inputSearch,titleSong,"search music");
    }

    public void clickButtonSearch(){
        clickElement(buttonSearch,"button search");
    }

    public void confirmIsVisibleTitleSong(String titleSong){
        videoTitleXpath = String.format(videoTitleXpath,titleSong);
        By videoTitle = By.xpath(videoTitleXpath);
        confirmIsVisibleElement(videoTitle,"video title");
    }

    public void selectVideo(String titleSong){
        videoTitleXpath = String.format(videoTitleXpath,titleSong);
        By videoTitle = By.xpath(videoTitleXpath);
        clickElement(videoTitle,"video title");
    }

}
