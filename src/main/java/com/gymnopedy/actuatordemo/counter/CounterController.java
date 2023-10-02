package com.gymnopedy.actuatordemo.counter;

import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterController {

    private final MyHttpRequestManager myHttpRequestManager;

    @GetMapping("/req")
    public String req() {

        myHttpRequestManager.increase();

        return "ok";
    }
    @Counted("my.counted.counter")
    @GetMapping("/counted")
    public String counted() {
        return "ok";
    }

}
