package com.student.studentmanagement.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model, RedirectAttributes redirectAttributes) {
        String errorMessage = ex.getMessage() != null ? ex.getMessage() : "An unexpected error occurred";
        
        // Log the exception for debugging
        ex.printStackTrace();
        
        redirectAttributes.addFlashAttribute("error", errorMessage);
        return "redirect:/";
    }
}




