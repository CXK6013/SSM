package org.example.ioc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author XingKe
 * @date 2021-02-12 19:30
 */
public class HomeStudentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取当前的环境,一般开发环境分成三套: 开发、测试、生产。
        Environment environment = conditionContext.getEnvironment();
        // 从环境中获取学生类型
        String studentType = environment.getProperty("studentType");
        // 如果是住宿学生就加入到IOC容器中
        if ("HomeStudent".equals(studentType)){
            return true;
        }
        return false;
    }
}
