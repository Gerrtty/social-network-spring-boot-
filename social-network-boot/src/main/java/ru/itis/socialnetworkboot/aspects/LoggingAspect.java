package ru.itis.socialnetworkboot.aspects;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {

    private File file;
    private FileWriter fileWriter;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @SneakyThrows
    public LoggingAspect() {
        file = new File("log.dat");
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    @Pointcut("execution(public * ru.itis.socialnetworkboot.*.*.*(..))")
    public void callAspect() { }

    @SneakyThrows
    @Before("callAspect()")
    public void before(JoinPoint jp) {

        try {
            fileWriter = new FileWriter(file, true);

            String args = Arrays.stream(jp.getArgs())
                    .map(a -> a.toString())
                    .collect(Collectors.joining(","));

            String log = "Method " + jp.toString() + " with args=[" + args + "] was called";

            logger.info("\u001B[32m" + log + "\u001B[0m");

            fileWriter.write("Current time = " + LocalDateTime.now() + " " + log + "\n");
            fileWriter.close();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}
