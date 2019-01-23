package com.desafio.agibank.importalotes.infrastructure.dto;

public class ReportDto {

    private Integer clientsAmount;
    private Integer salesmanAmount;
    private String saleIdMoreExpensive;
    private String worstSeller;
    private String fileName;

    public static class Builder {

        private Integer clientsAmount;
        private Integer salesmanAmount;
        private String saleIdMoreExpensive;
        private String worstSeller;
        private String fileName;

        public Builder totalCustomers(Integer clientsAmount) {
            this.clientsAmount = clientsAmount;
            return this;
        }

        public Builder totalSalesman(Integer salesmanAmount) {
            this.salesmanAmount = salesmanAmount;
            return this;
        }

        public Builder saleIdMoreExpensive(String saleIdMoreExpensive) {
            this.saleIdMoreExpensive = saleIdMoreExpensive;
            return this;
        }

        public Builder worstSeller(String worstSeller) {
            this.worstSeller = worstSeller;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public ReportDto build() {
            return new ReportDto(this);
        }
    }

    private ReportDto(Builder builder) {
        this.clientsAmount = builder.clientsAmount;
        this.salesmanAmount = builder.salesmanAmount;
        this.saleIdMoreExpensive = builder.saleIdMoreExpensive;
        this.worstSeller = builder.worstSeller;
        this.fileName = builder.fileName;
    }

    public Integer getClientsAmount() {
        return clientsAmount;
    }

    public void setClientsAmount(Integer clientsAmount) {
        this.clientsAmount = clientsAmount;
    }

    public Integer getSalesmanAmount() {
        return salesmanAmount;
    }

    public void setSalesmanAmount(Integer salesmanAmount) {
        this.salesmanAmount = salesmanAmount;
    }

    public String getSaleIdMoreExpensive() {
        return saleIdMoreExpensive;
    }

    public void setSaleIdMoreExpensive(String saleIdMoreExpensive) {
        this.saleIdMoreExpensive = saleIdMoreExpensive;
    }

    public String getWorstSeller() {
        return worstSeller;
    }

    public void setWorstSeller(String worstSeller) {
        this.worstSeller = worstSeller;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
