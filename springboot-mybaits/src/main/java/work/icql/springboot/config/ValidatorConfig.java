package work.icql.springboot.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/22 13:36
 * @Title ValidatorConfig
 * @Description ValidatorConfig
 */
@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                //开启快速失败返回模式，验证失败即刻抛出异常
                //默认普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}
