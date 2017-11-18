package mytestmock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.junit.Test;

public class MyMock02 {
	
	//2、模拟我们所期望的结果
	@Test
	public void when_thenReturn(){  
	    //mock一个Iterator类  
	    Iterator iterator = mock(Iterator.class);  
	    //预设当iterator调用next()时第一次返回hello，第n次都返回world  
	    when(iterator.next()).thenReturn("hello").thenReturn("world");  
	    //使用mock的对象  
	    String result = iterator.next() + " " + iterator.next() + " " + iterator.next();  
	    //验证结果  
	    assertEquals("hello world world",result);  
	}
	
	@Test(expected = IOException.class)  
	public void when_thenThrow() throws IOException {  
	    OutputStream outputStream = mock(OutputStream.class);  
	    OutputStreamWriter writer = new OutputStreamWriter(outputStream);  
	    //预设当流关闭时抛出异常  
	    doThrow(new IOException()).when(outputStream).close();  
	    outputStream.close();  
	} 
	
}
