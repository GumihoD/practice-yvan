package com.yvan.practice.test.rest;

import com.yvan.practice.entity.mysql.user.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * 在Dubbo中开发REST风格的远程调用（RESTful Remoting）
 * http://dangdangdotcom.github.io/dubbox/rest.html
 * Created by yvan on 16/10/14.
 */
@Path("users")
public class UserResource {

    /**
     * JAX-RS本身可以支持所有这些形式。但是上面那种在URL路径中包含查询参数的形式（http://localhost:8080/users/1001） 更
     * 符合REST的一般习惯，所以更推荐大家来使用。下面我们就为UserService添加一个getUser()方法来实现这种形式的URL访问：
     *
     * @param id
     * @return
     * @Path("{id : \d+}")：根据上面的功能需求，访问getUser()的URL应当是“http://localhost:8080/users/ + 任意数字"，
     * 并且这个数字要被做为参数传入getUser()方法。 这里的annotation配置中，@Path中间的{id: xxx}指定URL相对路径中包含了名
     * 为id参数，而它的值也将被自动传递给下面用@PathParam("id")修饰的方法参数id。{id:后面紧跟的\d+是一个正则表达式，指定了
     * id参数必须是数字。
     */
    @GET
    @Path("{id : \\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("id") Long id) {
        //..
        return null;
    }

    /**
     * REST的优点
     * 可更高效利用缓存来提高响应速度
     * 通讯本身的无状态性可以让不同的服务器的处理一系列请求中的不同请求，提高服务器的扩展性
     * 浏览器即可作为客户端，简化软件需求
     * 相对于其他叠加在HTTP协议之上的机制，REST的软件依赖性更小
     * 不需要额外的资源发现机制
     * 在软件技术演进中的长期的兼容性更好
     * 这里我还想特别补充REST的显著优点：基于简单的文本格式消息和通用的HTTP协议，使它具备极广的适用性，几乎所有语言和平台都对它提供支持，同时其学习和使用的门槛也较低。
     */
}
