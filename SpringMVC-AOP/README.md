## AOP demo

> 切面相关代码详见 com.demo.aspect.AOPAspect

execution and @Before： 
    
        http://localhost:8080/hello/hello || http://localhost:8080/hello/java

within and @After、@AfterThrowing、@AfterReturning： 

        http://localhost:8080/hey/lady ||  http://localhost:8080/beauty/beast?boo=false
        
this ：  
    
        http://localhost:8080/this/cheese
        
target ：

        http://localhost:8080/this/cheese
        
args ： 

        http://localhost:8080/this/sheep?sheep=sheep
        http://localhost:8080/this/cat?sheep=sheep&cat=pussycat&num=1
        
bean ：

        http://localhost:8080/bean/Mr
        http://localhost:8080/bean/jack
        
@target：


@within && JointPoint

         http://localhost:8080/hello/world?prarm1=aString&param2=2222&param3=secString
         
@args

        
        
@annotation

        http://localhost:8080/hello/java