package com.gymnopedy.actuatordemo.tags;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
@Slf4j
public class TagController {

    private final MyQueueManagerWithTags myQueueManagerWithTags;

    @GetMapping("/push")
    public String push() {
        myQueueManagerWithTags.push();
        return "ok";
    }

    @GetMapping("/pop")
    public String pop() {
        myQueueManagerWithTags.pop();
        return "ok";
    }

    @Counted(value = "my.counted", extraTags = {"type", "value1", "type2", "value2"})
    @GetMapping("/counted")
    public String counted() {
        return "ok";
    }

    @Counted(value = "my.counted", extraTags = {"type", "value3", "type2", "value5"})
    @GetMapping("/decreased")
    public String decreased() {
        return "ok";
    }


    final MeterRegistry meterRegistry;

    @GetMapping("/test")
    public String test() {
        Counter count1 = Counter.builder("my.test")
                .tag("type", "push")
                .register(meterRegistry);
        Counter count2 = Counter.builder("my.test")
                .tag("type", "push")
                .register(meterRegistry);
        Counter count3 = Counter.builder("my.test")
                .tag("type", "push222")
                .register(meterRegistry);
        Counter count4 = Counter.builder("my.test")
                .tag("type", "push333")
                .register(meterRegistry);

        log.info("{} {} {} {}", count1, count2, count3, count4);
        return "ok";
    }

}
