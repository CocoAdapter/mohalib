package mohalib.util;

/**
 * Created by pendragon on 16-12-16.
 */
public class StringUtil {

    public static boolean isEmpty(String string){
        return string == null || string.equals("");
    }

    public static String formatArray(int[] positions){
        StringBuilder sb = new StringBuilder();
        for (int position : positions) {
            sb.append(position);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
