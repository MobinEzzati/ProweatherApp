package httpRequest;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

   public static  final String BASE_URI = " https://community-open-weather-map.p.rapidapi.com";
   public  static  Retrofit retrofit = null ;

   public  static Retrofit getRetrofit(){


       if (retrofit == null){

                   retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URI)
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();

       }

       return retrofit ;
   }

}
