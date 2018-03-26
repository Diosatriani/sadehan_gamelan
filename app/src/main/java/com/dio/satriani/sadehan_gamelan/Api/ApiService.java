package com.dio.satriani.sadehan_gamelan.Api;

import com.dio.satriani.sadehan_gamelan.Beans.IklanList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 3/19/2018.
 */

public interface ApiService {

    @GET("trackingeye/GetMarkers.php")
    Call<IklanList> getMyJSONMarker();
}
