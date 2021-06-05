package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest extends AppCompatActivity {

    TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);

        textViewResult = findViewById(R.id.retrofitTextView);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
       //getPost();
       //createPost();
        updateData();
        //deletePost();
    }

    private void getPost(){
        Call<List<Post>> call = jsonPlaceHolderApi.getPost(5,"id","desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts){

                    String content = " ";
                    content+= "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void createPost(){
        Post post = new Post(22 , "new Title" , "Mustafa Elgendy");

        Call<Post> call = jsonPlaceHolderApi.createPost(55,"New Title","Mustafa Ahmed Elgendy");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post post1 = response.body();

                    String content = "";
                    content += "Code: " + response.code() + "\n";
                    content+= "ID: " + post1.getId() + "\n";
                    content += "User ID: " + post1.getUserId() + "\n";
                    content += "Title: " + post1.getTitle() + "\n";
                    content += "Text: " + post1.getText() + "\n\n";
                    textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void updateData(){
        Post post = new Post(5,null,"New Text");
        Call<Post> call = jsonPlaceHolderApi.putPost(2,post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post post1 = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content+= "ID: " + post1.getId() + "\n";
                content += "User ID: " + post1.getUserId() + "\n";
                content += "Title: " + post1.getTitle() + "\n";
                content += "Text: " + post1.getText() + "\n\n";
                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void deletePost(){
        Call<Void> call = jsonPlaceHolderApi.deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}