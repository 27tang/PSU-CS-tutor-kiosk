package resource;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * Created by x on 7/30/15.
 */
public class CORSResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
        cres.getHeaders().add("Access-Control-Allow-Origin", "");
        cres.getHeaders().add("Access-Control-Allow-Headers", "");
        cres.getHeaders().add("Access-Control-Allow-Credentials", "");
        cres.getHeaders().add("Access-Control-Allow-Methods", "");
        cres.getHeaders().add("Access-Control-Max-Age", "");
    }
}
