package org.first.first.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.first.first.models.Account;
import org.first.first.models.Authority;
import org.first.first.models.Post;
import org.first.first.services.PostService;
import org.first.first.util.constants.Privillages;
import org.first.first.util.constants.Roles;
import org.first.first.services.AccountService;
import org.first.first.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner{
    @Autowired
        private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("kunjansoni169@gmail.com");
        account01.setPassword("password");
        account01.setFirstname("user1");
        account01.setLastname("lastname01");
        account01.setDate_of_birth(LocalDate.parse("2020-12-03"));
        account01.setGender("Male");

        account02.setEmail("admin@org");
        account02.setPassword("password");
        account02.setFirstname("user2");
        account02.setLastname("lastname02");
        account02.setDate_of_birth(LocalDate.parse("2024-11-13"));
        account02.setGender("Female");
        account02.setRole(Roles.ADMIN.getRole());

        account03.setEmail("Editor@org");
        account03.setPassword("password");
        account03.setFirstname("user3");
        account03.setLastname("lastname03");
        account03.setDate_of_birth(LocalDate.parse("2000-02-21"));
        account03.setGender("Male");
        account03.setRole(Roles.EDITOR.getRole());

        account04.setEmail("ac04@org");
        account04.setPassword("password");
        account04.setFirstname("user4");
        account04.setLastname("lastname04");
        account04.setDate_of_birth(LocalDate.parse("2021-12-03"));
        account04.setGender("Male");
        account04.setRole(Roles.EDITOR.getRole());

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);


        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.findAll();
        if(posts.size()==0){
            Post post01 = new Post();
            post01.setTitle("Model–view–controller framework");
            post01.setBody("Model–view–controller framework\r\n" + //
                                "\r\n" + //
                                "Spring MVC/Web Reactive presentation given by Jürgen Höller\r\n" + //
                                "The Spring Framework features its own model–view–controller (MVC) web application framework,[35] which was not originally planned. The Spring developers decided to write their own Web framework as a reaction to what they perceived as the poor design of the (then) popular Jakarta Struts Web framework,[80][failed verification] as well as deficiencies in other available frameworks. In particular, they felt there was insufficient separation between the presentation and request handling layers, and between the request handling layer and the model.[81]\r\n" + //
                                "\r\n" + //
                                "Like Struts, Spring MVC is a request-based framework.[4]: 375  The framework defines strategy interfaces[4]: 144  for all of the responsibilities that must be handled by a modern request-based framework. The goal of each interface is to be simple and clear so that it's easy for Spring MVC users to write their own implementations, if they so choose. MVC paves the way for cleaner front end code. All interfaces are tightly coupled to the Servlet API. This tight coupling to the Servlet API is seen by some as a failure on the part of the Spring developers to offer a high level of abstraction for Web-based applications [citation needed]. However, this coupling ensures that the features of the Servlet API remain available to developers while offering a high abstraction framework to ease working with it.\r\n" + //
                                "\r\n" + //
                                "The DispatcherServlet class is the front controller[82] of the framework and is responsible for delegating control to the various interfaces during the execution phases of an HTTP request.[83]\r\n" + //
                                "\r\n" + //
                                "The most important interfaces defined by Spring MVC, and their responsibilities, are listed below:[84]\r\n" + //
                                "\r\n" + //
                                "Controller: comes between Model and View to manage incoming requests and redirect to proper response.[85] Controller will map the http request to corresponding methods.[86] It acts as a gate that directs the incoming information. It switches between going into Model or View.\r\n" + //
                                "HandlerAdapter: responsible for execution of objects that handle incoming requests.[87]\r\n" + //
                                "HandlerInterceptor: responsible for intercepting incoming requests.[87] Comparable, but not equal to Servlet filters[4]: 509  (use is optional[4]: 511  and not controlled by DispatcherServlet).\r\n" + //
                                "HandlerMapping: responsible for selecting objects that handle incoming requests (handlers) based on any attribute or condition internal or external to those requests[83]\r\n" + //
                                "LocaleResolver: responsible for resolving and optionally saving of the locale of an individual user.[88]\r\n" + //
                                "MultipartResolver: facilitate working with file uploads by wrapping incoming requests.[89]\r\n" + //
                                "View: responsible for returning a response to the client. The View should not contain any business logic and should only present the data encapsulated by the Model.[35] Some requests may go straight to View without going to the Model part; others may go through all three.\r\n" + //
                                "ViewResolver: responsible for selecting a View based on a logical name for the View[90][91] (use is not strictly required[4]: 511 ).\r\n" + //
                                "Model: responsible for encapsulating business data.[90] The Model is exposed to the view by the controller.[4]: 374  (use is not strictly required).\r\n" + //
                                "Each strategy interface above has an important responsibility in the overall framework. The abstractions offered by these interfaces are powerful, so to allow for a set of variations in their implementations.[4]: 144  Spring MVC ships with implementations of all these interfaces and offers a feature set on top of the Servlet API. However, developers and vendors are free to write other implementations. Spring MVC uses the Java java.util.Map interface as a data-oriented abstraction for the Model where keys are expected to be String values.[citation needed]\r\n" + //
                                "\r\n" + //
                                "The ease of testing the implementations of these interfaces is one important advantage of the high level of abstraction offered by Spring MVC.[92][4]: 324  DispatcherServlet is tightly coupled to the Spring inversion of control container for configuring the web layers of applications. However, web applications can use other parts of the Spring Framework, including the container, and choose not to use Spring MVC.");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("A workflow of Spring MVC");
            post02.setBody("A workflow of Spring MVC\r\n" + //
                                "When a user clicks a link or submits a form in their web-browser, the request goes to the Spring DispatcherServlet. DispatcherServlet is a front-controller in Spring MVC.[83][93] The DispatcherServlet is highly customizable and flexible.[93] Specifically, it is capable of handling more types of handlers than any implementations of org. springframework.web.servlet.mvc.Controller or org. springframework.stereotype.Controller annotated classes.[93] It consults one or more handler mappings.[83] DispatcherServlet chooses an appropriate controller and forwards the request to it. The Controller processes the particular request and generates a result. It is known as Model. This information needs to be formatted in html or any front-end technology like Jakarta Server Pages (also known as JSP)[83][94] or Thymeleaf.[94] This is the View of an application.[83] All of the information is in the Model And View object. When the controller is not coupled to a particular view, DispatcherServlet finds the actual View (such as JSP) with the help of ViewResolver.[83][4]: 390–391 \r\n" + //
                                "\r\n" + //
                                "Configuration of DispatcherServlet\r\n" + //
                                "As of Servlet Specification version 3.0, there are a few ways of configuring the DispatcherServlet:[95]\r\n" + //
                                "\r\n" + //
                                "By configuring it in web.xml as shown below:[95]\r\n" + //
                                "<servlet>\r\n" + //
                                "  <servlet-name>MyServlet</servlet-name>\r\n" + //
                                "  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>\r\n" + //
                                "</servlet>\r\n" + //
                                "\r\n" + //
                                "<servlet-mapping>\r\n" + //
                                "  <servlet-name>MyServlet</servlet-name>\r\n" + //
                                "  <url-pattern>/<url-pattern>\r\n" + //
                                "</servlet-mapping>\r\n" + //
                                "By configuring it in web-fragment.xml[95]\r\n" + //
                                "By using javax.servlet.ServletContainerInitializer[95]\r\n" + //
                                "By implementing the org.springframework.web.WebApplicationInitializer interface.[95]\r\n" + //
                                "By using the built-in autoconfiguration for Spring Boot, which uses the SpringBootServletInitializer class.lm[95]");
            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("post 3");
            post03.setBody("The ease of testing the implementations of these interfaces is one important advantage of the high level of abstraction offered by Spring MVC.[92][4]: 324  DispatcherServlet is tightly coupled to the Spring inversion of control container for configuring the web layers of applications. However, web applications can use other parts of the Spring Framework, including the container, and choose not to use Spring MVC.");
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("post 4");
            post04.setBody("By using the built-in autoconfiguration for Spring Boot, which uses the SpringBootServletInitializer class.lm[95]");
            post04.setAccount(account02);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("post 5");
            post05.setBody("The ease of testing the implementations of these interfaces is one important advantage of the high level of abstraction offered by Spring MVC.[92][4]: 324  DispatcherServlet is tightly coupled to the Spring inversion of control container for configuring the web layers of applications. However, web applications can use other parts of the Spring Framework, including the container, and choose not to use Spring MVC.");
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("post 6");
            post06.setBody("By using the built-in autoconfiguration for Spring Boot, which uses the SpringBootServletInitializer class.lm[95]");
            post06.setAccount(account02);
            postService.save(post06);
        }
    }
    
}
