# springMVC

## 1.springMVC概述

> Spring 为展现层提供的基于 MVC 设计理念的优秀的Web 框架，是目前最主流的 MVC 框架之一
>
> Spring3.0 后全面超越 Struts2，成为最优秀的 MVC 框架
>
> Spring MVC 通过一套 MVC 注解，让 POJO 成为处理请求的控制器，而无须实现任何接口。
>
> 支持 REST 风格的 URL 请求(Put DELETE   get  post)  CRUD 增删改查
>
> 采用了松散耦合可插拔组件结构，比其他 MVC 框架更具扩展性和灵活性

## 2.springMVC HelloWorld

> – 加入 jar 包
> – 在 web.xml 中配置 DispatcherServlet
> – 加入 Spring MVC 的配置文件
> – 编写处理请求的处理器，并标识为处理器
> – 编写视图

```xml
<servlet>
    	<!-- 配置DispatcherServlet-->
		<servlet-name>springDispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!--配置初始化参数，指定springmvc配置文件的位置。-->
    	<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:springmvc.xml</param-value>
		</init-param>
    	<!-- 当前web应用被加载的时候被创建。-->
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
        <!-- 映射所有请求。-->
		<servlet-name>springDispatcherServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
实际上也可以不通过初始化参数来指定springＭＶＣ配置文件的位置。
默认规则：　　/WEB-INF/<servlet-name>-servlet.xml
```

```xml
<!-- springmvc.xml-->
<context:component-scan base-package="com/igeek/springmvc"></context:component-scan>
	<!-- 配置视图解析器：把方法的返回值解析为实际的物理视图。 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
```

```xml
通过@RequestMapping注解 来映射请求的url...
方法的返回值，用于响应的实际视图。InternalResourceViewResolver视图解析器，会通过
前缀+ 方法的返回值名称 +后缀 
的形式返回目标页面。(注意：默认通过请求转发的方式跳转。)
```

## 3.@RequestMapping

> @RequestMapping 除了可以使用请求 URL 映射请求外，还可以使用请求方法、请求参数及请求头映射请求
>
> @RequestMapping 的 value、method、params 及 heads 分别表示请求 URL、请求方法、请求参数及请求头的映射条件，他们之间是与的关系，联合使用多个条件可让请求映射更加精确化
>
> params 和 headers支持简单的表达式：
> – param1: 表示请求必须包含名为 param1 的请求参数
> – !param1: 表示请求不能包含名为 param1 的请求参数
> – param1 != value1: 表示请求包含名为 param1 的请求参数，但其值不能为 value1
> – {“param1=value1”, “param2”}: 请求必须包含名为 param1 和param1 和param2 的两个请求参数，且 param1 参数的值必须为 value1



```xml
请求方式    请求URL   HTTP协议
GET /springMVC-1/hello HTTP/1.1
请求头
Host: localhost:8080
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Referer: http://localhost:8080/springMVC-1/index.jsp
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: JSESSIONID=7F560EEBB4627D1D291ED8A8F81EB2D5; Webstorm-46fc939c=3122e498-a830-4477-b7ea-7c0b20d8a8bc
报文体
id=12&name=zhangsan&password=123
```

```java
@RequestMapping(value="/test2",params={"name","age!=0"},headers={"Accept-Language: en-US,zh;q=0.9"})
public String test2(){	
	return SUCCESS;
}
```

```xml
@RequestMapping映射请求还支持Ant风格的URL.
Ant 风格资源地址支持 3 种匹配符：
– ?：匹配文件名中的一个字符
– *：匹配文件名中的任意字符
– **：** 匹配多层路径
– /user/*/createUser: 匹配
/user/aaa/createUser、/user/bbb/createUser 等 URL
– /user/**/createUser: 匹配
/user/createUser、/user/aaa/bbb/createUser 等 URL
– /user/createUser??: 匹配
/user/createUseraa、/user/createUserbb 等 URL
```

## 4.@PathVariable

> 带占位符的 URL 是 Spring3.0 新增的功能，该功能在SpringMVC 向 REST 目标挺进发展过程中具有里程碑的
> 意义
>
> 通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：

```java
//@PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
@RequestMapping("/test3/{id}")
public String test3(@PathVariable("id") int id){
	System.out.println(id);
	return SUCCESS;
}
注意：占位符的名字应该跟PathVariable中的value属性一致。
```

