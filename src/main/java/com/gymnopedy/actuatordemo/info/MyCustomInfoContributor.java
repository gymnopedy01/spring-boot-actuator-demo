package com.gymnopedy.actuatordemo.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * @see org.springframework.boot.actuate.info.InfoEndpoint
 */
@Component
public class MyCustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {

        //비즈니스를 통한 값제공, DB조회를 통한 값제공인경우

        HashMap<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");

        builder.withDetail("myCustomInfo", map);
    }

}
