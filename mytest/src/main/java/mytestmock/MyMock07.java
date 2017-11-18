package mytestmock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.List;

import org.junit.Test;

public class MyMock07 {
	
	//7、确保模拟对象上无互动发生
	@Test  
	public void verify_interaction(){  
	    List list = mock(List.class);  
	    List list2 = mock(List.class);  
	    List list3 = mock(List.class);  
	    list.add(1);  
	    verify(list).add(1);  
	    verify(list,never()).add(2);  
	    //验证零互动行为  
	    verifyZeroInteractions(list2,list3);  
	}  
}
