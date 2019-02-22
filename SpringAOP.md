# SpringAOP

## 1.AOP简介：

1.AOP（面向切面编程，Aspect-Oriented-Programming），可以说是OOP（面向对象编程，Object-Oriented-Programing）的完善和补充 .  POP 面向过程编程 。

2.AOP 的主要编程对象是切面(aspect), 而切面模块化横切关注点. 

3.在应用 AOP 编程时, 仍然需要定义公共功能, 但可以明确的定义这个功能在哪里, 以什么方式应用, 并且不必修改受影响的类. 这样一 来横切关注点就被模块化到特殊的对象(切面)里. 

## 2.为什么使用AOP:

1.代码混乱：越来越多的非业务需求(日志和验证等)加入后, 原有的业务方法急剧膨胀.  每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点. 

2.代码分散: 以日志需求为例, 只是为了满足这个单一需求, 就不得不在多个模块（方法）里多次重复相同的日志代码. 如果日志需求发生变化, 必须修改所有模块.

## 3.AOP关键术语：

``切面(Aspect)``:  由横切关注点构成的特殊对象。
``通知(Advice)``:  切面必须要完成的工作。
``目标(Target)``:  被通知的对象。
``代理(Proxy)``:   向目标对象应用通知之后创建的对象。
``连接点（Joinpoint）``: 程序执行的某个特定位置。某个方法调用前、调用后、方法抛出异常后等。

``切点（pointcut）``：每个类都拥有多个连接点。 ClientServiceImpl中所有的方法都是切点。AOP通过切点定位到特定的连接点。类比：连接点相当于数据库中的记录，切点相当于查询条件。切点和连接点不是一对一的关系，一个切点匹配多个连接点，切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件。 简单来说：Advice定义了切面要发生“故事”和时间，那么切入点就定义了“故事”发生的地点。例如某个类或者方法名，Spring中允许我们使用正则来指定 

``织入（Weaving）``：将增强添加到目标类具体连接点上的过程。AOP有三种织入的方式：编译期织入、类装载期织入、动态代理织入（spring采用动态代理织入） 

## 4.AOP图解：

![QQ图片20180612234943](C:\QQ图片20180612234943.png)

## 5.SpringAOP实现步骤：

•AspectJ：Java 社区里最完整最流行的 AOP 框架.

•在 Spring2.0 以上版本中, 可以使用基于 AspectJ 注解或基于 XML 配置的 AOP

### 使用步骤：

1.aopalliance.jar、aspectj.weaver.jar 和 spring-aspects.jar 

2.spring配置文件中添加：xmlns:aop="http://www.springframework.org/schema/aop"

3.要在 Spring IOC 容器中启用 AspectJ 注解支持, 只要在 Bean 配置文件中定义一个空的 XML 元素 <aop:aspectj-autoproxy> 。使AspectJ相关注解生效：当调用目标方法，跟Aspect中声明的方法相匹配的时候，AOP框架会自动的为目标方法所在的类创建代理对象

### 1.基于注解的方式实现springAOP:

1.创建切面类(LoggingAspect)。

``@Aspect``:声明当前类为切面类。

``@Component``:交给springIOC容器进行管理。

``@Before``:前置通知。

​	需要使用切点表达式：``@Befort("execution(* com.client.service.impl.*.*(..))")``,指定需要在哪个方法执行之前执行该方法(通知)。其中第一个``*``表示匹配所有访问权限修饰符以及返回值类型，第二个``*``表示匹配当前包下所有的类，第三个``*``表示匹配所有的方法,``..``则表示匹配当前方法中所有的参数。其中``(Joinpoint)``对象中封装了目标方法的一些信息，例如获取目标方法名称，获取目标方法参数等。

``@Order(number)``:可以配置切面的优先级。

``@After``:后置通知。使用方法与前置通知相同。注意：后置通知即使方法异常也会成功执行，但是后置通知无法拿到目标方法的返回结果。需要返回通知。

``@AfterReturnning``:返回通知，在方法正常之后之后执行的通知,可以拿到目标方法的返回结果。使用返回通知需要注意的是：指定returnning="result",``afterReturnningAdvice(JoinPoint joinpoint,Object result)``与方法入参位置的对象名称一致，否则会产生异常。

``@AfterThrowing``:异常通知，方法产生异常的时候，可以拿到异常信息。同样需要注意的是：指定throwing="e",与``afterThrowingAdvice(JoinPoint joinpoint,Exception e)``方法入参位置的异常对象名称一致。

``@Around``:环绕通知，如下所示，是不是更像动态代理了呢？

![1528826691104](C:\Users\Administrator\AppData\Local\Temp\1528826691104.png)



### 2.基于XML文件的方式实现springAOP:

正常情况下, 基于注解的声明要优先于基于 XML 的声明. 通过 AspectJ 注解, 切面可以与 AspectJ 兼容, 而基于 XML 的配置则是 Spring 专有的. 由于 AspectJ 得到越来越多的 AOP 框架支持, 所以以注解风格编写的切面将会有更多重用的机会. "

```xml
	<!-- 配置切面的bean. -->
	<bean id="checkAspect" class="com.client.aspect.CheckAspect"></bean>
	<bean id="loggingAspect" class="com.client.aspect.LoggingAspect"></bean>
	<!-- 配置AOP -->
	<aop:config>
		<!-- 配置切点表达式。 -->
		<aop:pointcut expression="execution(* com.client.service.impl.*.*(..))" 
			id="pointcut"/>
		<!-- 配置切面以及通知。 -->
		<aop:aspect ref="checkAspect" order="1">
			<aop:before method="checkBeforeAdvice" pointcut-ref="pointcut"/>
		</aop:aspect>
		<aop:aspect ref="loggingAspect" order="2">
			<!-- <aop:before method="beforeLog" pointcut-ref="pointcut"/>
			<aop:after method="afterLog" pointcut-ref="pointcut"/>
			<aop:after-returning method="afterReturnningAdvice" pointcut-ref="pointcut" returning="result"/>
			<aop:after-throwing method="afterThrowingAdvice" pointcut-ref="pointcut" throwing="e"/> -->
			 <aop:around method="aroundMethod" pointcut-ref="pointcut"/> 
		</aop:aspect>
	</aop:config>
```



## 6.SpringAOP实现原理:

1.JDK动态代理(JDK提供，只能代理接口)。

​	使用动态代理可以为一个或多个接口在运行期动态生成实现对象，生成的对象中实现接口的方法时可以添加增强代码，从而实现AOP。缺点是只能针对接口进行代理，另外由于动态代理是通过反射实现的，有时可能要考虑反射调用的开销。

2.CGlib动态代理: (适用CGlib工具)。

​	采用动态的字节码生成技术，运行时动态生成指定类的一个子类对象，并覆盖其中特定方法，覆盖方法时可以添加增强代码，从而实现AOP 。

重载:

## 7.AOP的好处：

> 1.每个事物逻辑位于一个位置, 代码不分散, 便于维护和升级
>
> 2.业务模块更简洁, 只包含核心业务代码.

## 8.AOP在实际项目中的主要应用：

日志(金融  资金管理 。  流程痕迹 。记录 用户 在那个事件 那个地点 ,做了那些操作 。)、事务、权限等方面 。

​	







