package org.example.mvc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XingKe
 * @date 2021-03-06 15:54
 */
@Data
@Getter
@Setter
@ToString
public class User {
    private String userName;
    private String password;
}
