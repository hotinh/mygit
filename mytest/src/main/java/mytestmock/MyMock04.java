package mytestmock;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;

public class MyMock04 {
	
	//4、验证确切的调用次数
	@Test  
	public void verifying_number_of_invocations(){  
	    List list = mock(List.class);  
	    list.add(1);  
	    list.add(2);  
	    list.add(2);  
	    list.add(3);  
	    list.add(3);  
	    list.add(3);  
	    //验证是否被调用一次，等效于下面的times(1)  
	    verify(list).add(1);  
	    verify(list,times(1)).add(1);  
	    //验证是否被调用2次  
	    verify(list,times(2)).add(2);  
	    //验证是否被调用3次  
	    verify(list,times(3)).add(3);  
	    //验证是否从未被调用过  
	    verify(list,never()).add(4);  
	    //验证至少调用一次  
	    verify(list,atLeastOnce()).add(1);  
	    //验证至少调用2次  
	    verify(list,atLeast(2)).add(2);  
	    //验证至多调用3次  
	    verify(list,atMost(3)).add(3);  
	} 
}
