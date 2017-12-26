#Realm及相关对象
>即用户-角色之间是多对多关系，角色-权限之间是多对多关系；

>且用户和权限之间通过角色建立关系；

>在系统中验证时通过权限验证，角色只是权限集合，即所谓的显示角色；

>其实权限应该对应到资源（如菜单、URL、页面按钮、Java方法等）中，即应该将权限字符串存储到资源实体中，但是目前为了简单化，直接提取一个权限表，

#AuthenticationToken
```
public interface AuthenticationToken extends Serializable {  
    Object getPrincipal(); //身份  
    Object getCredentials(); //凭据  
}
```

#AuthenticationInfo

#PrincipalCollection

#AuthorizationInfo


对于Subject我们一般这么使用：
1. 身份验证（login）
2. 授权（hasRole*/isPermitted*或checkRole*/checkPermission*）
3. 将相应的数据存储到会话（Session）
4. 切换身份（RunAs）/多线程身份传播
5. 退出