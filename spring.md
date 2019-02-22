# Spring笔记

## 1.安装spring 插件

SPRING TOOL SUITE 是一个 Eclipse 插件，利用该插件可以更方便的在 Eclipse 平台上开发基于 Spring 的应用。

安装方法说明（springsource-tool-suite-3.4.0.RELEASE-e4.3.1-updatesite.zip）：

–Help --> Install New Software...

–Click Add... 

–In dialog Add Site dialog, click Archive... 

–Navigate to springsource-tool-suite-3.4.0.RELEASE-e4.3.1-updatesite.zip  and click  Open 

–Clicking OK in the Add Site dialog will bring you back to the dialog 'Install' 

–Select the xxx/Spring IDE that has appeared 

–Click Next  and then Finish 

–Approve the license 

–Restart eclipse when that is asked

> 关于错误处理: 
>
> 关于最新版本安装错误问题: 
>
> http://spring.io/tools3/sts/all/ 进入spring官网下载。
>
> Spring 各版本jar包源码下载地址：
>
> https://repo.spring.io/webapp/#/artifacts/browse/tree/General/libs-release-local/org/springframework



官方版本:

GA:General Availability,正式发布的版本，官方推荐使用此版本。在国外都是用GA来说明release（发布）版本的。

PRE: 预览版,内部测试版. 主要是给开发人员和测试人员测试和找BUG用的，不建议使用；

SNAPSHOT: 快照版，可以稳定使用，且仍在继续改进版本;



## 2.spring 概述

spring是什么:

Spring 是一个开源框架.

Spring 为简化企业级应用开发而生. 使用 Spring 可以使简单的 JavaBean 实现以前只有 EJB 才能实现的功能.

Spring 是一个 IOC(DI) 和 AOP 容器框架.



具体描述 Spring:

–轻量级：Spring 是非侵入性的 - 基于 Spring 开发的应用中的对象可以不依赖于 Spring 的 API

–依赖注入(DI --- dependency injection、IOC)

–面向切面编程(AOP --- aspect oriented programming)

–容器: Spring 是一个容器, 因为它包含并且管理应用对象的生命周期

–框架: Spring 实现了使用简单的组件配置组合成一个复杂的应用. 在 Spring 中可以使用 XML 和 Java 注解组合这些对象

–一站式：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库 （实际上 Spring 自身也提供了展现层的 SpringMVC 和 持久层的 Spring JDBC）

