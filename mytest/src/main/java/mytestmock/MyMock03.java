package mytestmock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class MyMock03 {
	
	//3、参数匹配
	@Test  
	public void with_arguments(){  
	    Comparable comparable = mock(Comparable.class);  
	    //预设根据不同的参数返回不同的结果  
	    when(comparable.compareTo("Test")).thenReturn(1);  
	    when(comparable.compareTo("Omg")).thenReturn(2);  
	    assertEquals(1, comparable.compareTo("Test"));  
	    assertEquals(2, comparable.compareTo("Omg"));  
	    //对于没有预设的情况会返回默认值  
	    assertEquals(0, comparable.compareTo("Not stub"));  
	}
	
	//除了匹配制定参数外，还可以匹配自己想要的任意参数
	@Test  
	public void with_unspecified_arguments(){
	    List list = mock(List.class);  
	    //匹配任意参数  
	    when(list.get(anyInt())).thenReturn(1);  
	    when(list.contains(argThat(new IsValid()))).thenReturn(true);  
	    assertEquals(1, list.get(1));  
	    assertEquals(1, list.get(999));  
	    assertTrue(list.contains(1));  
	    assertTrue(!list.contains(3));  
	}  
	  
	private class IsValid extends ArgumentMatcher<List>{  
	    @Override  
	    public boolean matches(Object o) {  
	        return o.equals(1)|| o.equals(2);  
	    }  
	}
	
	//需要注意的是如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
	@Test  
	public void all_arguments_provided_by_matchers(){  
	    Comparator comparator = mock(Comparator.class);  
	    comparator.compare("nihao","hello");  
	    //如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配  
	    verify(comparator).compare(anyString(),eq("hello"));  
	    //下面的为无效的参数匹配使用  
	    //verify(comparator).compare(anyString(),"hello");  
	}  
	
	
}
