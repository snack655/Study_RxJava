package four;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import third.Log;

import javax.security.auth.callback.CallbackHandler;
import java.io.IOException;

public class HttpGetExample {
    private static final String URL_README =
            "https://raw.githubusercontent.com/yudong80/reactivejava/master/README.md";

    public static final String GITHUB_ROOT =
            "https://raw.githubusercontent.com/yudong80/reactivejava/master/";


    public static final String FIRST_URL = "https://api.github.com/zen";
    public static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_hell";

    public final OkHttpClient client = new OkHttpClient();

    private Callback onSuccess = new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Response response) throws IOException {
            Log.i(response.body().string());
        }
    };

    public void run() {
        Request request = new Request.Builder()
                .url(FIRST_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.i(response.body().string());

                Request request = new Request.Builder()
                        .url(SECOND_URL)
                        .build();
                client.newCall(request).enqueue(onSuccess);
            }
        });
    }

    public static void main(String[] args) {
        HttpGetExample demo = new HttpGetExample();
        demo.run();
    }
}
