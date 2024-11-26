package com.ddlab.rnd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "DISCOVERYFEIGNCLIENT", url = "https://this-is-a-dummy-url-or-placeholder.com")
public interface AppFeignClient {

    @GetMapping(path = "/v1/info")
    String getInfo(URI baseUri);
}
