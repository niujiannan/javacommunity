package cn.j2blog.javacommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.j2blog.javacommunity.dao")
public class JavacommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavacommunityApplication.class, args);
    }

}
