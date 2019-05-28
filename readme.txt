环境配置说明：
1、工程要用jdk8编译
2、springboot自带一个内嵌的tomcat，可以用run application启动tomcat。不需要外部tomcat
3、hibernate没有用SessionFactory执行sql，而是用EntityManager，参考：https://stackoverflow.com/questions/43533691/required-a-bean-of-type-org-hibernate-sessionfactory-that-could-not-be-found/43537578
	EntityManager是springboot推荐的服务，它内部会调用hibernate访问数据库
4、没有用servlet-context.xml配置web应用，用springboot约定的web目录结构，不需要做配置

如何启动web服务器：
1、执行工程根目录下面的start-springboot.launch文件即可。这个文件的右键菜单里面有debug as，二级菜单的第一个为“start-springboot”，点击这个"start-springboot"，就开始执行这个launch文件
2、控制台没有异常即表示启动成功。启动成功时的控制台日志为（日志太长，下面的日志有一点删减）：
		00:20:27.520 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Included patterns for restart : []
		00:20:27.537 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Excluded patterns for restart : [/spring-boot-actuator/target/classes/, /spring-boot-devtools/target/classes/, /spring-boot/target/classes/, /spring-boot-starter-[\w-]+/, /spring-boot-autoconfigure/target/classes/, /spring-boot-starter/target/classes/]
		00:20:27.538 [main] DEBUG org.springframework.boot.devtools.restart.ChangeableUrls - Matching URLs for reloading : [file:/D:/succezIDE3/workspace-3.1.4/my-react-backend/target/classes/]
		
		  .   ____          _            __ _ _
		 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
		( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
		 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
		  '  |____| .__|_| |_|_| |_\__, | / / / /
		 =========|_|==============|___/=/_/_/_/
		 :: Spring Boot ::        (v2.0.4.RELEASE)
		
		2019-05-29 00:20:28.181  INFO 40152 --- [  restartedMain] com.MyReact.MyReactBackendApplication    : Starting MyReactBackendApplication on xty-PC with PID 40152 (D:\succezIDE3\workspace-3.1.4\my-react-backend\target\classes started by xty in D:\succezIDE3\workspace-3.1.4\my-react-backend)
		2019-05-29 00:20:28.183  INFO 40152 --- [  restartedMain] com.MyReact.MyReactBackendApplication    : No active profile set, falling back to default profiles: default
		2019-05-29 00:20:34.552  INFO 40152 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
		2019-05-29 00:20:34.553  INFO 40152 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.32
		2019-05-29 00:20:34.572  INFO 40152 --- [ost-startStop-1] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [D:\succezIDE3\jdk\jdk1.8.0_60\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;D:\succezIDE3\jdk\jdk1.8.0_60\jre\bin;D:/succezIDE3/jdk/jdk1.8.0_212/jre/bin/server;D:/succezIDE3/jdk/jdk1.8.0_212/jre/bin;D:/succezIDE3/jdk/jdk1.8.0_212/jre/lib/amd64;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;D:\succezIDE3\tools\node-v8.4.0-win-x64;D:\Program Files (x86)\OpenVPN\bin;C:\WINDOWS\System32\OpenSSH\;D:\succezIDE3\tools\PortableGit\bin;D:\Program Files\Git\cmd;C:\Users\xty\AppData\Local\Microsoft\WindowsApps;;C:\Users\xty\AppData\Local\Programs\Fiddler;D:\Program Files (x86)\Fiddler2_2\Fiddler;C:\Users\xty\AppData\Local\Microsoft\WindowsApps;C:\Program Files\Bandizip\;D:\succezIDE3\eclipse\eclipse-java-neon-2-win32-x86_64\eclipse;;.]
		2019-05-29 00:20:35.330  INFO 40152 --- [ost-startStop-1] org.apache.jasper.servlet.TldScanner     : At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
		2019-05-29 00:20:35.342  INFO 40152 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
		2019-05-29 00:20:35.342  INFO 40152 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 6998 ms
		2019-05-29 00:20:35.580  INFO 40152 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
		2019-05-29 00:20:35.581  INFO 40152 --- [ost-startStop-1] .s.DelegatingFilterProxyRegistrationBean : Mapping filter: 'springSecurityFilterChain' to: [/*]
		2019-05-29 00:20:35.582  INFO 40152 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
		2019-05-29 00:20:36.348  INFO 40152 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Building JPA container EntityManagerFactory for persistence unit 'default'
		2019-05-29 00:20:36.427  INFO 40152 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
			name: default
			...]
		2019-05-29 00:20:36.813  INFO 40152 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate Core {5.2.17.Final}
		2019-05-29 00:20:36.817  INFO 40152 --- [  restartedMain] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
		2019-05-29 00:20:37.024  INFO 40152 --- [  restartedMain] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
		2019-05-29 00:20:37.333  INFO 40152 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
		2019-05-29 00:20:37.565  INFO 40152 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
		2019-05-29 00:20:37.607  INFO 40152 --- [  restartedMain] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
		2019-05-29 00:20:38.973  INFO 40152 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
		2019-05-29 00:20:41.241  INFO 40152 --- [  restartedMain] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: org.springframework.security.web.util.matcher.AnyRequestMatcher@1, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@3d088baf, org.springframework.security.web.context.SecurityContextPersistenceFilter@5f43ab61, org.springframework.security.web.header.HeaderWriterFilter@2b609fff, org.springframework.web.filter.CorsFilter@aafa209, com.MyReact.filter.OptionsRequestFilter@1093c48e, org.springframework.security.web.authentication.logout.LogoutFilter@73dc160f, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@14e18eb0, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@db8c876, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@222ecb19, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@76c63fe6, org.springframework.security.web.access.ExceptionTranslationFilter@59afeb66, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@3255832d]
		2019-05-29 00:20:41.765  INFO 40152 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
		2019-05-29 00:20:42.385  INFO 40152 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@58a7398c: startup date [Wed May 29 00:20:28 CST 2019]; root of context hierarchy
		2019-05-29 00:20:42.608  WARN 40152 --- [  restartedMain] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
		2019-05-29 00:20:42.787  INFO 40152 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/index/default],methods=[GET]}" onto public org.springframework.web.servlet.ModelAndView com.MyReact.controller.IndexController.load(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
		2019-05-29 00:20:42.821  INFO 40152 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
		2019-05-29 00:20:42.968  INFO 40152 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
		2019-05-29 00:20:42.970  INFO 40152 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
		2019-05-29 00:20:44.233  INFO 40152 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
		2019-05-29 00:20:44.426  INFO 40152 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
		2019-05-29 00:20:44.428  INFO 40152 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'dataSource' has been autodetected for JMX exposure
		2019-05-29 00:20:44.438  INFO 40152 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located MBean 'dataSource': registering with JMX server as MBean [com.zaxxer.hikari:name=dataSource,type=HikariDataSource]
		2019-05-29 00:20:44.658  INFO 40152 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
		2019-05-29 00:20:44.671  INFO 40152 --- [  restartedMain] com.MyReact.MyReactBackendApplication    : Started MyReactBackendApplication in 17.1 seconds (JVM running for 18.347)
3、打开浏览器，访问地址：http://localhost:8080/login/default ，出现登录页面
4、在登录页面中输入用户名：Jack，密码：jack-password
5、登录成功之后会跳转到一个天气页面
6、说明系统启动成功