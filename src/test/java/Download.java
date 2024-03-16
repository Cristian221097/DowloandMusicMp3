import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.ConvertMusicPage;
import pages.YoutubePage;

public class Download extends BaseTest {

    private YoutubePage youtubePage;
    private ConvertMusicPage convertMusicPage;
    private static final String TITLEVIDEO = "chocoleyrol - tiki tiki";

    @Test(description = "Download music mp3")
    public void downloadMusic(){
        youtubePage = new YoutubePage(BaseTest.getDriver());
        convertMusicPage = new ConvertMusicPage(getDriver());
        youtubePage.goToYoutube();
        youtubePage.writeMusic(TITLEVIDEO);
        youtubePage.clickButtonSearch();
        youtubePage.confirmIsVisibleTitleSong(TITLEVIDEO);
        youtubePage.selectVideo(TITLEVIDEO);
        youtubePage.confirmIsVisibleSelectedVideo(TITLEVIDEO);
        convertMusicPage.goToNotube();
        convertMusicPage.setUrlMusic(TITLEVIDEO);
        convertMusicPage.clickButtonOk();
        convertMusicPage.clickLinkSugetion(TITLEVIDEO);
        convertMusicPage.backWindowDownload();
        convertMusicPage.clickButtonDownload();

    }
}
