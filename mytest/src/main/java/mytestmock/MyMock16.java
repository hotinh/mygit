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

public class MyMock16 {
	
	//s16、重置mock
	@Test  
	public void reset_mock(){  
	    List list = mock(List.class);  
	    when(list.size()).thenReturn(10);  
	    list.add(1);  
	    assertEquals(10,list.size());  
	    //重置mock，清除所有的互动和预设  
	    reset(list);  
	    assertEquals(0,list.size());  
	} 
}
