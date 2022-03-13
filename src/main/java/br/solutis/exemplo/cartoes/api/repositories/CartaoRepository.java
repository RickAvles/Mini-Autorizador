package br.solutis.exemplo.cartoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.solutis.exemplo.cartoes.api.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String>{

}
