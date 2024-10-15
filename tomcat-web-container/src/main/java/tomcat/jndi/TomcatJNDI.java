package tomcat.jndi;

import javax.sql.DataSource;

public class TomcatJNDI {

    // TODO. 配置JNDI DataSource数据源
    // 1. .setResourceRef(true) 设置"相对路径"引用, 反之使用"java:comp/env/jdbc/dataSourceName"
    // 2. .getDataSource(name)  直接使用Tomcat context.xml配置文件中dataSourceName名称来获取数据资源
    // @Bean
    // public DataSource dataSource() {
    //     JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
    //     dataSourceLookup.setResourceRef(true);
    //     DataSource dataSource = dataSourceLookup.getDataSource("jdbc/myDataSource");
    //     return dataSource;
    // }
}
