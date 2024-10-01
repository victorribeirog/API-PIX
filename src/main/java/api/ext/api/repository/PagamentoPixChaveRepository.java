package api.ext.api.repository;
import api.ext.api.model.PagamentoPixChave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PagamentoPixChaveRepository extends JpaRepository<PagamentoPixChave, Long> {
    Optional<PagamentoPixChave> findByIdempotencyKey(String idempotencyKey);
}
