package libs;

public class TestDataStage {
    public final static String VALID_LOGIN = "994555123456-312";
    public final static String VALID_PASS = "4JFP4hmD";

    public final static String INVALID_LOGIN_1 = "994555123456-31";
    public final static String INVALID_LOGIN_2 = "994555123456-3121";
    public final static String INVALID_LOGIN_3 = "";
    public final static String INVALID_LOGIN_4 = "994555123456-312a";

    public final static String INVALID_PASS_1 = "4JFP4hm";
    public final static String INVALID_PASS_2 = "4JFP4hmD ";
    public final static String INVALID_PASS_3 = "";
    public final static String INVALID_PASS_4 = "4JFP4HMD";

    public final static String WAREHOUSE_1 = ".//span[text()='Test-01']";
    public final static String WAREHOUSE_2 = ".//span[text()='Гянджлик молл']";
    public final static String WAREHOUSE_3 = ".//span[text()='Test-03']";
    public final static String WAREHOUSE_4 = ".//span[text()='№ 15']";

    public final static String URL_STAGE = "https://mp-pos-web-stage.umico.az/login";
}
