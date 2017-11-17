package com.kemai.basemodule.net;


import com.kemai.basemodule.net.request.RoomDetailRequest;
import com.kemai.basemodule.net.response.RoomDetailResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.kemai.basemodule.net.UrlConstant.ROOM_DETAIL;

/**
 * @author mark.liu
 */
public interface ApiService {
    @POST(ROOM_DETAIL)
    @Headers({"Content-Type:multipart/form-data;charset=UTF-8"})
    Observable<HttpResult<RoomDetailResponse>> roomDetail(@Body RoomDetailRequest request);
}