package com.qdu.controller;

import com.qdu.dao.CityDao;
import com.qdu.page.page;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Foodinfo;
import com.qdu.pojo.Route;
import com.qdu.pojo.Scene;
import com.qdu.service.FoodService;
import com.qdu.service.MessageService;
import com.qdu.service.RouteService;
import com.qdu.service.SceneService;
import com.qdu.service.*;
import com.qdu.service.FoodService;
import com.qdu.service.MessageService;
import com.qdu.service.RouteService;
import com.qdu.service.SceneService;
import com.qdu.utils.Json;
import net.sf.json.JSON;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private SceneService sceneService;
    @Autowired
    private SearchService searchService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private EssayService essayService;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {

        List sceneList=sceneService.sceneList();
        model.addAttribute("sceneList",sceneList);
       List hotMessageList= messageService.messageByScore();
       model.addAttribute("hotMessageList",hotMessageList);
       List hotRouteList=  routeService.indexHotRoute();
       model.addAttribute("hotRouteList",hotRouteList);
      List lowerPriceRoute= routeService.lowerPriceRoute();
      model.addAttribute("lowerPriceRoute",lowerPriceRoute);
        return "index";
    }


//首页跟团游
    @RequestMapping("user/tours")
    public String tours(Model model) {
      Route route1= routeService.hotRoute1();
        Route route2= routeService.hotRoute2();
        Route route3= routeService.hotRoute3();
        Route route4= routeService.hotRoute4();
        Route route5= routeService.hotRoute5();
        Route route6= routeService.hotRoute6();
        Route route7= routeService.hotRoute7();
        model.addAttribute("route1",route1);
        model.addAttribute("route2",route2);
        model.addAttribute("route3",route3);
        model.addAttribute("route4",route4);
        model.addAttribute("route5",route5);
        model.addAttribute("route6",route6);
        model.addAttribute("route7",route7);
       List hotCity= routeService.hotCity();
       model.addAttribute("hotCity",hotCity);

        return "userRoute";
    }

//首页景点
    @RequestMapping("user/scene")
    public String scene(Model model) {
        Scene scene1=sceneService.hotScene1();
        Scene scene2=sceneService.hotScene2();
        Scene scene3=sceneService.hotScene3();
        Scene scene4=sceneService.hotScene4();
        Scene scene5=sceneService.hotScene5();
        Scene scene6=sceneService.hotScene6();
        Scene scene7=sceneService.hotScene7();
        model.addAttribute("scene1",scene1);
        model.addAttribute("scene2",scene2);
        model.addAttribute("scene3",scene3);
        model.addAttribute("scene4",scene4);
        model.addAttribute("scene5",scene5);
        model.addAttribute("scene6",scene6);
        model.addAttribute("scene7",scene7);
        return "userScene";
}

