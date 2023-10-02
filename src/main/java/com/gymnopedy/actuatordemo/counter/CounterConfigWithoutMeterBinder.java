package com.gymnopedy.actuatordemo.counter;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;

public class CounterConfigWithoutMeterBinder {

    @Bean
    public MeterBinder myCounterWithoutMeterBinder(MyHttpRequestManagerWithoutMicrometer myManager) {
//        return new MeterBinder() {
//
//            @Override
//            public void bindTo(MeterRegistry meterRegistry) {
//                FunctionCounter.builder("my.function.counter2", myManager, m -> {
//                    return m.getCount();
//                }).register(meterRegistry);
//
//            }
//        };

        return meterRegistry -> FunctionCounter.builder("my.function.counter2", myManager, MyHttpRequestManagerWithoutMicrometer::getCount).register(meterRegistry);
    }
}
