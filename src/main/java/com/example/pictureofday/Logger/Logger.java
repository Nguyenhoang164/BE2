package com.example.pictureofday.Logger;

import com.example.pictureofday.Model.Picture;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@Aspect
@Component
public class Logger {
    @Pointcut(value = "within(com.example.pictureofday.Controller.*)")
    public void run(){}

    @Before(value = "run()")
    public void showRun(){
        System.out.println("run before controller");
    }
    @AfterThrowing(value = "execution(public * com.example.pictureofday.Controller.PictureController.*(..))", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        // Extracting additional information from the controller method
        Object[] methodArgs = joinPoint.getArgs();
        if (methodArgs.length > 0 && methodArgs[0] instanceof Picture) {
            Picture picture = (Picture) methodArgs[0];

            // Extracting information from the Picture object
            String author = picture.getAuthor();  // Replace with the actual method to get author
            String feedbackContent = picture.getFeedBack(); // Replace with the actual method to get feedback content

            // Ngày giờ feedback
            LocalDateTime feedbackDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = feedbackDateTime.format(formatter);

            // Log thông tin feedback
            String feedbackLog = String.format("Author: %s, Feedback: %s, DateTime: %s", author, feedbackContent, formattedDateTime);
            System.out.println(feedbackLog);
        }
    }
}


