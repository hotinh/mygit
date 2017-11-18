package mytestmock;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.junit.Test;
import org.mockito.exceptions.verification.NoInteractionsWanted;

public class MyMock08 {
	
	//8、找出冗余的互动(即未被验证到的)
	@Test(expected = NoInteractionsWanted.class)  
	public void find_redundant_interaction(){  
	    List list = mock(List.class);  
	    list.add(1);  
	    list.add(2);  
	    verify(list,times(2)).add(anyInt());  
	    //检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以下面的代码会通过  
	    verifyNoMoreInteractions(list);  
	  
	    List list2 = mock(List.class);  
	    list2.add(1);  
	    list2.add(2);  
	    verify(list2).add(1);  
	    //检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常  
	    verifyNoMoreInteractions(list2);  
	} 
}
