package com.til.autocommit.service;

import com.til.autocommit.domain.Tistory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class TistoryApi {

    //yml
    //tistoryUrl = "https://www.tistory.com/apis/post/list?";
    //볼트??????????? Vault
    //db.........
    private static final String TISTORY_URL = "https://www.tistory.com/apis/post/list?";
    private static final String ACCESS_TOKEN = TistoryApiKey.TOKEN.toString();
    private static final String OUTPUT = "json";
    private static final String BLOG_NAME = "jiwon709";
    private static final int PAGE = 1;

    public static String tistoryApiResult() throws IOException {
        StringBuilder result = new StringBuilder();

        String connectUrl = TISTORY_URL;
        String token = ACCESS_TOKEN;
        String outType = OUTPUT;
        String blog = BLOG_NAME;
        int pageNum = PAGE;

        // to-do api 호출시도
        // url . token & outType & blog & pageNum

        URL url = new URL(connectUrl + token + outType + blog + pageNum);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

        result.append(br.readLine());

        urlConnection.disconnect();

        Tistory tistory = Tistory.builder()
                .postUrl("")
                .date("")
                .title("")
                .build();

        return result.toString();
    }


    public static void main(String[] args) throws IOException {
        System.out.println(ACCESS_TOKEN);
        System.out.println(tistoryApiResult());
    }
}
