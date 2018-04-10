package com.yvan.practice.facade;

import com.yvan.practice.request.CreateProductRequest;
import com.yvan.practice.response.CreateProductResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author yvan
 */
@Api(value = "/testfacade")
@RestController
@RequestMapping("/testfacade")
public interface TestFacade {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "createProduct", response = CreateProductResponse.class)
    CreateProductResponse createProduct(@Valid @NotNull @ApiParam(value = "CreateProductRequest", required = true) CreateProductRequest request);
}
