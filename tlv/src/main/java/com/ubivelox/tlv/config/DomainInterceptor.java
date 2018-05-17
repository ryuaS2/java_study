package com.ubivelox.tlv.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception
    {

        if ( log.isDebugEnabled() )
        {
            log.debug("===> [DomainInterceptor] preHandle");
            log.debug("===> [request.getRequestURL()] " + request.getRequestURL()); // TODO URL Tampering 경고 - 로그 레벨 조정 필요

            Enumeration<String> enums = request.getParameterNames(); // TODO Parameter Tampering 경고 - 로그 레벨 조정 필요
            while ( enums.hasMoreElements() )
            {
                String paramName = enums.nextElement();
                log.debug("===> [param] " + paramName + ", [value] " + request.getParameter(paramName)); // TODO Parameter Tampering 경고 - 로그 레벨 조정 필요
            }
        }
        return true;
    }
}
