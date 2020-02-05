package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newer.domain.Checkins;
import com.newer.service.CheckinsService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/checkins")
public class CheckinsServlet extends HttpServlet {

    private CheckinsService checkinsService = new CheckinsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型和字符集
        resp.setContentType("application/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        Checkins checkins = new Checkins();
        String action=req.getParameter("action");
        if("findBycstate".equals(action)){
            findBycstate(resp);
        }

        try {
            BeanUtils.populate(checkins,req.getParameterMap());
            System.out.println("是："+checkins);
            int rows = checkinsService.addCheckins(checkins);
            JsonObject jsonObject = new JsonObject();
            if (rows > 0) {
                jsonObject.addProperty("suc", true);
            }
            PrintWriter out = resp.getWriter();
            out.print(jsonObject);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
    private void findBycstate(HttpServletResponse resp) throws IOException {
        List<Checkins> list =checkinsService.findBycstate();
        Gson gson=new Gson();
        PrintWriter out =resp.getWriter();
        //将集合转换成数组响应前端
        out.print(gson.toJson(list));
        out.close();
    }


    }