## 5.REST

```xml
REST：即 Representational State Transfer。（资源）表现层状态转化。是目前最流行的一种互联网软件架构。它结构清晰、符合标准、易于理解、扩展方便，所以正得到越来越多网站的采用

资源（Resources）：网络上的一个实体，或者说是网络上的一个具体信息。它可以是一段文本、一张图片、一首歌曲、一种服务，总之就是一个具体的存在。可以用一个URI（统一资源定位符）指向它，每种资源对应一个特定的 URI 。要获取这个资源，访问它的URI就可以，因此 URI 即为每一个资源的独一无二的识别符

表现层（Representation）：把资源具体呈现出来的形式，叫做它的表现层（Representation）。比如，文本可以用 txt 格式表现，也可以用 HTML 格式、XML 格式、JSON 格式表现，甚至可以采用二进制格式

状态转化（State Transfer）：每发出一个请求，就代表了客户端和服务器的一次交互过程。HTTP协议，是一个无状态协议，即所有的状态都保存在服务器端。因此，如果客户端想要操作服务器，必须通过某种手段，让服务器端发生“状态转化”（State Transfer）。而这种转化是建立在表现层之上的，所以就是 “表现层状态转化”。具体说，就是 HTTP协议里面，四个表示操作方式的动词：GET、POST、PUT、DELETE。它们分别对应四种基本操作：GET 用来获取资,POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源
```

```java
示例：
– /order/1 HTTP GET ：得到 id = 1 的 order 
– /order/1 HTTP DELETE：删除 id = 1的 order 
– /order/1 HTTP PUT：更新id = 1的 order 
– /order HTTP POST：新增 order
HiddenHttpMethodFilter：浏览器 form 表单只支持 GET 与 POST 请求，而DELETE、PUT 等 method 并不支持，Spring3.0 添加了一个过滤器，可以将这些请求转换为标准的 http 方法，使得支持 GET、POST、PUT 与DELETE 请求
```

```xml
springMVC使用REST风格URL的步骤:
1.配置一个Filter , HiddenHttpMethodFilter,过滤所有请求
2.通过表达发送一个POST请求
3.在表单中添加一个name为_method的隐藏域，值为DELETE或者PUT
```

```html
<form action="user/testRest/1" method="post">
	<input type="hidden" name="_method" value="PUT"/>
	<input type="submit" value="TestRest PUT"/>
</form>
```

```java
@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
public String testRestPut(@PathVariable Integer id) {
	System.out.println("testRest Put: " + id);
	return SUCCESS;
}
```

## 6.@RequestParam

> 在处理方法入参处使用 @RequestParam 可以把请求参数传递给请求方法
>
> – value：参数名
>
> – required：是否必须。默认为 true, 表示请求参数中必须包含对应的参数，若不存在，将抛出异常
>
> – default:默认值 

```html
<form action="user/testRequestParam" method="post">
	<input type="text" name="name" value="hahaigeek">
	<input type="text" name="age" value="100"/>
	<input type="submit">
</form>
<a href="user/testRequestParam?name=igeek&age=100">test request param</a>
```

```java
@RequestMapping("/testRequestParam")
public String test4(@RequestParam(value="name") String name,@RequestParam(value="age") int age){
	System.out.println(name+age);
	return SUCCESS;
}
//注意：@RequestParam可以将请求中的参数绑定到目标方法的入参。 
//可以配置的属性 。required 参数是否是必须的默认为true，不传会产生异常.
//可以通过defaultValue属性来设置参数的默认值。 比如入参类型写成int假如不传递，则不知道int类型该给一个什么样的默认值，Integer类型则会默认给一个null.
```

## 7.@RequestHeader

> 类似@RequestParam ，可以获得请求头中的具体参数。 用法同@RequestParam，映射请求头中的信息，使用较少，了解以下。

## 8.@CookieValue

> 用法同样类似@RequestParam,作用用来获取指定的cookie值，了解以下 。

## 9.POJO

> Spring MVC 会按请求参数名和 POJO(普通的Java类) 属性名进行自动匹配， 自动为该对象填充属性值。支持级联属性。 表单的值通常对应一个POJO的Java对象。

## 10.springMVC对Servlet原生API的支持

> • HttpServletRequest
> • HttpServletResponse
> • HttpSession
> • java.security.Principal
> • Locale
> • InputStream
> • OutputStream
> • Reader
> • Writer

