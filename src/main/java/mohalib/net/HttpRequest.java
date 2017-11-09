package mohalib.net;

import java.util.Map;

/**
 * Created by pendragon on 16-12-12.
 */
public interface HttpRequest {

    String post(String url, Map<String, Object> params);

    String get(String url);
}
