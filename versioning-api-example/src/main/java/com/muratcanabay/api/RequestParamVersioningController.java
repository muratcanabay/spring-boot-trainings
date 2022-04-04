package com.muratcanabay.api;

import com.muratcanabay.model.ApiModelV1;
import com.muratcanabay.model.ApiModelV2;
import com.muratcanabay.model.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RequestParamVersioningController {

    /**
     * Request parameter versioning used by Amazon
     * <p>
     * -URI pollution
     * +Caching
     * +Can execute on the browser
     *
     * @return {@link com.muratcanabay.model}
     */
    @GetMapping(value = "/model", params = "version=1")
    public ApiModelV1 getModelV1() {
        return ApiModelV1.builder()
                .name("Test")
                .surname("Surname")
                .build();
    }

    @GetMapping(value = "/model", params = "version=2")
    public ApiModelV2 getModelV2() {
        return ApiModelV2.builder()
                .name(new Name("Version 2", "Param"))
                .build();
    }
}
