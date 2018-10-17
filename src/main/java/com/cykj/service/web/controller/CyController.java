package com.cykj.service.web.controller;

import com.cykj.service.base.Constants;
import com.cykj.service.web.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangsq
 * @date 2018/7/16 15:42.
 */
@Controller
@RequestMapping("/")
public class CyController {

    @Autowired
    WeatherInfoService weatherInfoService;

    @RequestMapping("/index.html")
    private String toIndex(){
//        weatherInfoService.saveWeatherInfos(Constants.WEATHER_LIST);
        return "index";
    }

    @RequestMapping("/industry.html")
    private String toIndustry(){
        return "company/industry";
    }

    @RequestMapping("/area.html")
    private String toAre(){
        return "company/area";
    }

    @RequestMapping("/options.html")
    private String toOptions(){
        return "company/options";
    }

    @RequestMapping("/property/area.html")
    private String toPropertyArea(){
        return "property/area";
    }

    @RequestMapping("/property/option.html")
    private String toPropertyOption(){
        return "property/option";
    }

    @RequestMapping("/downloadApp")
    private ResponseEntity<byte[]> downloadApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();

        File file = new File(courseFile+"/src/main/webapp/WEB-INF/app/app-mock-debug.apk");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
