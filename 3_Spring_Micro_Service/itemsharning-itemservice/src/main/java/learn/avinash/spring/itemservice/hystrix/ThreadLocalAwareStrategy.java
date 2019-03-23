package learn.avinash.spring.itemservice.hystrix;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import learn.avinash.spring.itemservice.util.UserContextHolder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalAwareStrategy extends HystrixConcurrencyStrategy {
    private HystrixConcurrencyStrategy exisitingHystrixConcurrencyStrategy;

    public ThreadLocalAwareStrategy(HystrixConcurrencyStrategy exisitingHystrixConcurrencyStrategy){
        this.exisitingHystrixConcurrencyStrategy = exisitingHystrixConcurrencyStrategy;

    }

    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
        return exisitingHystrixConcurrencyStrategy !=null ?
                exisitingHystrixConcurrencyStrategy.getBlockingQueue(maxQueueSize)
                :super.getBlockingQueue(maxQueueSize);

    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv){
       return exisitingHystrixConcurrencyStrategy !=null ?
               exisitingHystrixConcurrencyStrategy.getRequestVariable(rv)
               :super.getRequestVariable(rv);

   }

    @Override
 public  ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
                                    HystrixProperty<Integer> corePoolSize,
                                    HystrixProperty<Integer> maximumPoolSize,
                                    HystrixProperty<Integer> keepAlive,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> work
                                    ){
     return  exisitingHystrixConcurrencyStrategy !=null ?
             exisitingHystrixConcurrencyStrategy.getThreadPool(threadPoolKey,
                     corePoolSize,
                     maximumPoolSize,
                     keepAlive,
                     unit,
                     work )
             :super.getThreadPool(threadPoolKey,
               corePoolSize,
               maximumPoolSize,
               keepAlive,
               unit,
               work );
   }

    @Override
   public <T> Callable<T> wrapCallable(Callable<T> callable){
       return  exisitingHystrixConcurrencyStrategy !=null ?
               exisitingHystrixConcurrencyStrategy.wrapCallable(new DelegatingUserContextCallable<T>(callable , UserContextHolder.getContext()))
               :super.wrapCallable(new DelegatingUserContextCallable<T>(callable , UserContextHolder.getContext()));
   }
}