![Y89N_J)S55R0`72GeMHHO61S](K:\资料包\spring相关\sp.png)



## 3.控制反转&依赖注入

IOC(Inversion of Control) 控制反转,反转资源获取的方向 

传统的资源查找方式要求组件向容器发起请求查找资源. 作为回应, 容器适时的返回资源. 而应用了 IOC 之后, 则是**容器主动地将资源推送给它所管理的组件, 组件所要做的仅是选择一种合适的方式来接受资源.**

DI(Dependency Injection) — IOC 的另一种表述方式 

**组件以一些预先定义好的方式(例如: setter 方法)接受来自如容器的资源注入.** 



## 4.Spring IOC容器

Spring IOC 容器读取 Bean 配置创建 Bean 实例之前, 必须对它进行实例化. 只有在容器实例化后, 才可以从 IOC 容器里获取 Bean 实例并使用. 

Spring 提供了两种类型的 IOC 容器实现. 

BeanFactory: IOC 容器的基本实现.

**ApplicationContext: 提供了更多的高级特性. 是 BeanFactory 的子接口.**

BeanFactory 是 Spring 框架的基础设施，面向 Spring 本身；ApplicationContext 面向使用 Spring 框架的开发者，几乎所有的应用场合都直接使用 ApplicationContext 而非底层的 BeanFactory .无论使用何种方式, 配置文件时相同的. 

ApplicationContext 的主要实现类：

**ClassPathXmlApplicationContext：从 类路径下加载配置文件**

FileSystemXmlApplicationContext: 从文件系统中加载配置文件

ConfigurableApplicationContext 扩展于 ApplicationContext，新增加两个主要方法：refresh() 和 close()， 让 ApplicationContext 具有启动、刷新和关闭上下文的能力

**ApplicationContext 在初始化上下文时就实例化所有单例的 Bean**

WebApplicationContext 是专门为 WEB 应用而准备的，它允许从相对于 WEB 根目录的路径中完成初始化工作 



```java
//创建spring ioc 容器对象
ApplicationContext ac = new ClassPathXMLApplicationContext("配置文件的位置");
//如果配置文件在某一个包中 则需要带上包路径。   com/igeek/demo1/beans.xml
```



## 5.依赖注入的三种方式

> 1. 属性注入 (最常用的方式)
>
>    1.1 属性注入通过 setter 方法注入Bean 的属性值或依赖的对象 
>
>    	1.2 属性注入使用<property>元素, 使用 name 属性指定 Bean 的属性名称，value 属性或 <value> 子节				      点指定属性值 
>
> ```xml
> <bean id="hs1" class="com.igeek.demo1.HelloSpring">
>     <!-- 	
> 		注意:name属性的值  为当前类中setter方法的名称。  
>  		setName2(String name) 假如方法叫setName2 那么name="name2" 也应该填写name2
> 	-->
>     <property name="name" value="你好..."></property>
> </bean>
> ```
>
> 2. 构造器注入
>
>    2.1 通过构造方法注入Bean 的属性值或依赖的对象，它保证了 Bean 实例在实例化后就可以使用 
>
>    2.2 构造器注入在 <constructor-arg> 元素里声明属性, <constructor-arg> 中*<u>**没有 name 属性**</u>* 
>
> 3. 工厂方法注入(很少使用，不推荐)



## 6. 配置bean的细节

> 1. 出现特殊字符，可以使用 **<![CDATA[]]>** 把字面值包裹起来
>
>    ``` xml
>    <constructor-arg index="0">
>    			<value><![CDATA[<小马>]]></value>
>    </constructor-arg>
>    ```
>
>
> 2. ref 引用其他的bean 
>
>    ``` xml
>    <!-- 此时ref属性的值  就是你要引用得bean的id... -->
>    <property name="pet" ref="dog"></property>
>    <!-- 或者 -->
>    <property name="pet">
>    	<ref bean="dog"></ref>
>    </property>
>    ```
>
>
> 3.  内部bean不需要设置任何 id 或 name 属性 ,不能使用在任何其他地方 
>
>    ``` xml
>    <property name="pet">
>    	<!-- 内部 Bean 声明直接包含在 <property> 或 <constructor-arg> 元素里, 
>    		不需要设置任何 id 或 name 属性
>    	-->
>    	<bean class="com.igeek.demo3.Pet">
>    		<property name="petName" value="小橘"></property>
>    		<property name="petType" value="猫"></property>
>    	</bean>
>    </property> 
>    ```

> 4. 注入null值,使用<null/>标签
>
>    ```xml
>    <constructor-arg name="name">
>    	<null/>
>    </constructor-arg>
>    ```
>
> 5. null值以及级联属性的注入
>
>    ``` xml
>    <bean id="timo" class="com.igeek.demo3.Pet">
>    </bean>
>    <!-- 添加有参构造器，不要忘记添加无参构造器 -->
>    <bean id="xl" class="com.igeek.demo3.Person">
>    	<constructor-arg name="name">
>    		<null/>
>    	</constructor-arg>
>    	<constructor-arg name="age" value="20"></constructor-arg>
>    	<constructor-arg name="pet" ref="timo"></constructor-arg>
>    	<!-- 为级联属性赋值 。前提是上面的pet属性不能为null -->
>    	<property name="pet.petName" value="提莫"></property>
>    	<property name="pet.petType" value="LOL"></property>
>    </bean>
>    ```
>
>    6. 配置集合类型的属性(List,Array,Set)
>
>    ```xml
>    <bean id="dog" class="com.igeek.demo4.Pet">
>    	<property name="petName" value="大黄"></property>
>    	<property name="petType" value="犬"></property>
>    </bean>
>    <bean id="cat" class="com.igeek.demo4.Pet">
>    	<property name="petName" value="小橘"></property>
>    	<property name="petType" value="猫"></property>
>    </bean>	
>    <bean id="tom" class="com.igeek.demo4.Person">
>    	<property name="pets">
>            <!-- 
>    			如果数据类型为数组，也是使用<list>标签进行配置。
>     			如果是Set集合，使用<set>标签进行配置。
>    			(里面内容的配置方式都相同。)
>    		-->
>    		<list>
>    			<ref bean="dog"/>
>    			<ref bean="cat"/>
>                 <null/>
>                 <bean id="snake" class="com.igeek.demo4.Pet">
>    				<property name="petName" value="大象"></property>
>    				<property name="petType" value="蛇"></property>
>    			</bean>
>    		</list>
>    	</property>
>    </bean>
>    ```

> 7. 配置map类型
>
>    ```xml
>    <bean id="jack" class="com.igeek.demo4.Person">
>    	<property name="map">
>    		<map>
>    			<entry key="aa" value-ref="cat"></entry>
>    			<entry key="bb" value-ref="dog"></entry>
>    		</map>
>         </property>
>    </bean>
>    ```
>
> 8. 配置properties类型
>
>    ```xml
>    <bean id="testpros" class="com.igeek.demo4.Person">
>    		<property name="pros">
>    			<props>
>    				<prop key="user">root</prop>
>    				<prop key="password">root123</prop>
>    				<prop key="jdbcUrl">jdbc:mysql:///test</prop>
>    				<prop key="driverClass">com.mysql.jdbc.Driver</prop>
>    			</props>
>    		</property>
>    	</bean>
>    ```
>
> 9. 配置工具类集合
>
>    ```xml
>    <!-- 首先导入util命名空间 -->
>    xmlns:util="http://www.springframework.org/schema/util"
>    <util:list id="pets">
>        <ref bean="cat"/>
>        <ref bean="dog"/>
>    </util:list>
>    ```
>
> 10. 使用p命名空间
>
>   ```xml
>   <!-- 首先导入p命名空间 -->
>   xmlns:p="http://www.springframework.org/schema/p"
>   <bean id="pet" class="com.igeek.demo3.Pet" p:petName="鹦鹉" p:petType="鸟"></bean>
>   <bean id="test1" class="com.igeek.demo3.Person" p:name="张全蛋" p:age="10" 
>         p:pet-ref="pet"></bean>
>   <!-- 使用p命名空间(spring 2.5版本引入的) 可以简化bean的配置 -->
>
>   ```
>
> 11. 自动装配
>
>     ```xml
>     autowire = "byName" || "byType"  不推荐使用。
>     <!-- 
>     		可以通过autowire属性设置bean的自动装配 。
>     		byName 根据bean的名字和bean,setter风格的属性名进行自动装配，如有匹配则自动装配，没有不装配。
>     		byType 根据bean的类型，和当前bean属性的类型进行自动装配。如果ioc容器有1个以上类型匹配的bean的时候，则会抛出异常。
>     		constructor 当前bean中有多个构造器的时候 会很复杂不推荐使用该方式。
>     		
>     		自动装配的弊端。
>     		1.autowire属性是配置在bean级别的，如果只希望装配个别属性，则不够灵活。
>     		2.要么根据类型 要么根据名字自动装配 不能两个一起使用。
>     		在使用spring整合第三方框架的时候 会使用autowire 。。。
>     	 -->
>     	<bean id="xm" class="com.igeek.demo5.Person" p:name="小明" autowire="byType">
>     	</bean>
>     	
>     	<bean id="pet1" class="com.igeek.demo5.Pet" p:petName="发福蝶"></bean>
>     	<bean id="pet2" class="com.igeek.demo5.Pet" p:petName="小脑斧"></bean>
>     ```
>
>

## 7.Bean之间的关系

> 1.1 继承
>
> ```xml
> <!--
> 	抽象bean:	abstract="true"。
> 	不能被ioc容器实例化，只能用来被继承配置。
> 	如果一个bean的class值没有指定那么这个bean的abstract属性必须为true。
> -->
> <bean id="person" p:country="china" p:age="12" abstract="true"></bean>
> <!-- 
> 	使用bean的parent属性来指定继承哪一个bean.
> -->
> <bean id="xm" class="com.igeek.demo6.Person" p:name="小明" pareant="person"></bean>
>
> ```
>
> 
>
> 1.2 依赖
>
> ```xml
> <!--
> 	通过depends-on 设置前置依赖的bean,依赖的bean会在当前bean实例化之前创建好。
> 	如果依赖多个bean 可以使用   ,  |  和 空格  来区分多个bean。
> -->
> ```
>
> 
>
> 

## 8.Bean的作用域

```xml
<!-- 通过bean 的 scope属性来配置bean的作用域  
	 默认值为singlethon ,单实例的: springIOC容器被创建(初始化)就会创建好单例的bean...
	 还有prototype原型的(多实例) :需要的时候才会去创建,springIOC容器被创建并不会创建原型的bean对象。
