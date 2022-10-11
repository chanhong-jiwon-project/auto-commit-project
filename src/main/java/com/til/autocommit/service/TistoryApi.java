package com.til.autocommit.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TistoryApi {

    private static String tistoryUrl = "https://www.tistory.com/apis/post/list?";
    private static String access_token = TistoryApikey.TOKEN.toString();
    private static String output = "output-type";
    private static String blogName = "blog-name";
    private static int page = 1;

    public static List<String> tistoryApiResult(){
        List<String> resultList = new ArrayList<>();

        String url = tistoryUrl;
        String token = access_token;
        String outType = output;
        String blog = blogName;
        int pageNum = page;

        //to-do api 호출시도

        return resultList;
    }


    public static void main(String[] args) {
        System.out.println(tistoryApiResult());
    }
}
