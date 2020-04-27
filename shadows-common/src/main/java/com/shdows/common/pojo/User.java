package com.shdows.common.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhuhongwu
 * @date 2020/4/27
 */
@Data
@Accessors(chain = true)
@ToString
public class User {

    private Integer id;

    private String username;
}

