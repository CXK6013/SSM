package org.example.ioc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author XingKe
 * @date 2021-02-15 11:14
 */
public class BoardStudentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String studentType = environment.getProperty("studentType");
        if ("BoardStudent".equals(studentType)){
            return true;
        }
        return false;
    }
}