-->
```

## 9.使用外部属性文件

```xml
<!-- 
		在配置文件中配置bean时，有时候需要混入系统部署的数据信息。
		例如：文件路径，数据源配置。
		实际上需要将这些数据跟bean的配置分离。
		spring提供了一个PropertyPlaceholderConfigurer的BeanFactory后置处理器。
		可以使用${var}的形式，从属性配置文件中读取属性，并使用这些属性。
		spring,2.5之后。可以通过<context:property-placeholder location="classpath:db.properties">
	 -->
<context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<property name="user" value="root"></property>
		<property name="password" value="root123"></property>
		<property name="driverClass" value="com.mysql.jdbc.Driver"></property>
		<property name="jdbcUrl" value="jdbc:mysql:///test"></property>
	</bean>
```

## 10.spEL

```xml
<!--
Spring 表达式语言（简称SpEL）：是一个支持运行时查询和操作对象图的强大的表达式语言。
语法类似于 EL：SpEL 使用 #{…} 作为定界符，所有在大框号中的字符都将被认为是 SpEL
SpEL 为 bean 的属性进行动态赋值提供了便利
字面量的表示:
	<property name="test" value="#{5}"/>
	<property name="test" value="#{3.14}"/>
	<property name="test" value="#{1e4}"/>
	<property name="test" value="#{'哈哈'}"/>或者<property name='test' value='#{"嘿嘿"}'/>
	<property name="test" value="#{false}"/>
