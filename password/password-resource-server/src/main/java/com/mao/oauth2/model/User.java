package com.mao.oauth2.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bigdope
 * @create 2020-03-05
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4564254158645694235L;

    private Long id;

    private String name;

    private String password;
}
