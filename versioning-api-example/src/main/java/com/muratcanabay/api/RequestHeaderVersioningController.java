package com.muratcanabay.api;

import com.muratcanabay.model.ApiModelV1;
import com.muratcanabay.model.ApiModelV2;
import com.muratcanabay.model.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RequestHeaderVersioningController {

    /**
     * Custom Header versioning used by Microsoft
     * <p>
     * +No URI pollution
     * -No caching because URI doesn't change
     * -Can not execute on the browser
     *
     * @return {@link com.muratcanabay.model}
     */
    @GetMapping(value = "/model", headers = "X-API-Version=1")
    public ApiModelV1 getModelV1() {
        return ApiModelV1.builder()
                .name("Test")
                .surname("Surname")
                .build();
    }

    @GetMapping(value = "/model", headers = "X-API-Version=2")
    public ApiModelV2 getModelV2() {
        return ApiModelV2.builder()
                .name(new Name("Version 2", "Request Header"))
                .build();
    }

}
