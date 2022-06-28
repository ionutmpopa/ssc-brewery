package guru.sfg.brewery.security.obsolete;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Deprecated
@Slf4j
public class RestUrlParamAuthFilter extends AbstractCustomAuthFilter {


    public RestUrlParamAuthFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    protected String getPassword(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("Api-Secret");
    }

    @Override
    protected String getUserName(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("Api-Key");
    }
}
