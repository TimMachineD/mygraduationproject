package du.shop.mail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolSend {
	BlockingQueue<Runnable> workQueue;//�������
	ExecutorService executorService;
	
	public PoolSend() {  
        workQueue = new LinkedBlockingQueue<>();//�����޽��������У���Դ�㹻�����ۿ���֧�����߸�����  
        executorService = new ThreadPoolExecutor(2, 4, 30,TimeUnit.SECONDS, workQueue,
                new ThreadPoolExecutor.CallerRunsPolicy()); //����ʧ������  
    }  
  
    public void send(Runnable task) {  
        System.out.println("PoolSend start sending mail...");  
        executorService.execute(task);//����������̳߳�  
    }  
  
    public void close() {// �ر�  
    	executorService.shutdown();  
    }  
}
