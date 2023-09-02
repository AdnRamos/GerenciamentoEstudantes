package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.serializacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setMixInAnnotation(HibernateProxy.class, HibernateProxyMixin.class);
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
