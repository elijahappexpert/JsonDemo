package com.test.jsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.test.jsondemo.api.ApiObservableUserService;
import com.test.jsondemo.model.UsersResponse;
import java.util.LinkedList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.list_users);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter = new UsersAdapter());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiObservableUserService apiService = retrofit.create(ApiObservableUserService.class);


//        Completable c = null;
//        Maybe c = null;
//        Observable c = null;
//        Flowable c = null;
//        Single c = null;
//
//        BackpressureStrategy

        apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<UsersResponse>>() {
                    @Override
                    public void accept(List<UsersResponse> usersResponses) throws Exception {


                        adapter.addUsers(usersResponses);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        printMessage(throwable.getMessage());
                    }
                });

//        ApiCallUserService service = retrofit.create(ApiCallUserService.class);
//        Call<List<UsersResponse>> call = service.getUsers();
//        call.enqueue(new Callback<List<UsersResponse>>() {
//            @Override
//            public void onResponse(Call<List<UsersResponse>> call, Response<List<UsersResponse>> response) {
//                if (response.isSuccessful()) {
//                    List<UsersResponse> body = response.body();
//                    adapter.addUsers(body);
//                } else {
//                    printMessage("Unsuccessful Response");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<UsersResponse>> call, Throwable throwable) {
//                printMessage(throwable.getMessage());
//            }
//        });
    }

    private void printMessage(String message) {
        System.out.println(message);
    }


    class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

        private final List<UsersResponse> responseList = new LinkedList<>();

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserViewHolder(getLayoutInflater().inflate(R.layout.user_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {
            holder.bind(responseList.get(position));
        }

        @Override
        public int getItemCount() {
            return responseList.size();
        }

        void addUsers(List<UsersResponse> usersResponses) {
            responseList.addAll(usersResponses);
            notifyDataSetChanged();
        }

        class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            final TextView tvName;


            private UsersResponse response;

            UserViewHolder(View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvjokes);

                itemView.setOnClickListener(this);
            }

            void bind(UsersResponse response) {
                this.response = response;
                tvName.setText(response.getName());

            }

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, response.getCompany().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
