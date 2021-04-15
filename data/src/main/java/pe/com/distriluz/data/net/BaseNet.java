package pe.com.distriluz.data.net;

import android.content.Context;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import pe.com.distriluz.data.net.auth.AuthRestApi;
import pe.com.distriluz.data.net.auth.model.RefreshTokensRequest;
import pe.com.distriluz.data.net.auth.model.RefreshTokensResponse;
import pe.com.distriluz.data.net.model.ErrorResponse;
import okio.Buffer;
import pe.com.distriluz.data.utiles.Constantes;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pedro.zevallos on 11/08/2017.
 */

public class BaseNet extends BaseRestApiImpl {
    @Inject
    public BaseNet(Context context) {
        super(context);
    }
    public BaseNet() {
        super();
    }

    public <T> T create(String url, Class<T> service, String token, Context context) {
        Gson gson;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Authorization", token)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        httpClient.addInterceptor(new LoggingRefreshInterceptor(context));

        OkHttpClient client = httpClient.build();
        gson = new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(service);
    }

    public <T> T createLogin(Class<T> service) {
        Gson gson;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("X-AppKey", Constantes.X_APPKEY)
                    .header("X-AppCode", Constantes.X_APPCODE)
                    //.header("User-Agent-Ip", "1.1.1.1")
                    .header("User-Agent-Hostname", "Android")
                    .header("User-Agent-Browser", "Android")
                    .header("User-Agent-BrowserVersion", "1111")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        httpClient.addInterceptor(new LoggingInterceptor());

        OkHttpClient client = httpClient.build();
        gson = new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.HOST_API_AUTENTICACION)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(service);
    }

    public <T> T refreshTokens(Class<T> service, String token, Context context) {
        Gson gson;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("X-AppKey", Constantes.X_APPKEY)
                    .header("X-AppCode", Constantes.X_APPCODE)
                    .header("User-Agent-Hostname", "Android")
                    .header("User-Agent-Browser", "Android")
                    .header("User-Agent-BrowserVersion", "1111")
                    .header("Authorization", token)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        httpClient.addInterceptor(new LoggingInterceptor(context));

        OkHttpClient client = httpClient.build();
        gson = new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.HOST_API_AUTENTICACION)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(service);
    }

    public <T> T createNotToken(String url, Class<T> service) {
        Gson gson;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        httpClient.addInterceptor(new LoggingInterceptor());

        OkHttpClient client = httpClient.build();
        gson = new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(service);
    }

    private class LoggingInterceptor extends BaseRestApiImpl implements okhttp3.Interceptor {
        @Inject
        public LoggingInterceptor(Context context) {
            super(context);
        }

        public LoggingInterceptor() {
            super();
        }
        @Override
        public Response intercept(Chain chain) throws IOException {
            Log.i("LoggingInterceptor", "inside intercept callback");
            Request request = chain.request();
            long t1 = System.nanoTime();
            String requestLog = String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers());
            if (request.method().compareToIgnoreCase("post") == 0) {
                requestLog = "\n" + requestLog + "\n" + bodyToString(request);
            }
            Log.d("TAG", "request" + "\n" + requestLog);
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();

            String responseLog = String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

            String bodyString = response.body().string();

            Log.d("TAG", "response only" + "\n" + bodyString);

            Log.d("TAG", "response" + "\n" + responseLog + "\n" + bodyString);

            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }

        public String bodyToString(final Request request) {
            try {
                final Request copy = request.newBuilder().build();
                final Buffer buffer = new Buffer();
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            } catch (final IOException e) {
                return "did not work";
            }
        }
    }

    private class LoggingRefreshInterceptor extends BaseRestApiImpl implements okhttp3.Interceptor {
        @Inject
        public LoggingRefreshInterceptor(Context context) {
            super(context);
        }

        public LoggingRefreshInterceptor() {
            super();
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Log.i("LoggingRfrshInterceptor", "inside intercept callback");
            AtomicReference<Request> request = new AtomicReference<>(chain.request());
            Request.Builder builderRequest = request.get().newBuilder();

            AtomicReference<Response> response = new AtomicReference<>(executeApiLog(request.get(), chain));

            /*
            long t1 = System.nanoTime();
            String requestLog = String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers());
            if (request.method().compareToIgnoreCase("post") == 0) {
                requestLog = "\n" + requestLog + "\n" + bodyToString(request);
            }
            Log.d("TAG", "request" + "\n" + requestLog);
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();

            String responseLog = String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

            String bodyString = response.body().string();*/
            String bodyString = response.get().body().string();
            int code = response.get().code();
            String errorCodeToken;
            ErrorResponse errorResponse;
/*
            Log.d("TAG", "response only" + "\n" + bodyString);

            Log.d("TAG", "response" + "\n" + responseLog + "\n" + bodyString);*/

            if (code == Constantes.TYPE_ERROR_CODE_TOKEN && code != Constantes.TYPE_CODE_OK) {

                errorResponse = new Gson().fromJson(bodyString, ErrorResponse.class);
                errorCodeToken = errorResponse.getError().getCodigo();

                if (errorCodeToken.equals(Constantes.ERROR_CODE_TOKEN)) {

                    try {
                        CompositeDisposable disposable = new CompositeDisposable();
                        String tat = getToken();
                        Context contextAnterior = this.context;
                        AuthRestApi restApi = refreshTokens(AuthRestApi.class, tat, this.context);
                        RefreshTokensRequest.UsuarioId Usuario = new RefreshTokensRequest.UsuarioId(getIdUser());
                        String rToken = getRefreshToken();

                        disposable.add(restApi.refreshTokens(new RefreshTokensRequest(rToken, Usuario)).subscribe(
                                serverResponse -> {
                                    Boolean indError = false;
                                    if (serverResponse != null) {
                                        if (serverResponse.isSuccessful() && serverResponse.body() != null) {
                                            this.context = contextAnterior;
                                            RefreshTokensResponse RTResponse = serverResponse.body();
                                            setToken(String.format("Bearer %s", RTResponse.getAccessToken()));
                                            setRefreshToken(RTResponse.getRefreshToken());
                                            String newToken = getToken();
                                            builderRequest.header("Authorization", newToken);
                                            builderRequest.build();
                                            request.set(builderRequest.build());

                                            response.set(executeApiLog(request.get(), chain));
                                        }
                                        else{
                                            indError = true;
                                        }
                                    }
                                    else{
                                        indError = true;
                                    }

                                    if(indError){
                                        response.set(response.get().newBuilder().code(Constantes.TYPE_ERROR_CODE_TOKEN).body(ResponseBody.create(null, new byte[0])).build());
                                    }
                                }
                        ));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return response.get().newBuilder()
                    .body(ResponseBody.create(response.get().body().contentType(), bodyString))
                    .build();
        }

        public Response executeApiLog(Request request, Chain chain) throws IOException {

            long t1 = System.nanoTime();
            String requestLog = String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers());
            if (request.method().compareToIgnoreCase("post") == 0) {
                requestLog = "\n" + requestLog + "\n" + bodyToString(request);
            }
            Log.d("TAG", "request" + "\n" + requestLog);
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();

            String responseLog = String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

            String bodyString = response.body().string();

            Log.d("TAG", "response only" + "\n" + bodyString);

            Log.d("TAG", "response" + "\n" + responseLog + "\n" + bodyString);

            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }

        public String bodyToString(final Request request) {
            try {
                final Request copy = request.newBuilder().build();
                final Buffer buffer = new Buffer();
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            } catch (final IOException e) {
                return "did not work";
            }
        }
    }
}
