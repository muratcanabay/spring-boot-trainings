package com.muratcanabay.api;

import com.muratcanabay.model.ApiModelV1;
import com.muratcanabay.model.ApiModelV2;
import com.muratcanabay.model.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class URIVersioningController {

    /**
     * URI versioning used by Twitter
     * <p>
     * -URI pollution
     * +Caching
     * +Can execute on the browser
     *
     * @return {@link com.muratcanabay.model}
     */

    @GetMapping("v1/uri-versioning")
    public ApiModelV1 getModelV1() {
        return ApiModelV1.builder()
                .name("Test")
                .surname("Surname")
                .build();
    }

    @GetMapping("v2/uri-versioning")
    public ApiModelV2 getModelV2() {
        return ApiModelV2.builder()
                .name(new Name("Version 2", "URI"))
                .build();
    }
}
