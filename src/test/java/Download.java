import basetest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ConvertMusicPage;
import pages.YoutubePage;

public class Download extends BaseTest {

    private YoutubePage youtubePage;
    private ConvertMusicPage convertMusicPage;

    @Test(description = "Download music mp3",dataProvider = "Songs")
    public void downloadMusic(String song) throws InterruptedException {
        youtubePage = new YoutubePage(BaseTest.getDriver());
        convertMusicPage = new ConvertMusicPage(getDriver());
        youtubePage.goToYoutube();
        youtubePage.writeMusic(song);
        youtubePage.clickButtonSearch();
        youtubePage.confirmIsVisibleTitleSong(song);
        youtubePage.selectVideo(song);
        youtubePage.confirmIsVisibleSelectedVideo(song);
        convertMusicPage.goToNotube();
        convertMusicPage.setUrlMusic(youtubePage.getUrlVideo());
        Thread.sleep(3000);
        convertMusicPage.clickButtonOk();
        Thread.sleep(3000);
        convertMusicPage.backWindowDownload();
        Thread.sleep(3000);
        convertMusicPage.clickButtonDownload();
        convertMusicPage.waitDownloadMusic(youtubePage.getNameSelectedVideo());
    }

    @DataProvider(name = "Songs")
    public Object[][] paramaters(){
        return new Object[][]{
                {"ROMEO SANTOS - SOY HOMBRE (INTRO ACAPELLA) PARA MUSICÓLOGOS"},
                {"Raulin Rodríguez - Te Pierdo & Te Pienso (INTRO ACAPELLA / REMASTERIZADA) PARA MUSICOLOGOS"},
        };
    }
}
