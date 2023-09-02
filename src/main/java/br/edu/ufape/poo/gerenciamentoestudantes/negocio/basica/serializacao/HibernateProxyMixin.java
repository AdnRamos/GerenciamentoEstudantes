package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.serializacao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
public abstract class HibernateProxyMixin {
}
