import com.end.EndControllerTest;
import com.end.EndModelTest;
import com.frogger.FroggerControllerTest;
import com.frogger.FroggerModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EndControllerTest.class,
        EndModelTest.class,
        FroggerControllerTest.class,
        FroggerModelTest.class,
})
public class testSuite {
}
