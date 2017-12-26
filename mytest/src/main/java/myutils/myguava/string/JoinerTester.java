package myutils.myguava.string;

import java.util.Arrays;
import com.google.common.base.Joiner;

public class JoinerTester {

    public static void main(String[] args) {
        String s = Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6));
        System.out.println(s);
    }

}
