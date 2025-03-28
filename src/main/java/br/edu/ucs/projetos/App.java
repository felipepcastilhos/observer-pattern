package br.edu.ucs.projetos;

import br.edu.ucs.projetos.observer.*;

public class App {

    public static void main(String[] args) {
        // 1. Instanciar o equipamento de coleta de dados climáticos
        EquipamentoDeMonitoramento equipamento = new EquipamentoDeMonitoramento();

        // 2. Criar o objeto monitor que será o sujeito observável
        MonitorDeDadosDoClima monitor = new MonitorDeDadosDoClima(equipamento);
        equipamento.setMonitorDadosClima(monitor);

        // 3. Criar os displays (observadores)
        DisplayDeCondicoesAtuais displayCondicoes = new DisplayDeCondicoesAtuais();
        DisplayEstatistico displayEstatistico = new DisplayEstatistico();

        // 4. Registrar os displays no monitor
        monitor.registraObservador(displayCondicoes);
        monitor.registraObservador(displayEstatistico);

        // 5. Iniciar a coleta de dados
        try {
            equipamento.coletar(); // isso simula os dados mudando 10 vezes
        } catch (InterruptedException e) {
            System.out.println("Erro na simulação de coleta: " + e.getMessage());
        }
    }
}
