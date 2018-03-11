import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FailingTest  {

    @Test
    public void shouldEventuallyPass() {

        assertThat(true, is(true));
    }

}
