package com.qdu.dao;

import com.qdu.pojo.*;

import java.util.List;

public interface HotelDao {
    //获取热门酒店1-7
    Hotel hotHotel1();
    Hotel hotHotel2();
    Hotel hotHotel3();
    Hotel hotHotel4();
    Hotel hotHotel5();
    Hotel hotHotel6();
    Hotel hotHotel7();
    int getAllRowCount();//获取总行数
    List hotelAll(int offset, int length);//所有酒店
    Hotel hotelDetails(int hotelId);//根据酒店ID获取酒店详细信息；
    List<Layout> layoutInfo(int hotelId);//根据酒店ID获取具体房型的信息
    List<City> cityInfo(int hotelId);//根据酒店ID获取所在城市的名字；
    List<Hotelcomment> hotelComment(int hotelId);//根据酒店ID获取评论；
    void thumb_hotel(int hotelId);//点赞功能（酒店)
    void thumb_comment(int hCommentId);//点赞功能（酒店评论)
    void toHotelComment(int hotelId,String uid,String hCommentContent);//发表酒店评论
    Hotelcomment getHotelCommentById();//根据hCommentId获取最新评论
    List<Hotel> getHotelByCity(int cityId);//根据cityId获取酒店信息
    List lowerHotel();//首页显示超值酒店
    List hotSaleHotel();//首页显示热销酒店
    List<Layout> getLayoutByHotel(int hotelId);//根据hotelId获取信息
    void toOrder(int hotelId,String hotelName,float hotelPrice,Integer orderDay,String contact,String OrderName,int orderPeople,String uid);//预定
    void deleteHotelOrder(int hotelorderId);//删除酒店预定




}
