package br.com.zup.email.domain.repository;

import br.com.zup.email.domain.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
