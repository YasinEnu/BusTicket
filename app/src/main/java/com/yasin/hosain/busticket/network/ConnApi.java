package com.yasin.hosain.busticket.network;

import com.google.gson.JsonObject;
import com.yasin.hosain.busticket.activity.BusSeatDetails.model.SeatData;
import com.yasin.hosain.busticket.activity.busList.model.BusData;
import com.yasin.hosain.busticket.activity.busList.model.BusListRequestPOJO;
import com.yasin.hosain.busticket.activity.routeSearch.model.FromOrToCityModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ConnApi {

    @GET("v2/routes/from")
    Call<FromOrToCityModel> getFromStations();

    @GET("v2/routes/to/{from_station_id}")
    Call<FromOrToCityModel> getToStation(@Path("from_station_id") String fromId);

    @GET("v2/coaches/{coach_id}/seats")
    Call<SeatData> getSeatDetails(@Path("coach_id") String coach_id);

    @POST("v2/coaches/search")
    Call<BusData> getBusListFromServer(@Body BusListRequestPOJO busListRequestPOJO);
}