```java
源码分析：
1.ServletHandlerMethodInvoker,175行。此时调用方法,args中传递的就是request，response。
2.ServletHandlerMethodInvoker 170行。解析handler参数。先判断注解类型的参数，310行一般类型的参数，进入
3.865，解析标准参数，行点击实现类查看。
```

```java
@RequestMapping("/testapi")
public void test5(HttpServletRequest request,HttpServletResponse response) throws IOException{
	//response.setCharacterEncoding("utf-8");
	//response.setContentType("text/html;charset=UTF-8");
	System.out.println(request+"  "+ response);
	//PrintWriter out=response.getWriter();
	//out.write("test servlet api 哈哈哈哈");
}
```

## 11.处理模型数据

> 1– ModelAndView: 处理方法返回值类型为 ModelAndView时, 方法体即可通过该对象添加模型数据
>
> 2– Map 及 Model: 入参为org.springframework.ui.Model、org.springframework.ui.ModelMap 或 java.uti.Map 时，处理方法返回时，Map 中的数据会自动添加到模型中
>
> 3– @SessionAttributes: 将模型中的某个属性暂存到HttpSession 中，以便多个请求之间可以共享这个属性
>
> 4– @ModelAttribute: 方法入参标注该注解后, 入参的对象就会放到数据模型中

```java
//目标方法的返回值可以是 ModelAndView 类型。
//SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中.
@RequestMapping("/testmodelandview")
public ModelAndView testmav(){
	ModelAndView mv = new ModelAndView(SUCCESS);
	mv.addObject("date", new Date());
	return mv;
}
//注意:ModelAndView中即包含了要视图信息(要跳转的目标页面)，也包含了模型数据，即放入到请求域中的数据。
```

```java
/**
 * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数. 
 * @param map
 * @return
 */
@RequestMapping("/testMap")
public String testMap(Map<String, Object> map){
	map.put("names", Arrays.asList("zs", "ls", "zl"));
	return SUCCESS;
}
```

```java
@SessionAttributes(value={"user"}, types={String.class}) 修饰在类的上面。
/**
 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
 * 
 * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
 * 		SessionAttributes注解，即会将数据放在request域中，也会将数据放到session域中。
 */
@RequestMapping("/testSessionAttributes")
public String testSessionAttributes(Map<String, Object> map){
	User user = new User("Tom", "123456");
	map.put("user", user);
	map.put("id", "123");
	return SUCCESS;
}
```

```java
//@ModelAttribute注解

//使用场景，想要修改数据库中一条记录的某些字段，特定的字段不去修改，使用数据库中原始存在的。

//演示步骤
//1.写一个表单，提交到目标方法。
//2.目标方法的入参位置标注一个实体类对象，值会自动的注入到当前对象
//3.添加ModelAttribute修饰的方法，
/**
 * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用! 
 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
 * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
 * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中. 
 
 * 注意: 在 @ModelAttribute 修饰的方法中, 放入到 Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
			Map<String, Object> map){
		System.out.println("modelAttribute method");
		if(id != null){
			//模拟从数据库中获取对象
			User user = new User(1, "Tom", "123456", 12);
			System.out.println("从数据库中获取一个对象: " + user);
			
			map.put("user", user);
		}
	}

```

## 12.配置直接转发的页面

```xml
	<!-- 配置直接转发的页面 -->
	<!-- 可以直接相应转发的页面, 而无需再经过 Handler 的方法.  -->
	<mvc:view-controller path="/success" view-name="success"/>
	
	<!-- 在实际开发中通常都需配置 mvc:annotation-driven 标签 -->
	<mvc:annotation-driven></mvc:annotation-driven>
	(自定义视图解析器，国际化)
```

## 13.重定向

```xml
一般情况下，控制器方法返回字符串类型的值会被当成逻辑视图名处理
如果返回的字符串中带 forward: 或 redirect: 前缀时，SpringMVC 会对他们进行特殊处理：将 forward: 和redirect: 当成指示符，其后的字符串作为 URL 来处理 
– redirect:success.jsp：会完成一个到 success.jsp 的重定向的操作
– forward:success.jsp：会完成一个到 success.jsp 的转发操作
```

### 14.返回json

```xml
1.导入jackson相关3个jar
2.编写前端页面
3.编写方法，方法的返回值定义成集合类型，方法添加ResponseBody即可。
```

