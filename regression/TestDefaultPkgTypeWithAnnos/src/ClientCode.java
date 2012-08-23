import com.surelogic.RegionEffects;

public class ClientCode {

    @RegionEffects("reads CounterUtility:CounterState")
    public static void main(String[] args) {
        long counter = CounterUtility.incrementAndGet();
    }

}