引用bean属性跟方法:
	引用其他bean对象，等价于ref属性。
 	<property name="pet" value="#{pet1}"></property>
	引用其他bean对象的属性。	
	<property name="pet" value="#{pet1.petName}"></property>
	拿到方法的返回值。	
 	<property name="name" value="pet1.toString()"></property>
	链式调用。
	<property name="name" value="pet1.toString().toUpperCase()"></property>

1.算数运算符：+, -, *, /, %, ^：
2.加号还可以用作字符串连接：
3.比较运算符： <, >, ==, <=, >=, lt, gt, eq, le, ge
4.逻辑运算符号： and, or, not, |
5.if-else 运算符：pet1.petName=='鹦鹉'?'学舌':'SB';
6.支持正则:
7.调用静态方法或静态属性：通过 T() 调用一个类的静态方法，它将返回一个 Class Object，然后再调用相应的方法或属性:
 <property name="initValue" value="#{T(java.lang.Math).PI}"></property>
-->

	
```

## 11.Bean的生命周期

```xml
<!--
	Spring IOC 容器对 Bean 的生命周期进行管理的过程:(demo7)

		1.通过构造器或工厂方法创建 Bean 实例
		2.为 Bean 的属性设置值和对其他 Bean 的引用
		3.调用 Bean 的初始化方法
		4.Bean 可以使用了
		5.当容器关闭时, 调用 Bean 的销毁方法

		在 Bean 的声明里设置 init-method 和 destroy-method 属性, 为 Bean 指定初始化和销毁方法.
		注意：需要调用close方法 需要使用ApplicationContext 子接口的方法，声明对象需要换成实现类。

	更加细粒度的定制bean的声明周期方法。
	spring中提供了一个Bean后置处理器，允许在调用初始化方法前后对bean进行额外的处理。
	Bean后置处理器对IOC容器里所有的Bean实例逐一处理. 作用：检测bean属性的正确性，或者根据特定的标准更改bean的属性值。
	实现: 
			需要创建一个类 实现BeanPostProcessor接口，实现两个方法。在初始化方法被调用前后分别执行.
			然后需要将当前类 注册到springIOC容器中。
		1.通过构造器或工厂方法创建 Bean 实例
		2.为 Bean 的属性设置值和对其他 Bean 的引用
		3.将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法
		4.调用 Bean 的初始化方法
		5.将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法
		6.Bean 可以使用了
		7.当容器关闭时, 调用 Bean 的销毁方法
-->
```

## 12.通过工厂方法配置Bean

```xml
Bean 的配置方式：  
	基于XML的方式配置bean.
		1.通过全类名（反射）
		2.通过工厂方法（静态工厂方法 & 实例工厂方法）
		3.FactoryBean
	基于注解的方式配置bean.
```

```java
public class StaticFactory {

	private static Map<String,Person> persons = new HashMap<String,Person>();
	
	static{
		persons.put("tom", new Person("tom",12));
		persons.put("jack", new Person("jack",12));
	}
	
	//静态工厂方法。
	public static Person getPerson(String name){
		return persons.get(name);
	}
}


//实例工厂，需要创建工厂本身，再调用工厂的实例(对象)方法来返回需要的对象本身。
public class InstanceFactory {

	private Map<String,Person> persons = null;
	
	public InstanceFactory(){
		persons = new HashMap<String,Person>();
		persons.put("haha", new Person("haha",18));
		persons.put("xixi", new Person("xixi",18));
	}
	
