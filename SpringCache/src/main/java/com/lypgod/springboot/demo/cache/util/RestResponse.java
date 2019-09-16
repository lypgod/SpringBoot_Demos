package com.lypgod.springboot.demo.cache.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lypgod
 */
@Data
@Accessors(chain = true)
public class RestResponse {
    private String respCode;
    private String respMsg;
    private Object data;
}
