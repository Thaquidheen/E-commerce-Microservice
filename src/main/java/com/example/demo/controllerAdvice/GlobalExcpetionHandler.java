package com.example.demo.controllerAdvice;


import com.example.demo.Exceptions.ProductNotExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcpetionHandler {

    @ExceptionHandler(ProductNotExceptions.class)
 public ResponseEntity<String> ProductNotException(){
         ResponseEntity<String>  response = new ResponseEntity<>(
          "Product Not found exception",
                 HttpStatus.BAD_GATEWAY
         );
         return response;
 }
}
