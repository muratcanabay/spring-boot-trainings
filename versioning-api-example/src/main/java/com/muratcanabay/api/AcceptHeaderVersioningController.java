package com.muratcanabay.api;

import com.muratcanabay.model.ApiModelV1;
import com.muratcanabay.model.ApiModelV2;
import com.muratcanabay.model.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AcceptHeaderVersioningController {

    /**
     * Media type versioning used by Github
     * <p>
     * +No URI pollution
     * -No caching because URI doesn't change
     * -Can not execute on the browser
     *
     * @return @return {@link com.muratcanabay.model}
     */
    @GetMapping(value = "/model", produces = "application/vnd.muratcanabay.app-v1+json")
    public ApiModelV1 getModelV1() {
        return ApiModelV1.builder()
                .name("Test")
                .surname("Surname")
                .build();
    }

    @GetMapping(value = "/model", produces = "application/vnd.muratcanabay.app-v2+json")
    public ApiModelV2 getModelV2() {
        return ApiModelV2.builder()
                .name(new Name("Version 2", "Accept Header"))
                .build();
    }
}
