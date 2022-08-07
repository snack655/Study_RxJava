package third;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpHelper {
    private static OkHttpClient client = new OkHttpClient();

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response res = client.newCall(request).execute();
            return res.body().string();
        } catch (IOException e) {
            Log.e(e.getMessage());
            throw e;
        }
    }
}
