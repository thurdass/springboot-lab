package com.thurdass.springboot_lab.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {



}
