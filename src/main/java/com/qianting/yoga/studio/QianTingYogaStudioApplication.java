package com.qianting.yoga.studio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qianting.yoga.studio.mapper")
@SpringBootApplication
public class QianTingYogaStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianTingYogaStudioApplication.class, args);
    }

}
