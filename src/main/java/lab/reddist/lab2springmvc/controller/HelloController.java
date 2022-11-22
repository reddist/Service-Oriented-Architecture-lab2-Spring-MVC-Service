package lab.reddist.lab2springmvc.controller;

import lab.reddist.lab2springmvc.dto.response.HttpOkMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping(value = "", produces = "application/xml")
    public HttpOkMessage hello() {
        return new HttpOkMessage("hello spring mvc!");
    }
}