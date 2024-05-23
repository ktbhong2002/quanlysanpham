package Database;

public class KiemTra {

    public static boolean isInteger(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFloat(String strNum) {
        try {
            float d = Float.parseFloat(strNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