	public Person getPerson(String name){
		return persons.get(name);
	}
}
```

```xml
<!-- 通过静态工厂方法配置bean -->
	<bean id="tom" 
	class="com.igeek.lesson1.StaticFactory"
	factory-method="getPerson">
		<constructor-arg value="tom"></constructor-arg>
	</bean>
	<!-- 通过实例工厂方法配置bean 1.配置工厂本身-->
	<bean id="instanceFactory" class="com.igeek.lesson1.InstanceFactory">
	</bean>
	<!-- 配置需要的bean实例 factory-bean指向实例工厂的bean，  factory-method实例工厂的方法名。-->
	<bean id="xixi" factory-bean="instanceFactory" factory-method="getPerson">
		<constructor-arg value="xixi"></constructor-arg>
	</bean>
```

```xml
<!--  
	FactoryBean  
-->
<!-- 通过factorybean 配置 bean的实例。property配置factorybean的属性值。-->
	<bean id="p1" class="com.igeek.lesson1.PersonFactoryBean">
		<property name="name" value="beanfactory..."></property>
	</bean>


public class PersonFactoryBean implements FactoryBean<Person> {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Person getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Person(name,30);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Person.class;
	}


	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}
}

```

## 13.基于注解的方式配置bean

```xml
<!--
	spring 能够从classpath下自动扫描，侦测和实例化 具有特定注解的组件(Java类)。
	组件包裹:4个注解
	@Component 基本注解，标识一个受spring IOC容器管理的一个组件。
	@Respository 标识持久层
	@Service 标识服务层(业务层)
	@Controller 标识控制层(表现层)
	对于扫描到的组件，spring有默认的命名策略:
	使用类名第一个字母小写。也可以在注解中通过value属性标识组件名称。

-->
```

```xml
<!--
当在组件类上使用了特定的注解之后, 还需要在 Spring 的配置文件中声明 <context:component-scan> 

base-package 属性指定一个需要扫描的基类包，Spring 容器将会扫描这个基类包里及其子包中的所有类. 
当需要扫描多个包时, 可以使用逗号分隔.

如果仅希望扫描特定的类而非基包下的所有类，可使用 resource-pattern 属性过滤特定的类
<context:component-scan base-package="com" resource-pattern="test/*.class"/>

<context:include-filter> 子节点表示要包含的目标类

<context:exclude-filter> 子节点表示要排除在外的目标类

<context:component-scan> 下可以拥有若干个 <context:include-filter> 和 <context:exclude-filter> 子节点
-->
```

```xml
<!-- resource-pattern 指定扫描特定包下的类。resource-pattern="annotation/service/impl/*.class" -->
	<context:component-scan base-package="com/igeek/lesson2" use-default-filters="false" >
		<!-- type共五种，annotation注解，assinable所有继承或实现xxx的类。 aspectj ,regex , custom -->
		<!-- <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/> -->
		<!-- <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/> -->	
		<context:include-filter type="assignable" expression="com.igeek.lesson2.annotation.service.UserService"/>
	</context:component-scan>
```

## 14.组件装配

```xml
<!--
<context:component-scan> 元素还会自动注册 AutowiredAnnotationBeanPostProcessor 实例, 该实例可以自动装配具有 @Autowired 和 @Resource 、@Inject注解的属性.

@Autowired 自动装配具有兼容类型的单个Bean属性
1.构造器, 普通字段(即使是非 public), 一切具有参数的方法都可以应用@Authwired 注解
2.默认情况下, 所有使用 @Authwired 注解的属性都需要被设置. 当 Spring 找不到匹配的 Bean 装配属性时, 会抛出异常, 若某一属性允许不被设置, 可以设置 @Authwired 注解的 required 属性为 false
3.默认情况下, 当 IOC 容器里存在多个类型兼容的 Bean 时, 通过类型的自动装配将无法工作. 此时可以在 @Qualifier 注解里提供 Bean 的名称. Spring 允许对方法的入参标注 @Qualifiter 已指定注入 Bean 的名称

了解:
@Authwired 注解也可以应用在数组类型的属性上, 此时 Spring 将会把所有匹配的 Bean 进行自动装配.
@Authwired 注解也可以应用在集合属性上, 此时 Spring 读取该集合的类型信息, 然后自动装配所有与之兼容的 Bean. 
@Authwired 注解用在 java.util.Map 上时, 若该 Map 的键值为 String, 那么 Spring 将自动装配与之 Map 值类型兼容的 Bean, 此时 Bean 的名称作为键值

Spring 还支持 @Resource 和 @Inject 注解，这两个注解和 @Autowired 注解的功用类似
@Resource 注解要求提供一个 Bean 名称的属性，若该属性为空，则自动采用标注处的变量或方法名作为 Bean 的名称
@Inject 和 @Autowired 注解一样也是按类型匹配注入的 Bean， 但没有 reqired 属性
建议使用 @Autowired 注解
-->

```



