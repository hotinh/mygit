package mytestmock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class MyMock15 {
	
	//15.真实的部分mock
	@Test  
	public void real_partial_mock(){  
	    //通过spy来调用真实的api  
	    List list = spy(new ArrayList());  
	    assertEquals(0,list.size());  
	    A a  = mock(A.class);  
	    //通过thenCallRealMethod来调用真实的api  
	    when(a.doSomething(anyInt())).thenCallRealMethod();  
	    assertEquals(999,a.doSomething(999));  
	}  
	  
	  
	class A{  
	    public int doSomething(int i){  
	        return i;  
	    }  
	} 
}
