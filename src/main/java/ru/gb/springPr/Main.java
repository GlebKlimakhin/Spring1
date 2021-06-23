package ru.gb.springPr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = ctx.getBean(ProductService.class);
            Scanner sc = new Scanner(System.in);
            String resp = sc.next();
            if(resp.equals("/avg")){
                System.out.println(productService.avgCost());
            }
            else if(resp.equals("/num")){
                System.out.println(productService.getProductsNumber());
            }
            else if(resp.equals("/read")){
                System.out.println(productService.read());
        }
        }
    }


