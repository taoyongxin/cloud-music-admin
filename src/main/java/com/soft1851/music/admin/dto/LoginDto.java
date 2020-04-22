package com.soft1851.music.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName LoginDto
 * @Description TODO
 * @date 2020-04-21 14:14
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String name;
    private String password;
    private String verifyCode;
}
