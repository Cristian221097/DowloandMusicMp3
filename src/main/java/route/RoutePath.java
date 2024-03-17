package route;

public class RoutePath {

    private static final String PATHDOWNLOAD = "C:\\Users\\DELL\\Downloads";

    private static RoutePath instance = null;

    private RoutePath(){}

    public static RoutePath getInstance(){
        if(instance ==  null){
            instance = new RoutePath();
        }
        return instance;
    }

    public String getPathdownload(){
        return PATHDOWNLOAD;
    }

}
