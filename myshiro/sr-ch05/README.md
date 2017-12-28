#编码加密
>Shiro提供了base64和16进制字符串编码/解码的API支持，方便一些编码解码操作。Shiro内部的一些数据的存储/表示都使用了base64和16进制字符串。

#散列算法
>散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，可以到一些md5解密网站很容易的通过散列值得到密码“admin”，即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。

#加密/解密
>Shiro还提供对称式加密/解密算法的支持，如AES、Blowfish等；当前还没有提供对非对称加密/解密算法支持，未来版本可能提供。

#PasswordService/CredentialsMatcher
>Shiro提供了PasswordService及CredentialsMatcher用于提供加密密码及验证密码服务。

>Shiro默认提供了PasswordService实现DefaultPasswordService；CredentialsMatcher实现PasswordMatcher及HashedCredentialsMatcher（更强大）。

````
//DefaultPasswordService配合PasswordMatcher实现简单的密码加密与验证服务
public class MyRealm extends AuthorizingRealm {  
    private PasswordService passwordService;  
    public void setPasswordService(PasswordService passwordService) {  
        this.passwordService = passwordService;  
    }  
     //省略doGetAuthorizationInfo，具体看代码   
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {  
        return new SimpleAuthenticationInfo(  
                "wu",  
                passwordService.encryptPassword("123"),  
                getName());  
    }  
}
````

#HashedCredentialsMatcher实现密码验证服务
>需要注意的就是HashedCredentialsMatcher的算法需要和生成密码时的算法一样。另外HashedCredentialsMatcher会自动根据AuthenticationInfo的类型是否是SaltedAuthenticationInfo来获取credentialsSalt盐。

#密码重试次数限制
>如在1个小时内密码最多重试5次，如果尝试次数超过5次就锁定1小时，1小时后可再次重试，如果还是重试失败，可以锁定如1天，以此类推，防止密码被暴力破解。我们通过继承HashedCredentialsMatcher，且使用Ehcache记录重试次数和超时时间。

```
public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {  
       String username = (String)token.getPrincipal();  
        //retry count + 1  
        Element element = passwordRetryCache.get(username);  
        if(element == null) {  
            element = new Element(username , new AtomicInteger(0));  
            passwordRetryCache.put(element);  
        }  
        AtomicInteger retryCount = (AtomicInteger)element.getObjectValue();  
        if(retryCount.incrementAndGet() > 5) {  
            //if retry count > 5 throw  
            throw new ExcessiveAttemptsException();  
        }  
  
        boolean matches = super.doCredentialsMatch(token, info);  
        if(matches) {  
            //clear retry count  
            passwordRetryCache.remove(username);  
        }  
        return matches;  
}
```

