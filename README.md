# x8l_spring-context

X8l data format for Spring framework ApplicationContext.

<p>
  <b>
      See <a href="https://plugins.jetbrains.com/plugin/13915-x8l">plugin on Jetbrains plugin storage</a><br/>
      See <a href="https://github.com/XenoAmess/x8l_idea_plugin">plugin on github</a><br/>
      See <a href="https://github.com/cyanpotion/x8l">X8l Grammar/SDK</a><br/>
      See <a href="https://github.com/XenoAmess/x8l_spring_context">X8l Spring Context</a><br/>
  </b>
</p>

Use this we can replace bean.xml to bean.x8l when handling spring.

Right now we have a shabby demo version showing possibility only,
as I have no effort to maintain a real high performance one.

But at least it is usable.

```
<beans xmlns=http://www.springframework.org/schema/beans xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance xsi:schemaLocation=http://www.springframework.org/schema/beans% % % % % % % % http://www.springframework.org/schema/beans/spring-beans-3.0.xsd>
    <bean id=test class=com.xenoamess.x8l.springframework.context.TestClass>
        <property name=a value=testtesttest>>
    >
>
```
For more details about usage,please go test folder.