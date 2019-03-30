package learn.avinash.spring.util;

import org.springframework.stereotype.Component;

@Component
public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static final UserContext getContext() {
        UserContext context = userContext.get();
        if(context == null){
            context = createEmptyContext();
            userContext.set(context);
        }

        return  userContext.get();
    }

   public static final void setContext(UserContext context){
   //    Assert.checkNonNull(context, "only non-null UserContext instance are permitted ");
       userContext.set(context);
   }

   public static  final UserContext createEmptyContext() {
        return new UserContext();
   }
}
