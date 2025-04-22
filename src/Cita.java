public class Cita {
    private String client;
    private String dataHora;
    private String servei;

    public Cita(String _client, String _dataHora, String _servei) {
        if (_client == null || _client.isBlank()) {
            throw new IllegalArgumentException("El nom del client no pot estar buit");
        }
        this.client = _client;
        this.dataHora = _dataHora;
        this.servei = _servei;
    }

    public String getClient() {
        return client;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getServei() {
        return servei;
    }

    @Override
    public String toString() {
        return  "Client: " + client + " | " +
                "Data: " + dataHora + " | " +
                "Servei: " + servei;
    }
}