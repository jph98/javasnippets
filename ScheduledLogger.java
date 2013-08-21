  
  
  import java.util.concurrent.Executors;
  import java.util.concurrent.ScheduledExecutorService;
  import java.util.concurrent.TimeUnit;
  
  @Component
  public class ScheduledLogger {
  
      private static final Logger logger = Logger.getLogger(RSessionLogger.class);
  
      private final ScheduledExecutorService service;
  
      public RSessionLogger() {
  
          final GenericKeyedObjectPool<Object, RSession> pool = getPool();
  
          service = Executors.newSingleThreadScheduledExecutor();
          final Runnable logSessionsTask = new Runnable() {
  
              @Override
              public void run() {
  
                  try {
                      
                      logger.info("Pool [" + + pool.getNumIdle() + "]" + " active [" + pool.getNumActive() + "]");
                      
                  } catch (RuntimeException e) {
                      logger.error("Exception occured when display number of rsessions");
                  }
              }
          };
  
          service.scheduleAtFixedRate(logSessionsTask, 1, 10, TimeUnit.SECONDS);
      }
  
      private GenericKeyedObjectPool<Object, RSession> getPool() {
  
          return (GenericKeyedObjectPool<Object, RSession>) ApplicationConfigContext.getInstance().getBean("executablePool");
      }
  
  }
