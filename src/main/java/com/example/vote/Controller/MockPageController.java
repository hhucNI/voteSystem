package com.example.vote.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mock")
public class MockPageController {

    @RequestMapping("/test")
    public String mockPage() {

        return "hello";
    }
}
