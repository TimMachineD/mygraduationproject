package du.shop.mail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolSend {
	BlockingQueue<Runnable> workQueue;//任务队列
	ExecutorService executorService;
	
	public PoolSend() {  
        workQueue = new LinkedBlockingQueue<>();//构造无界的任务队列，资源足够，理论可以支持无线个任务  
        executorService = new ThreadPoolExecutor(2, 4, 30,TimeUnit.SECONDS, workQueue,
                new ThreadPoolExecutor.CallerRunsPolicy()); //任务失败重试  
    }  
  
    public void send(Runnable task) {  
        System.out.println("PoolSend start sending mail...");  
        executorService.execute(task);//将任务放入线程池  
    }  
  
    public void close() {// 关闭  
    	executorService.shutdown();  
    }  
}
