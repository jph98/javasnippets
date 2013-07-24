  public class EnvVarLister {
      public static void main( String[] args )
      {
          Set<String> sortedSet = new TreeSet<String>();
          sortedSet.addAll(System.getenv().keySet());
          
          for (String key: sortedSet) {
              System.out.println("Key: [" + key + "] Value: " + System.getenv(key)+ " ");
          }
      }
  }
