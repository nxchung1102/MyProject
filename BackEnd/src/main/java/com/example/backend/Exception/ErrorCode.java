package com.example.backend.Exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    USER_NOT_EXIST(1001, "User not exist"),
    UNKNOWN(666),
    USER_USERNAME_NOT_NULL(1002, "UserName is required"),
    USER_PASSWORD_NOT_NULL(1002, "PassWord is required"),
    USER_FULLNAME_NOT_NULL(1002, "FullName is required"),
    USER_EMAIL_NOT_NULL(1002, "Email is required"),
    CATEGORIES_NAME_NOT_NULL(1002, "Categories name is required"),
    ORDERDETAILS_PRICE_NOT_NULL(1002, "OrderDetails price is required"),
    ORDERDETAILS_QUANTITY_NOT_NULL(1002, "OrderDetails quantity is required"),
    ORDER_DATE_NOT_NULL(1002, "Orders createDateOrder is required"),
    ORDER_ADDRESS_NOT_NULL(1002, "Orders address is required"),
    PRODUCTS_NAME_NOT_NULL(1002, "Products name is required"),
    PRODUCTS_IMAGE_NOT_NULL(1002, "Products image is required"),
    PRODUCTS_PRICE_NOT_NULL(1002, "Products price is required"),
    PRODUCTS_DATE_NOT_NULL(1002, "Products createDateProduct is required"),
    PRODUCTS_AVAILABLE_NOT_NULL(1002, "Products available is required"),
    ROLES_NAME_NOT_NULL(1002, "Roles name is required"),
    USER_EMAIL_REQUIRED(1003, "Email invalid"),
    UNAUTHENTICATED(1003, "Unauthenticated"),
    ;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(Integer code) {
        this.code = code;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
