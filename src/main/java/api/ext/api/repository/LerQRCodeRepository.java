package api.ext.api.repository;

import api.ext.api.model.LerQRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LerQRCodeRepository extends JpaRepository<LerQRCode, Long> {
    Optional<LerQRCode> findByCodigoLeituraQRCode(String codigoLeituraQRCode);

}