//首页美食
    @RequestMapping("user/food")
    public String food(Model model,HttpServletRequest request){
        Foodinfo food1=foodService.hotFood1();
        Foodinfo food2=foodService.hotFood2();
        Foodinfo food3=foodService.hotFood3();
        Foodinfo food4=foodService.hotFood4();
        Foodinfo food5=foodService.hotFood5();
        Foodinfo food6=foodService.hotFood6();
        Foodinfo food7=foodService.hotFood7();
        model.addAttribute("food1",food1);
        model.addAttribute("food2",food2);
        model.addAttribute("food3",food3);
        model.addAttribute("food4",food4);
        model.addAttribute("food5",food5);
        model.addAttribute("food6",food6);
        model.addAttribute("food7",food7);

        List cateList=categoryService.categoryList();
        model.addAttribute("cateList",cateList);

        return "userFood";
    }

    //首页组团游,获取全部组团游列表，分页（需改成获取全部已批准组团游列表）
    @RequestMapping("user/groupAll")
    public String groupAll(Model model,HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page2 = groupService.queryForPage2(Integer.valueOf(pageNo),8);
            model.addAttribute("page2",page2);
            List groupAll = page2.getList();
            model.addAttribute("groupAll", groupAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userGroupAll";
    }



    //根据省份id获取城市数据后直接使用@ResponseBody装成json数据
    @RequestMapping(value = "user/getCityByPro/{provinceId}")
    @ResponseBody
    public Json getCityByPro(@PathVariable("provinceId") int provinceId){
        List cityList=cityService.getCityByPro(provinceId);

        if(cityList!=null){
            for (Object c:cityList) {
                System.out.println(c);
            }
            return new Json(true,"success",cityList);
        }else{
            return new Json(false,"fail",null);
        }
    }

//获取全部留言，分页
       @RequestMapping("user/message")
        public String message(Model model, HttpServletRequest request){
           try {
               String pageNo = request.getParameter("pageNo");
               if (pageNo == null) {
                   pageNo = "1";
               }
               page page = messageService.queryForPage(Integer.valueOf(pageNo), 8);
               model.addAttribute("page", page);
               List messageAll = page.getList();
               model.addAttribute("messageAll", messageAll);
           } catch (Exception e) {
               e.printStackTrace();
           }
            return "userMessage";
           }

           //模糊搜索所有:路线 酒店 攻略
           @RequestMapping("user/searchAll")
    public String searchAll(Model model,HttpServletRequest request,String keyword){
               model.addAttribute("keyword", keyword);
               model.addAttribute("searchListByEssay",searchService.searchEssay(keyword));
               try {
                   String pageNo = request.getParameter("pageNo");
                   if (pageNo == null) {
                       pageNo = "1";
                   }
                   page page = searchService.queryForPage(Integer.valueOf(pageNo), 8,keyword);
                   model.addAttribute("page", page);
                   List searchListByRoute = page.getList();
               model.addAttribute("searchListByRoute",searchListByRoute);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               model.addAttribute("searchListByHotel",searchService.searchHotel(keyword));
        return "userSearch";
           }

//根据关键词和好评度搜索路线
    @RequestMapping(value="user/keywordByScore",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByScore(Model model,HttpServletRequest request,String keyword){
        List searchListByRouteScore=null;
        model.addAttribute("keyword", keyword);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = searchService.queryForPageByScore(Integer.valueOf(pageNo), 8,keyword);
            model.addAttribute("page", page);
             searchListByRouteScore = page.getList();
            model.addAttribute("searchListByRouteScore",searchListByRouteScore);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByRouteScore;
    }


    //根据关键词和价格搜索路线
    @RequestMapping(value="user/keywordByPrice1",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByPirce1(Model model,HttpServletRequest request,String keyword){
        List searchListByRoutePrice1=null;
        model.addAttribute("keyword", keyword);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = searchService.queryForPageByPrice1(Integer.valueOf(pageNo), 8,keyword);
            model.addAttribute("page", page);
            searchListByRoutePrice1 = page.getList();
            model.addAttribute("searchListByRoutePrice1",searchListByRoutePrice1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByRoutePrice1;
    }


    //根据关键词和价格搜索路线
    @RequestMapping(value="user/keywordByPrice2",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByPirce2(Model model,HttpServletRequest request,String keyword){
        List searchListByRoutePrice2=null;
        model.addAttribute("keyword", keyword);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page1 = searchService.queryForPageByPrice2(Integer.valueOf(pageNo), 8,keyword);
            model.addAttribute("page1", page1);
            searchListByRoutePrice2 = page1.getList();
            model.addAttribute("searchListByRoutePrice2",searchListByRoutePrice2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByRoutePrice2;
    }

    //根据关键词和价格搜索路线
    @RequestMapping(value="user/keywordByPrice3",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByPirce3(Model model,HttpServletRequest request,String keyword){
        List searchRouteByPirce3=null;
        model.addAttribute("keyword", keyword);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page2 = searchService.queryForPageByPrice3(Integer.valueOf(pageNo), 8,keyword);
            model.addAttribute("page2", page2);
            searchRouteByPirce3 = page2.getList();
            model.addAttribute("searchRouteByPirce3",searchRouteByPirce3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchRouteByPirce3;
    }
    //根据关键词和价格搜索路线
    @RequestMapping(value="user/searchByNo",method = RequestMethod.POST)
    @ResponseBody
    public List searchByNo(Model model,HttpServletRequest request,String keyword){
        List searchRouteByNo=null;
        model.addAttribute("keyword", keyword);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page3 = searchService.queryForPage(Integer.valueOf(pageNo), 8,keyword);
            model.addAttribute("page3", page3);
            searchRouteByNo = page3.getList();
            model.addAttribute("searchRouteByNo",searchRouteByNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchRouteByNo;
    }

    //首页游记列表，分页（应改未被举报列表）
    @RequestMapping("user/essayAll")
    public String essayAll(Model model,HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page2 = essayService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page2",page2);
            List essayAll = page2.getList();
            model.addAttribute("essayAll", essayAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userEssayAll";
    }

    //首页攻略
    @RequestMapping("user/essay")
    public String essay(Model model,HttpServletRequest request){
        Essay essay1=essayService.hotEssay1();
        Essay essay2=essayService.hotEssay2();
        Essay essay3=essayService.hotEssay3();
        Essay essay4=essayService.hotEssay4();
        Essay essay5=essayService.hotEssay5();
        Essay essay6=essayService.hotEssay6();
        Essay essay7=essayService.hotEssay7();
        model.addAttribute("essay1",essay1);
        model.addAttribute("essay2",essay2);
        model.addAttribute("essay3",essay3);
        model.addAttribute("essay4",essay4);
        model.addAttribute("essay5",essay5);
        model.addAttribute("essay6",essay6);
        model.addAttribute("essay7",essay7);

        List cateList=categoryService.categoryList();
        model.addAttribute("cateList",cateList);

        return "userEssayIndex";
    }
}