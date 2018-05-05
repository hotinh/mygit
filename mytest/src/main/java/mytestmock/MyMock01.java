package mytestmock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class MyMock01 {
	
	//1、验证行为
	@Test  
	public void verify_behaviour(){  
	    //模拟创建一个List对象  
	    List mock = mock(List.class);  
	    //使用mock的对象  
	    mock.add(1);
	    mock.clear();
	    //验证add(1)和clear()行为是否发生  
	    verify(mock).add(1);  
	    verify(mock).clear();  
	}
}
