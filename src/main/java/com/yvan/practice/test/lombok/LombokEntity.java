package com.yvan.practice.test.lombok;

import com.yvan.practice.controller.request.BaseObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Accessors(chain = true) 链式风格
 */
@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "ofName")
public class LombokEntity extends BaseObject {

    private Integer id;

    private String name;
}
