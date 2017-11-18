package mytestmock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class MyMock12 {
	
	//12、监控真实对象
	//使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
	@Test(expected = IndexOutOfBoundsException.class)  
	public void spy_on_real_objects(){  
	    List list = new LinkedList();  
	    List spy = spy(list);  
	    //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常  
	    //when(spy.get(0)).thenReturn(3);  
	  
	    //使用doReturn-when可以避免when-thenReturn调用真实对象api  
	    doReturn(999).when(spy).get(999);  
	    //预设size()期望值  
	    when(spy.size()).thenReturn(100);  
	    //调用真实对象的api  
	    spy.add(1);  
	    spy.add(2);  
	    assertEquals(100,spy.size());  
	    assertEquals(1,spy.get(0));  
	    assertEquals(2,spy.get(1));  
	    verify(spy).add(1);  
	    verify(spy).add(2);  
	    assertEquals(999,spy.get(999));  
	    spy.get(2);  
	}
}
