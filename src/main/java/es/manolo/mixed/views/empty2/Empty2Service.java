package es.manolo.mixed.views.empty2;

import javax.validation.constraints.NotNull;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

/**
 * Services for client-side View.
 */
@Endpoint
@AnonymousAllowed
public class Empty2Service {
    
    public static class MyBean {
        @NotNull
        String foo;
    }
    
    public MyBean hello(String s) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        MyBean b = new MyBean();
        b.foo = "hello endpoint (sleeps 5 secs)";
        return b;
    }
}
