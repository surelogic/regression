package testSpeso.experts;

import java.util.*;
import java.util.concurrent.*;

import testSpeso.ps.ExpertAttributes;

public interface ExpertCreator<K extends ExpertAttributes> extends Runnable,
Callable<List<GlobalExpertEntity<K>>> {

}
