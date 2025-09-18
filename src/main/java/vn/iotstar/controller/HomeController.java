package vn.iotstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        // Chuyển hướng trang chủ sang trang danh mục
        return "redirect:/admin/categories";
    }
}
