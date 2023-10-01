package com.gymnopedy.actuatordemo.custommetrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStockMeterBinderConfig {

    @Bean
    public MeterBinder myMeterBinder(MyStockManager myStockManager) {
        return new MeterBinder() {
            @Override
            public void bindTo(MeterRegistry registry) {
//                Gauge.builder("my.stock", myStockManager, m -> {
//                    return m.getStockCount();
//                }).register(registry);

                Gauge.builder("my.stock", myStockManager)
                        .register(registry);

            }
        };


    }
}
