package br.com.SistemaHospitalar.classes;

import java.math.BigDecimal;

public class NotaFiscal {

    private Long id;
    private Fatura fatura;
    private String forma_pagamento;
    private BigDecimal iss;
    private BigDecimal pis;
    private BigDecimal cofins;
    private BigDecimal irpj;
    private BigDecimal csll;
    private BigDecimal valor_total;
    
    public NotaFiscal(Long id, Fatura fatura, String forma_pagamento, BigDecimal iss, BigDecimal pis,
            BigDecimal cofins, BigDecimal irpj, BigDecimal csll) {
        this.id = id;
        this.fatura = fatura;
        this.forma_pagamento = forma_pagamento;
        this.iss = iss;
        this.pis = pis;
        this.cofins = cofins;
        this.irpj = irpj;
        this.csll = csll;
    }

    @Override
    public String toString() {
        return "=========================================================================\n" +
               "                             NOTA FISCAL DE SERVIÇO                      \n" +
               "=========================================================================\n" +
               "Nota Fiscal Nº : " + this.id + "\n" +
               "Pagamento      : " + this.forma_pagamento + "\n" +
               "Dados da Fatura: " + this.fatura + "\n" +
               "-------------------------------------------------------------------------\n" +
               "RESUMO DOS IMPOSTOS RETIDOS:\n" +
               "ISS   (3,00%)  : R$ " + this.iss + "\n" +
               "PIS   (0,65%)  : R$ " + this.pis + "\n" +
               "COFINS(3,00%)  : R$ " + this.cofins + "\n" +
               "IRPJ  (1,20%)  : R$ " + this.irpj + "\n" +
               "CSLL  (1,08%)  : R$ " + this.csll + "\n" +
               "=========================================================================";
    }

    public Long getId() {
        return id;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public BigDecimal getIrpj() {
        return irpj;
    }

    public BigDecimal getCsll() {
        return csll;
    }

}