package mytestmock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class MyMock10 {
	
	@Mock
	private List mockList; 
	
	//更多的注解还有@Captor,@Spy,@InjectMocks
	//10、连续调用
	@Test(expected = RuntimeException.class)  
	public void consecutive_calls(){  
	    //模拟连续调用返回期望值，如果分开，则只有最后一个有效  
	    when(mockList.get(0)).thenReturn(0);  
	    when(mockList.get(0)).thenReturn(1);  
	    when(mockList.get(0)).thenReturn(2);  
	    when(mockList.get(1)).thenReturn(0).thenReturn(1).thenThrow(new RuntimeException());  
	    assertEquals(2,mockList.get(0));  
	    assertEquals(2,mockList.get(0));  
	    assertEquals(0,mockList.get(1));  
	    assertEquals(1,mockList.get(1));  
	    //第三次或更多调用都会抛出异常  
	    mockList.get(1);  
	} 
}
