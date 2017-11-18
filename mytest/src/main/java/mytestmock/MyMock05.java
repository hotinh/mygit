package mytestmock;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

public class MyMock05 {
	
	//5、模拟方法体抛出异常
	@Test(expected = RuntimeException.class)  
	public void doThrow_when(){  
	    List list = mock(List.class);  
	    doThrow(new RuntimeException()).when(list).add(1);  
	    list.add(1);  
	}  
}
