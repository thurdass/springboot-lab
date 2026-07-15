package com.thurdass.springboot_lab.controllers;

import com.thurdass.springboot_lab.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private void validateNumbers(String... numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsupportedMathOperationException("Please set a valid numeric value!");
            }
        }
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        validateNumbers(numberOne, numberTwo);

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        validateNumbers(numberOne, numberTwo);

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        validateNumbers(numberOne, numberTwo);

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        validateNumbers(numberOne, numberTwo);

        Double dividend = convertToDouble(numberOne);
        Double divisor = convertToDouble(numberTwo);

        if (divisor == 0) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }

        return Math.round((dividend / divisor) * 100.0) / 100.0;
    }
    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        validateNumbers(numberOne, numberTwo);

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable String number) {

        validateNumbers(number);

        Double value = convertToDouble(number);

        return Math.round(Math.sqrt(value) * 100.0) / 100.0;
    }

    private Double convertToDouble(String strNumber) {
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isBlank()) {
            return false;
        }

        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
