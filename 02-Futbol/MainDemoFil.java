
public class MainDemoFil {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        
      
        System.out.println(currentThread.getName() + ".main:");
        System.out.println("Prioritat -> " + currentThread.getPriority());
        System.out.println("Nom -> " + currentThread.getName());
        System.out.println("toString() -> " + currentThread.toString());
    }
}
