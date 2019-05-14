package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Hotel;
import com.qdu.pojo.Hotelcomment;
import com.qdu.pojo.Layout;

import java.util.List;

public interface HotelService {
    //获取热门酒店1-7
    Hotel hotHotel1();
    Hotel hotHotel2();
    Hotel hotHotel3();
    Hotel hotHotel4();
    Hotel hotHotel5();
    Hotel hotHotel6();
    Hotel hotHotel7();
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    Hotel hotelDetails(int hotelId);//根据酒店ID获取酒店详细信息；
    List<Layout> layoutInfo(int hotelId); //根据酒店ID获取酒店房型的详细信息；
    List<City> cityInfo(int hotelId);//根据酒店ID获取所在城市的名字；
    List<Hotelcomment> hotelComment(int hotelId);//根据酒店ID获取评论；
    boolean thumb_hotel(int hotelId);//点赞功能（酒店)
    boolean thumb_comment(int hCommentId);//点赞功能（酒店评论)
    void toHotelComment(int hotelId,String uid,String hCommentContent);//发表酒店评论
    Hotelcomment getHotelCommentById(int hotelId);//根据hCommentId获取最新评论
    List<Hotel> getHotelByCity(int cityId);//根据cityId获取酒店信息
    List lowerHotel();//首页显示超值酒店
    List hotSaleHotel();//首页显示畅销酒店

}
