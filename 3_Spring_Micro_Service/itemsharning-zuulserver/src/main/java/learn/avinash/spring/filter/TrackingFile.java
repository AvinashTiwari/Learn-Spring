package learn.avinash.spring.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackingFile extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private static final Logger logger = LoggerFactory.getLogger(TrackingFile.class);

    @Autowired
    private FilterUtils filterUtils;


    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        if(isCorrelationIdPresent()){
            logger.debug("is-correlation-id found in tracking filter : {} ", filterUtils.getCorrelationId());
        }
        else {
            filterUtils.setCorrelationId(genrateCorrelationId());
            logger.debug("is-correlation-id genrated  in tracking filter : {} ", filterUtils.getCorrelationId());
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        logger.debug("Processing incoming request for {} ", ctx.getRequest().getRequestURI());

        return null;
    }

    private boolean isCorrelationIdPresent(){
        if(filterUtils.getCorrelationId() !=null){
            return true;
        }else
        {
            return  false;
        }
    }

    public String genrateCorrelationId(){
        return java.util.UUID.randomUUID().toString();
    }
}
