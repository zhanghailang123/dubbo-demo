package org.zhl.dubbo.spring.boot.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.zhl.dubbo.spring.boot.demo.DemoService;

/**
 * @author hailang.zhang
 * @since 2023-02-23
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return name;
    }
}