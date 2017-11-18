package mytestmock;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class MyMock09 {
	
	//9、使用注解来快速模拟
	//在上面的测试中我们在每个测试方法里都mock了一个List对象，为了避免重复的mock，是测试类更具有可读性，我们可以使用下面的注解方式来快速模拟对象：
	
	@Mock
	private List mockList; 
	
	@Test  
	public void shorthand(){  
	    mockList.add(1);  
	    verify(mockList).add(1);  
	}
}

/*public class MockitoExample2 {  
    @Mock  
    private List mockList;  
  
    public MockitoExample2(){  
        MockitoAnnotations.initMocks(this);  
    }  
  
    @Test  
    public void shorthand(){  
        mockList.add(1);  
        verify(mockList).add(1);  
    }  
}*/
 
/* @RunWith(MockitoJUnitRunner.class)  
 public class MockitoExample3 {  
     @Mock  
     private List mockList;  
   
     @Test  
     public void shorthand(){  
         mockList.add(1);  
         verify(mockList).add(1);  
     }  
 }*/ 
