package com.qing.Controller;

import com.qing.vo.Items;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理器（控制器）-------------->需要适配器
 */

public class ShowItemsController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setItemId(1);
        items1.setItemsName("thinkpad t590 ");
        items1.setItemsPrice("12000");
        items1.setItemsCreatetime(new Date());

        Items items2 = new Items();
        items2.setItemId(2);
        items2.setItemsName("thinkpad x390 ");
        items2.setItemsPrice("13800");
        items2.setItemsCreatetime(new Date());

        Items items3 = new Items();
        items3.setItemId(3);
        items3.setItemsName("Mac");
        items3.setItemsPrice("23000");
        items3.setItemsCreatetime(new Date());

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        ModelAndView modelAndView = new ModelAndView();
        //request.setAttribute(key,value)
        modelAndView.addObject("itemsListKey",itemsList);
        //request.getRequestDispactcher("showItemsList.jsp").forword(request,response)
        modelAndView.addObject("showItemsList");
        return modelAndView;
    }
}
