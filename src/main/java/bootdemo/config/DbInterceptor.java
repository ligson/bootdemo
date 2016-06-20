package bootdemo.config;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by trq on 2016/6/20.
 */
@Component("dbInterceptor")
public class DbInterceptor extends EmptyInterceptor implements InitializingBean {
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("sql:" + sql);
        return super.onPrepareStatement(sql);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("============--0----");
    }
}
