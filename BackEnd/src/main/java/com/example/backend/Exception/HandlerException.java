package com.example.backend.Exception;

import com.example.backend.Dto.Response.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ResponseApi> handleRuntime(Exception e) {
        ResponseApi responseApi = new ResponseApi();
        responseApi.setStatus(ErrorCode.UNKNOWN.getCode());
        responseApi.setMessage(e.getMessage());
        return ResponseEntity.status(ErrorCode.UNKNOWN.getStatusCode()).body(responseApi);
    }

    @ExceptionHandler(value = GlobalException.class)
    ResponseEntity<ResponseApi> handleGlobal(GlobalException e) {
        ErrorCode errorCode = e.getErrorCode();
        ResponseApi responseApi = new ResponseApi();
        responseApi.setMessage(errorCode.getMessage());
        responseApi.setStatus(errorCode.getCode());
        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(responseApi);
    }
    

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ResponseApi> handleNotvalid(MethodArgumentNotValidException e) {
        String keyError = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(keyError);
        ResponseApi responseApi = new ResponseApi();
        responseApi.setMessage(errorCode.getMessage());
        responseApi.setStatus(errorCode.getCode());
        return ResponseEntity.badRequest().body(responseApi);
    }


}
