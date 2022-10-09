package com.qh.ruyitakeaway.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qh.ruyitakeaway.interceptor.LoginSettingInterceptor;
import com.qh.ruyitakeaway.interceptor.UserLoginCheckInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * web mvc配置
 *
 * @author qh
 * @date 2022/10/09 12:44:38
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Autowired
    LoginSettingInterceptor loginSettingInterceptor;

    @Autowired
    UserLoginCheckInterceptor loginCheckInterceptor;

    /*@Bean
    public SMSUtils smsUtils(@Value("${sendMessage.accessKeyId}") String accessKeyId, @Value("${sendMessage.accessKeySecret}") String accessKeySecret) throws Exception {
        return new SMSUtils(accessKeyId, accessKeySecret);
    }*/

    /**
     * 配置资源管理器
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源映射
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
        // swagger 需要开放的
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");

    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 静态资源和 login登录接口
        String[] urls = new String[]{"/doc.html","/backend/**", "/front/**", "/employee/login", "/error"};
        String[] swaggerUrl = new String[]{
                "/csrf", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"};
        // 过滤白名单
        String[] whiteList = new String[]{"/user/sendMsg", "/user/login"};
        registry.addInterceptor(loginSettingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(urls)
                .excludePathPatterns(swaggerUrl)
                .excludePathPatterns(whiteList);

        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(urls)
                .excludePathPatterns(swaggerUrl)
                .excludePathPatterns(whiteList)
                .excludePathPatterns("/category/**", "/common/**",
                        "/dish/**", "/employee/**", "/setmeal/**", "/order/**", "/orderAdministration/**");

    }


    /**
     * 扩展 mvc 框架的消息转换器
     *
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建消息转换器
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        // 设置对象转换器
        jackson2HttpMessageConverter.setObjectMapper(new JacksonObjectMapper());
        // 添加的mvc中的转换器中去
        converters.add(0, jackson2HttpMessageConverter);
    }

    /**
     * 参数转换器
     *
     * @param registry
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isNotEmpty(source)) {
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
    }

 /*   @Bean
    public Docket createRestApi() {
        // 文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qh.ruyitakeaway.controller"))
                .paths(PathSelectors.any())
                .build();
    }
*/
   /* private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("如意外卖")
                .version("1.0")
                .description("如意外卖接口文档")
                .build();
    }*/
}
