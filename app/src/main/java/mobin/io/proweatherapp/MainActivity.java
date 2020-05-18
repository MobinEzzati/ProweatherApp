package mobin.io.proweatherapp;

import adapter.RecyclerViewAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModels.RecyclerViewModel;
import global.Global;
import httpRequest.ClientApi;
import httpRequest.RapidApi;
import interFaces.onItemClickListener;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.rv_main_added)
    RecyclerView rv_added;
    @BindView(R.id.et_main_city)
    EditText et_city ;
    List<RecyclerViewModel> recyclerViewModels ;
    onItemClickListener onItemClickListener ;
    dataModels.List list =  new dataModels.List();
    @BindView(R.id.iv_main_search)
    ImageView iv_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recommendRecyclerView();
        iv_search.setOnClickListener( this);
    }
    private void recommendRecyclerView(){

        onItemClickListener = new onItemClickListener() {
            @Override
            public void onClick(View view, int position, String cityName) {
                Global.toast(getApplicationContext() , cityName);
            }
        };
        recyclerViewModels = new ArrayList<>();
        recyclerViewModels.add( new RecyclerViewModel("12" , "karaj" ,"kj"));
        recyclerViewModels.add( new RecyclerViewModel("12" , "karaj" ,"kj"));
        rv_added.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        rv_added.setAdapter( new RecyclerViewAdapter(recyclerViewModels , getApplicationContext() ,onItemClickListener));
        rv_added.setHasFixedSize(true);
    }

   private void getrespone(String cityName ){


       RapidApi rapidApi = ClientApi.getRetrofit().create(RapidApi.class);
     Single<dataModels.List> listSingle = rapidApi.getList(cityName);
     listSingle.subscribeOn(Schedulers.newThread())
             .subscribe(new SingleObserver<dataModels.List>() {
                 @Override
                 public void onSubscribe(Disposable d) {
                     Log.d("tag", "onSubscribe: " + d.toString());
                 }

                 @Override
                 public void onSuccess(dataModels.List value) {
                     Log.d("tag", "onSuccess: " + value);
                 }

                 @Override
                 public void onError(Throwable e) {
                     Log.d("tag", "onError: "+ e.getMessage());
                 }
             });




   }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_main_search){
            getrespone(et_city.getText().toString());
        }
    }
}
