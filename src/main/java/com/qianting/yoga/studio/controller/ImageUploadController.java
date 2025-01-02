package com.qianting.yoga.studio.controller;

/**
 * 图片服务
 * @author Me
 * @version 1.0
 * @date 2024/12/30 12:29
 * @Description:上传图片
 */

import com.qianting.yoga.studio.domian.entity.ResponseResult;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import okhttp3.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Value("${github.repo}")
    private String repo;
    @Value("${github.token}")
    private String token;
    @Value("${github.username}")
    private String username;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 上传图片
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/image")
    public ResponseResult uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);

        String fileName = image.getOriginalFilename();
        String json = "{\"message\":\"upload image\",\"content\":\"" + encodedImage + "\"}";

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/" + username + "/" + repo + "/contents/" + fileName)
                .addHeader("Authorization", "token " + token)
                .put(body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            return ResponseResult.errorResult(400, "Error uploading image to GitHub");
        }

        String uri = "https://raw.githubusercontent.com/" + username + "/" + repo + "/refs/heads/master/" + fileName;
//        jdbcTemplate.update("INSERT INTO images (uri) VALUES (?)", uri);

        System.out.println(uri);
        return ResponseResult.successResult(uri);
    }
}