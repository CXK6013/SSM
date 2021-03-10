package org.example.ioc;

import org.example.aop.Landlord;
import org.example.aop.LogBefore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;


/**
 * @author XingKe
 * @date 2021-02-14 12:03
 */
@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
//@Import(value = MyImportBeanDefinitionRegistrar.class)
//@ComponentScan(basePackages = "org.example", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyFilter.class})},useDefaultFilters = false)
//@ComponentScan(basePackages = "org.example",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})},useDefaultFilters = false)
public class SpringConfig {

    @Bean(name = "studentCard")
    @Lazy
    public StudentCard studentCard() {
        return new StudentCard(11, "22");
    }

    @Bean
    @Conditional(HomeStudentCondition.class)
    @Profile("homeStudent")
    public HomeStudent homeStudent() {
        return new HomeStudent("出入证");
    }

    @Bean
    @Conditional(BoardStudentCondition.class)
    public BoardStudent boardStudent() {
        return new BoardStudent("宿舍200");
    }


    @Bean
    @Lazy
    public Student student(@Qualifier("studentCard") StudentCard studentCard) {
        return new Student(20, "zs", studentCard);
    }

    @Bean
    public LogBefore logBefore(){
        return new LogBefore ();
    }


    @Bean
    @Lazy
    public StudentCard studentCard2() {
        return new StudentCard(11, "22");
    }

    @Bean
    public Landlord landlord(){
        return new Landlord();
    }
}
