package api.ext.api.model;

import api.ext.api.model.Request.LerQRCodeRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LerQRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private LerQRCodeRequest request;

    private boolean sucesso;
    private String mensagem;
    private String codigoLeituraQRCode;
}
