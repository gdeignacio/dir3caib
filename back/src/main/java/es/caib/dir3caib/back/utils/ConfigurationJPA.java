package es.caib.dir3caib.back.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.caib.dir3caib.utils.Constants;
/**
 * 
 * @author anadal
 *
 */
@Configuration
@EnableTransactionManagement
public class ConfigurationJPA {
  
  protected final Logger log = Logger.getLogger(getClass());

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    if(log.isDebugEnabled()) {
      log.debug("Passa per entityManagerFactory()");
    }

    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

    em.setDataSource(dataSource());
    em.setPackagesToScan(new String[] { "es.caib.dir3caib.persistence.model" });

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setPersistenceProviderClass(org.hibernate.ejb.HibernatePersistence.class);
    em.setJpaProperties(additionalProperties());
    return em;
  }

  @Bean
  public DataSource dataSource() {
    DataSource ds = (DataSource) getFromInitialContext("java:/es.caib.dir3caib.db");
    return ds;
  }

  private Properties additionalProperties() {

    Properties sysProp = System.getProperties();
    final String hibernateProp = Constants.DIR3CAIB_PROPERTY_BASE + "hibernate.";
    final int cutIndex = Constants.DIR3CAIB_PROPERTY_BASE.length();
    Properties properties = new Properties();
    for (Object keyObj : sysProp.keySet()) {
      String key = (String) keyObj;
      if (key.startsWith(hibernateProp)) {
        String hibKey = key.substring(cutIndex);
        String hibValue = sysProp.getProperty(key);

        log.info(" Setting Additional Hibernate Property [" + hibKey + "]=" + hibValue);

        properties.setProperty(hibKey, hibValue);
      }

    }

    return properties;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    if(log.isDebugEnabled()) {
      log.debug("Passa per transactionManager()");
    }

    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  private Object getFromInitialContext(String jndiValue) {
    Context ctx = null;
    Object object = null;
    try {
      ctx = new InitialContext();
      object = ctx.lookup(jndiValue);
    } catch (NamingException e) {
      log.error(e.getMessage(), e);
    }
    return object;
  }

}
