package httpRequest;

import dataModels.Example;
import dataModels.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RapidApi {

   @GET("/forecast?q= sanfrancisco,us")
    Single<Example> getList(@Query("q") String cityName);
}
