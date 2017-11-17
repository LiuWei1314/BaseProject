package com.kemai.basemodule.net;


import com.kemai.basemodule.net.request.RoomDetailRequest;
import com.kemai.basemodule.utils.RxUtils;

import io.reactivex.functions.Function;
import retrofit2.Retrofit;

/**
 * @author mark.liu
 */
public class Api {
    private ApiService mApiService;

    public Api(Retrofit retrofit) {
        mApiService = retrofit.create(ApiService.class);
    }

    private class HttpResultFunc<T> implements Function<HttpResult<T>, T> {
        @Override
        public T apply(HttpResult<T> httpResult) throws Exception {
            if (httpResult.getCode() != 200 || !"ok".equals(httpResult.getMsg())) {
                throw new ApiException(httpResult);
            }
            return httpResult.getResult();
        }
    }

    public void test(ProgressSubscriber subscriber) {
        RoomDetailRequest request = new RoomDetailRequest();
        request.setRoom_id("233");
        mApiService.roomDetail(request).compose(RxUtils.ioMain()).map(new HttpResultFunc<>()).subscribe(subscriber);
    }
}
