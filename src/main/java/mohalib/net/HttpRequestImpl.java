package mohalib.net;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pendragon on 16-12-12.
 */
public class HttpRequestImpl implements HttpRequest{

    @Override
    public String post(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        List<NameValuePair> formParams = new ArrayList<>();
        params.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            formParams.add(new BasicNameValuePair(key, value.toString()));
        });
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(uefEntity);
            try(CloseableHttpResponse response = httpClient.execute(httpPost)) {
                Logger.getGlobal().log(Level.INFO, "executing post " + httpPost.getURI());
                if (response.getStatusLine().getStatusCode() >= 400){
                    Logger.getGlobal().log(Level.SEVERE, response.getStatusLine().getStatusCode() + "\n--------------------------------------");
                    return null;
                } else {
                    Logger.getGlobal().log(Level.INFO, response.getStatusLine().getStatusCode() + "\n--------------------------------------");
                }

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (SocketTimeoutException e){
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "SocketTimeOutException occurred" + "\n--------------------------------------");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "IOException occurred" + "\n--------------------------------------");
            return null;
        }

        return null;
    }

    @Override
    public String get(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(requestConfig);
        try(CloseableHttpResponse response = httpClient.execute(httpGet);) {
            Logger.getGlobal().log(Level.INFO, "executing get " + httpGet.getURI());
            if (response.getStatusLine().getStatusCode() >= 400){
                Logger.getGlobal().log(Level.SEVERE, response.getStatusLine().getStatusCode() + "\n--------------------------------------");
                return null;
            } else {
                Logger.getGlobal().log(Level.INFO, response.getStatusLine().getStatusCode() + "\n--------------------------------------");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (SocketTimeoutException e){
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "SocketTimeOutException occurred" + "\n--------------------------------------");
            return null;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "ParseException | IOException occurred" + "\n--------------------------------------");
            return null;
        }
        return null;
    }
}
