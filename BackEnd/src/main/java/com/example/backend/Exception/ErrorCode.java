package com.example.backend.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_EXIST(1002, "User not exist", HttpStatus.NOT_FOUND),
    AUTHOR_NOT_EXIST(1022, "authorize id not exist", HttpStatus.NOT_FOUND),
    CATE_NOT_EXIST(1023, "category id not exist", HttpStatus.NOT_FOUND),
    ORDER_NOT_EXIST(1023, "order id not exist", HttpStatus.NOT_FOUND),
    ORDER_DETAIL_NOT_EXIST(1023, "order detail id not exist", HttpStatus.NOT_FOUND),
    PRODUCT_NOT_EXIST(1023, "product id not exist", HttpStatus.NOT_FOUND),
    ROLE_NOT_EXIST(1023, "role id not exist", HttpStatus.NOT_FOUND),
    UNKNOWN(666, "Unknow", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_PASSWORD_NOT_NULL(1004, "PassWord is required", HttpStatus.BAD_REQUEST),
    USER_FULLNAME_NOT_NULL(1005, "FullName is required", HttpStatus.BAD_REQUEST),
    USER_EMAIL_NOT_NULL(1006, "Email is required", HttpStatus.BAD_REQUEST),
    CATEGORIES_NAME_NOT_NULL(1007, "Categories name is required", HttpStatus.BAD_REQUEST),
    ORDERDETAILS_PRICE_NOT_NULL(1008, "OrderDetails price is required", HttpStatus.BAD_REQUEST),
    ORDERDETAILS_QUANTITY_NOT_NULL(1009, "OrderDetails quantity is required", HttpStatus.BAD_REQUEST),
    ORDER_DATE_NOT_NULL(1010, "Orders createDateOrder is required", HttpStatus.BAD_REQUEST),
    ORDER_ADDRESS_NOT_NULL(1011, "Orders address is required", HttpStatus.BAD_REQUEST),
    PRODUCTS_NAME_NOT_NULL(1012, "Products name is required", HttpStatus.BAD_REQUEST),
    PRODUCTS_IMAGE_NOT_NULL(1013, "Products image is required", HttpStatus.BAD_REQUEST),
    PRODUCTS_PRICE_NOT_NULL(1014, "Products price is required", HttpStatus.BAD_REQUEST),
    PRODUCTS_DATE_NOT_NULL(1015, "Products createDateProduct is required", HttpStatus.BAD_REQUEST),
    PRODUCTS_AVAILABLE_NOT_NULL(1016, "Products available is required", HttpStatus.BAD_REQUEST),
    ROLES_NAME_NOT_NULL(1017, "Roles name is required", HttpStatus.BAD_REQUEST),
    USER_EMAIL_REQUIRED(1018, "Email invalid", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1019, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZE(1020, "Unauthorize", HttpStatus.FORBIDDEN),
    INVALID_KEY(1021, "Key in valid", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(Integer code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }


    private final Integer code;
    private final String message;
    private final HttpStatusCode statusCode;

}
