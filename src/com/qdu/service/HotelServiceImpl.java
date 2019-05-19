package com.qdu.service;

import com.qdu.dao.HotelDao;
import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Hotel;
import com.qdu.pojo.Hotelcomment;
import com.qdu.pojo.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public Hotel hotHotel1() {
        return hotelDao.hotHotel1();
    }

    @Override
    public Hotel hotHotel2() {
        return hotelDao.hotHotel2();
    }

    @Override
    public Hotel hotHotel3() {
        return hotelDao.hotHotel3();
    }

    @Override
    public Hotel hotHotel4() {
        return hotelDao.hotHotel4();
    }

    @Override
    public Hotel hotHotel5() {
        return hotelDao.hotHotel5();
    }

    @Override
    public Hotel hotHotel6() {
        return hotelDao.hotHotel6();
    }

    @Override
    public Hotel hotHotel7() {
        return hotelDao.hotHotel7();
    }

    @Override
    public Hotel hotelDetails(int hotelId) {
        return hotelDao.hotelDetails(hotelId);
    }

    @Override
    public List<Layout> layoutInfo(int hotelId) {
        return hotelDao.layoutInfo(hotelId);
    }

    @Override
    public List<City> cityInfo(int hotelId) {
        return hotelDao.cityInfo(hotelId);
    }

    @Override
    public List<Hotelcomment> hotelComment(int hotelId) {
        return hotelDao.hotelComment(hotelId);
    }

    @Override
    public boolean thumb_hotel(int hotelId) {
        hotelDao.thumb_hotel(hotelId);
        return true;
    }

    @Override
    public boolean thumb_comment(int hCommentId) {
        hotelDao.thumb_comment(hCommentId);
        return true;
    }

    @Override
    public void toHotelComment(int hotelId, String uid, String hCommentContent) {
        hotelDao.toHotelComment(hotelId,uid,hCommentContent);
    }

    @Override
    public Hotelcomment getHotelCommentById() {
        return hotelDao.getHotelCommentById();
    }

    @Override
    public List<Hotel> getHotelByCity(int cityId) {
        return hotelDao.getHotelByCity(cityId);
    }

    @Override
    public List<Layout> getLayoutByHotel(int hotelId) {
        return hotelDao.getLayoutByHotel(hotelId);
    }

    @Override
    public void toOrder(int hotelId, String hotelName, float hotelPrice, Integer orderDay, String contact, String OrderName, int orderPeople,String uid) {
        hotelDao.toOrder(hotelId,hotelName,hotelPrice,orderDay,contact,OrderName,orderPeople,uid);
    }

    /**
     * 分页查询
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
    @SuppressWarnings("unchecked")
    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page=new page();
        //总记录数
        int allRow =hotelDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List hotelList = hotelDao.hotelAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(hotelList);
        return page;
    }

    //首页显示超值酒店
    @Override
    public List lowerHotel() {
        return hotelDao.lowerHotel();
    }

    //首页显示畅销酒店
    @Override
    public List hotSaleHotel() {
        return hotelDao.hotSaleHotel();
    }

    @Override
    public void deleteHotelOrder(int hotelorderId) {
        hotelDao.deleteHotelOrder(hotelorderId);
    }

}
