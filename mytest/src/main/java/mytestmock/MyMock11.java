package mytestmock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MyMock11 {
	
	@Mock
	private List mockList; 
	
	//11、使用回调生成期望值
	@Test  
	public void answer_with_callback(){  
	    //使用Answer来生成我们我们期望的返回  
	    when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {
	        @Override  
	        public Object answer(InvocationOnMock invocation) throws Throwable {  
	            Object[] args = invocation.getArguments();  
	            return "hello world:"+args[0];  
	        }  
	    });  
	    assertEquals("hello world:0",mockList.get(0));  
	    assertEquals("hello world:999",mockList.get(999));  
	}
}
