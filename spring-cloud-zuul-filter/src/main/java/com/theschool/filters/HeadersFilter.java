package com.theschool.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeadersFilter extends ZuulFilter {

    private final static Logger LOG = LoggerFactory.getLogger(HeadersFilter.class);

    // standard types in Zuul are "pre" for pre-routing filtering,
    // "route" for routing to an origin, "post" for post-routing filters, "error" for error handling
    @Override
    public String filterType() {
        return "pre";
    }

    // the order of the filter
    @Override
    public int filterOrder() {
        return 0;
    }

    // a "true" return from this method means that the run() method should be invoked
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // if shouldFilter() is true, this method will be invoked, this method is the core method of a ZuulFilter
    // some arbitrary artifact may be returned, current implementation ignores it
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        // logging ip from request
        LOG.info("request ip address:" + requestContext.getRequest().getRemoteAddr());
        return null;
    }
}
