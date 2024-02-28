package com.test.springboot.config.auth;

import com.test.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    //조건에 맞는 경우 메소드가 있다면 HandlerMethodargumentResovler의 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길수있다

    private final HttpSession httpSession;
    @Override//컨트롤러 메서드의 특정 파라미터를 지원하는지 판단한다.
    public boolean supportsParameter(MethodParameter parameter) {
        //@LoginUser파라미터를 가져오면  true?
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;

        //파라미터가 SessionUser타입이면 true;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    @Override //파라미터에 전달할 객체를 생성한다. 여기서는 세션 객체를 가져온다.
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        return httpSession.getAttribute("user");
    }

}
