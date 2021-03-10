package org.example.mvc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XingKe
 * @date 2021-03-08 10:40
 */
@Data
@Getter
@Setter
@ToString
public class Blog {
    private Long id;
    private String name;
    private String status;
    private String title;
    private Boolean sex;
}
