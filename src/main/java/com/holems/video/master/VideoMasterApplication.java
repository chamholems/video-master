package com.holems.video.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.holems.video.master.*.mapper")
@SpringBootApplication
public class VideoMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoMasterApplication.class, args);
    }

}
