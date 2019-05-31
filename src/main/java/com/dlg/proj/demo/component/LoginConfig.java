package com.dlg.proj.demo.component;

import com.dlg.proj.demo.interceptor.LoginTerceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Component

public class LoginConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginTerceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);    }
}
