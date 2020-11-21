package com.wsj.bilibili.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/209:35 上午
 */
public class LocaleResolverConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(language)){
            String[] s = language.split("_");
            locale = new Locale(s[0], s[1]);
        } else {
            locale = new Locale("zh","CN");
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
